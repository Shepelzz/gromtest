package lesson36.dao;

import lesson36.exception.UnexpectedException;
import lesson36.model.Order;
import lesson36.model.Room;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;

public class OrderDAO extends GeneralDAO<Order>{
    private static final String path = "src/lesson36/files/OrderDb.txt";

    public OrderDAO() {
        super(path);
    }

    public void bookRoom(long roomId, long userId, double moneyPaid) throws UnexpectedException {
        RoomDAO roomDAO = new RoomDAO();
        UserDAO userDAO = new UserDAO();

        Calendar c = Calendar.getInstance();
        Date currentDate = new Date();
        c.setTime(currentDate);
        c.add(Calendar.DATE, 3);

        writeToFile(new Order(
            userDAO.getEntityById(userId),
            roomDAO.getEntityById(roomId),
            new Date(),
            c.getTime(),
            moneyPaid
        ));

        Room updatedRoom = roomDAO.getEntityById(roomId);
        updatedRoom.setDateAvailableFrom(c.getTime());

        roomDAO.replaceRoomById(roomId, updatedRoom);
    }

    public void cancelReservation(long roomId, long userId) throws UnexpectedException{
        RoomDAO roomDAO = new RoomDAO();

        Room updatedRoom = roomDAO.getEntityById(roomId);
        updatedRoom.setDateAvailableFrom(new Date());

        roomDAO.replaceRoomById(roomId, updatedRoom);
        deleteFromFileById(getOrderByRoomAndUser(roomId, userId).getId());
    }

    public Order getOrderByRoomAndUser(long roomId, long userId) throws UnexpectedException{
        return getEntityByParameters(new LinkedHashMap<String, String>(){{
            put("room", String.valueOf(roomId)); put("user", String.valueOf(userId));
        }});
    }

    @Override
    public Order parseStringToObject(String input) {
        return new Order(input);
    }

    @Override
    public String parseObjectToString(Order order) {
        return order.toString();
    }

    @Override
    public Field[] getDeclaredFields() {
        return Order.class.getDeclaredFields();
    }
}
