package lesson36.dao;

import lesson36.exception.DAOException;
import lesson36.model.Order;
import lesson36.model.Room;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class OrderDAO extends GeneralDAO<Order>{
    private static final String path = "src/lesson36/files/OrderDb.txt";

    public void bookRoom(long roomId, long userId, double moneyPaid) throws DAOException {
        Calendar c = Calendar.getInstance();
        Date currentDate = new Date();
        c.setTime(currentDate);
        c.add(Calendar.DATE, 3);

        RoomDAO roomDAO = new RoomDAO();
        UserDAO userDAO = new UserDAO();

        writeToFile(new Order(
            userDAO.getUserById(userId),
            roomDAO.getRoomById(roomId),
            new Date(),
            c.getTime(),
            moneyPaid
        ), path);

        Room updatedRoom = roomDAO.getRoomById(roomId);
        updatedRoom.setDateAvailableFrom(c.getTime());

        roomDAO.replaceRoomById(roomId, updatedRoom);
    }

    public void cancelReservation(long roomId, long userId) throws DAOException{
        Order order = findOrderByRoomAndUser(roomId, userId);
        if(order == null)
            throw new DAOException("Cancel reservation error: no order with room (id:"+roomId+") and user (id:"+userId+") was found");
        deleteFromFileById(order.getId(), path);

        RoomDAO roomDAO = new RoomDAO();
        Room updatedRoom = roomDAO.getRoomById(roomId);
        updatedRoom.setDateAvailableFrom(new Date());

        roomDAO.replaceRoomById(roomId, updatedRoom);
    }

    public Order findOrderByRoomAndUser(long roomId, long userId) throws DAOException{
        for(String[] dataLine : readFromFile(path)){
            Order order = parseToObjectOrder(dataLine);
            if(order.getRoom().getId() == roomId && order.getUser().getId() == userId)
                return order;
        }
        return null;
    }

    public Order getOrderById(long id) throws DAOException {
        String[] data = getDataById(id, path);
        if(data == null)
            return null;
        return parseToObjectOrder(getDataById(id, path));
    }

    private Order parseToObjectOrder(String[] input) throws DAOException {
        try{
            return new Order(
                Long.valueOf(input[0]),
                new UserDAO().getUserById(Long.valueOf(input[1])),
                new RoomDAO().getRoomById(Long.valueOf(input[2])),
                new SimpleDateFormat("dd-MM-yyyy").parse(input[3]),
                new SimpleDateFormat("dd-MM-yyyy").parse(input[4]),
                Double.valueOf(input[5])
            );
        }catch (Exception e){
            throw new DAOException(e.getMessage());
        }
    }

}
