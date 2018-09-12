package lesson36.dao;

import lesson36.exception.InternalServerError;
import lesson36.model.Entity;
import lesson36.model.Order;
import lesson36.model.Room;
import lesson36.model.User;

import java.util.Calendar;
import java.util.Date;

public class OrderDAO extends GeneralDAO<Order>{
    private static final String path = "files/OrderDb.txt";

    public OrderDAO() {
        super(path);
    }

    public void bookRoom(long roomId, long userId, double moneyPaid) throws InternalServerError {
        RoomDAO roomDAO = new RoomDAO();

        Calendar c = Calendar.getInstance();
        Date currentDate = new Date();
        c.setTime(currentDate);
        c.add(Calendar.DATE, 3);

        Entity user = User.newUserBuilder().setId(userId).build();
        Entity room = Room.newRoomBuilder().setId(roomId).build();
        Room updatedRoom = roomDAO.getEntityById(roomId);

        writeToFile(Order.newOrderBuilder()
                .setUser((User) user)
                .setRoom((Room) room)
                .setDateFrom(new Date())
                .setDateTo(c.getTime())
                .setMoneyPaid(moneyPaid)
                .build()
        );

        updatedRoom.setDateAvailableFrom(c.getTime());
        roomDAO.updateEntity(updatedRoom);
    }

    public void cancelReservation(long roomId, long userId) throws InternalServerError {
        RoomDAO roomDAO = new RoomDAO();

        Room updatedRoom = roomDAO.getEntityById(roomId);
        updatedRoom.setDateAvailableFrom(new Date());

        roomDAO.updateEntity(updatedRoom);
        deleteFromFileById(getOrderByRoomAndUser(roomId, userId).getId());
    }

    public Order getOrderByRoomAndUser(long roomId, long userId) throws InternalServerError {
        for(Order order : getAll())
            if(order.getRoom().getId() == roomId && order.getUser().getId() == userId)
                return order;
        return null;
    }

    @Override
    public Order parseStringToObject(String input) throws InternalServerError {
        return Order.newOrderBuilder().parseStringToObject(input).build();
    }
}
