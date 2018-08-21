package lesson36.service;

import lesson36.dao.OrderDAO;
import lesson36.dao.RoomDAO;
import lesson36.exception.DAOException;
import lesson36.exception.ObjectNotFoundException;
import lesson36.exception.ServiceException;
import lesson36.model.Room;

import java.util.Date;

public class OrderService {
    private OrderDAO orderDao = new OrderDAO();

    public void bookRoom(long roomId, long userId, double moneyPaid) throws  ServiceException{
        validate(roomId, userId, moneyPaid);
        try {
            orderDao.bookRoom(roomId, userId, moneyPaid);
        }catch (DAOException e){
            throw new ServiceException("Book room error: "+e.getMessage());
        }
    }

    public void cancelReservation(long roomId, long userId) throws ServiceException{
        try {
            orderDao.cancelReservation(roomId, userId);
        }catch (DAOException e){
            throw new ServiceException("Cancel reservation error: "+e.getMessage());
        }
    }

    private void validate(long roomId, long userId, double moneyPaid) throws ServiceException {
        Room room = null;
        try {
            room = new RoomDAO().getRoomById(roomId);
            orderDao.getOrderByRoomAndUser(roomId, userId);
        } catch (ObjectNotFoundException e){
            if(room.getDateAvailableFrom().after(new Date()))
                throw new ServiceException("Validation error: Order room id:"+roomId+" is not available from "+room.getDateAvailableFrom());
            if(room.getPrice() > moneyPaid)
                throw new ServiceException("Validation error: Order money paid is not enough" );

            return;
        } catch (DAOException e){
            throw new ServiceException("Validation error: "+e.getMessage());
        }
        throw new ServiceException("Validation error: Order room id:"+roomId+" is already booked by user id:"+userId+"");
    }
}
