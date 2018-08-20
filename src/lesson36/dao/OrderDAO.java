package lesson36.dao;

import lesson36.exception.DAOException;
import lesson36.model.Order;
import lesson36.model.Room;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;

public class OrderDAO extends GeneralDAO<Order>{
    private static final String path = "src/lesson36/files/OrderDb.txt";

    public void bookRoom(long roomId, long userId, double moneyPaid) throws DAOException {
        RoomDAO roomDAO = new RoomDAO();
        UserDAO userDAO = new UserDAO();

        Calendar c = Calendar.getInstance();
        Date currentDate = new Date();
        c.setTime(currentDate);
        c.add(Calendar.DATE, 3);

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
        RoomDAO roomDAO = new RoomDAO();
        String[] data = getOrderByParameters(roomId, userId);
        if(data == null)
            throw new DAOException("Cancel reservation error: no order with room (id:"+roomId+") and user (id:"+userId+") was found");

        deleteFromFileById(parseToObject(data).getId(), path);

        Room updatedRoom = roomDAO.getRoomById(roomId);
        updatedRoom.setDateAvailableFrom(new Date());

        roomDAO.replaceRoomById(roomId, updatedRoom);
    }

    public String[] getOrderByParameters(long roomId, long userId) throws DAOException{
        return getObjectByParameters(new LinkedHashMap<Integer, String>(){{
            put(2, String.valueOf(roomId)); put(1, String.valueOf(userId));
        }}, path);
    }

    public Order getOrderById(long id) throws DAOException {
        String[] data = getObjectByParameters(new LinkedHashMap<Integer, String>(){{put(0, String.valueOf(id));}}, path);
        if(data == null)
            return null;
        return parseToObject(data);
    }

    private Order parseToObject(String[] input) throws DAOException {
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
