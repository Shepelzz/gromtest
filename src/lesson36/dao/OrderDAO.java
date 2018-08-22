package lesson36.dao;

import lesson36.exception.UnexpectedException;
import lesson36.model.Order;
import lesson36.model.Room;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;

public class OrderDAO extends GeneralDAO<Order>{
    private static final String path = "src/lesson36/files/OrderDb.txt";

    public OrderDAO() {
        super(Order.class, path);
    }

    public void bookRoom(long roomId, long userId, double moneyPaid) throws UnexpectedException {
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
        ));

        Room updatedRoom = roomDAO.getRoomById(roomId);
        updatedRoom.setDateAvailableFrom(c.getTime());

        roomDAO.replaceRoomById(roomId, updatedRoom);
    }

    public void cancelReservation(long roomId, long userId) throws UnexpectedException{
        RoomDAO roomDAO = new RoomDAO();

        Order order = getOrderByRoomAndUser(roomId, userId);
        deleteFromFileById(order.getId());

        Room updatedRoom = roomDAO.getRoomById(roomId);
        updatedRoom.setDateAvailableFrom(new Date());

        roomDAO.replaceRoomById(roomId, updatedRoom);
    }

    public Order getOrderById(long id) throws UnexpectedException {
        String[] data = getObjectByParameters(new LinkedHashMap<String, String>(){{put("id", String.valueOf(id));}});
        if(data == null)
            return null;
        return parseToObject(data);
    }

    public Order getOrderByRoomAndUser(long roomId, long userId) throws UnexpectedException{
        String[] data = getObjectByParameters(new LinkedHashMap<String, String>(){{
            put("room", String.valueOf(roomId)); put("user", String.valueOf(userId));
        }});

        if(data == null)
            return null;
        return parseToObject(data);
    }

    private Order parseToObject(String[] input) throws UnexpectedException {
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
            throw new UnexpectedException(e.getMessage());
        }
    }

}
