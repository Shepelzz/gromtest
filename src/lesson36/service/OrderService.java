package lesson36.service;

import lesson36.dao.OrderDAO;
import lesson36.dao.RoomDAO;
import lesson36.exception.BadRequestException;
import lesson36.exception.InternalServerError;
import lesson36.model.Room;

import java.util.Date;

public class OrderService {
    private OrderDAO orderDao;

    public OrderService() throws InternalServerError{
        orderDao = new OrderDAO();
    }

    public void bookRoom(long roomId, long userId, double moneyPaid) throws InternalServerError {
        if(orderDao.getOrderByRoomAndUser(roomId, userId) != null)
            throw new BadRequestException("bookRoom", "Order room id:"+roomId+" is already booked by user id:"+userId+"");

        Room room = new RoomDAO().getEntityById(roomId);
        if(room == null)
            throw new BadRequestException("bookRoom", "Room with id:"+roomId+" was not found");
        if(room.getDateAvailableFrom().after(new Date()))
            throw new BadRequestException("bookRoom", "Order room id:"+roomId+" is reserved from "+room.getDateAvailableFrom());
        if(room.getPrice() > moneyPaid)
            throw new BadRequestException("bookRoom", "Order money paid is not enough" );

        orderDao.bookRoom(roomId, userId, moneyPaid);
    }

    public void cancelReservation(long roomId, long userId) throws InternalServerError {
        if(orderDao.getOrderByRoomAndUser(roomId, userId) == null)
            throw new BadRequestException("cancelReservation", "There is no order for room id:"+roomId+" and user id:"+userId);

        orderDao.cancelReservation(roomId, userId);
    }
}
