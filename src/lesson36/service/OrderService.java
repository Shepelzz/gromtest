package lesson36.service;

import lesson36.dao.OrderDAO;
import lesson36.dao.RoomDAO;
import lesson36.exception.BadRequestException;
import lesson36.exception.UnexpectedException;
import lesson36.model.Room;

import java.util.Date;

public class OrderService {
    private OrderDAO orderDao = new OrderDAO();

    public void bookRoom(long roomId, long userId, double moneyPaid) throws BadRequestException, UnexpectedException{
        validate(roomId, userId, moneyPaid);
        orderDao.bookRoom(roomId, userId, moneyPaid);
    }

    public void cancelReservation(long roomId, long userId) throws UnexpectedException{
        orderDao.cancelReservation(roomId, userId);
    }

    private void validate(long roomId, long userId, double moneyPaid) throws BadRequestException, UnexpectedException {
        if(orderDao.getOrderByRoomAndUser(roomId, userId) != null)
            throw new BadRequestException("Validation error: Order room id:"+roomId+" is already booked by user id:"+userId+"");

        Room room = new RoomDAO().getRoomById(roomId);;
        if(room.getDateAvailableFrom().after(new Date()))
            throw new BadRequestException("Validation error: Order room id:"+roomId+" is not available from "+room.getDateAvailableFrom());
        if(room.getPrice() > moneyPaid)
            throw new BadRequestException("Validation error: Order money paid is not enough" );
    }
}
