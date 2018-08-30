package lesson36.service;

import lesson36.dao.OrderDAO;
import lesson36.dao.RoomDAO;
import lesson36.dao.Session;
import lesson36.exception.BadRequestException;
import lesson36.exception.UnexpectedException;
import lesson36.model.Room;

import java.util.Date;

public class OrderService {
    private OrderDAO orderDao;

    public OrderService() throws UnexpectedException{
        orderDao = new OrderDAO();
    }

    public void bookRoom(long roomId, long userId, double moneyPaid) throws UnexpectedException{
        Session.checkAuthorization();
        if(orderDao.getOrderByRoomAndUser(roomId, userId) != null)
            throw new BadRequestException("Book room", "Validation", "Order room id:"+roomId+" is already booked by user id:"+userId+"");

        Room room = new RoomDAO().getEntityById(roomId);
        if(room == null)
            throw new BadRequestException("Book room", "Validation", "Room with id:"+roomId+" was not found");
        if(room.getDateAvailableFrom().after(new Date()))
            throw new BadRequestException("Book room", "Validation", "Order room id:"+roomId+" is not available from "+room.getDateAvailableFrom());
        if(room.getPrice() > moneyPaid)
            throw new BadRequestException("Book room", "Validation", "Order money paid is not enough" );

        orderDao.bookRoom(roomId, userId, moneyPaid);
    }

    public void cancelReservation(long roomId, long userId) throws UnexpectedException{
        Session.checkAuthorization();
        if(orderDao.getOrderByRoomAndUser(roomId, userId) == null)
            throw new BadRequestException("Cancel reservation", "Validation", "There is no order for room id:"+roomId+" and user id:"+userId);

        orderDao.cancelReservation(roomId, userId);
    }
}
