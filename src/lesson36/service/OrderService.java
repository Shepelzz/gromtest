package lesson36.service;

import lesson36.dao.OrderDAO;
import lesson36.dao.RoomDAO;
import lesson36.exception.DAOException;
import lesson36.exception.ServiceException;
import lesson36.model.Room;

import java.util.Date;

public class OrderService {
    private OrderDAO orderDao = new OrderDAO();

    public void bookRoom(long roomId, long userId, double moneyPaid) throws DAOException, ServiceException{
        validate(roomId, userId, moneyPaid);
        orderDao.bookRoom(roomId, userId, moneyPaid);
    }

    public void cancelReservation(long roomId, long userId) throws DAOException{
        orderDao.cancelReservation(roomId, userId);
    }

    private void validate(long roomId, long userId, double moneyPaid) throws DAOException, ServiceException {
        Room room = new RoomDAO().getRoomById(roomId);
        if(room.getDateAvailableFrom().after(new Date()))
            throw new ServiceException("Booking error: room (id:"+roomId+") is not available from "+room.getDateAvailableFrom());
        if(room.getPrice() < moneyPaid)
            throw new ServiceException("Booking error: not enough money paid" );
        if(orderDao.findOrderByRoomAndUser(roomId, userId) != null)
            throw new ServiceException("Booking error: room (id:"+roomId+") is already booked by user (id:"+userId+")");
    }
}
