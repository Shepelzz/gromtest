package lesson36.service;

import lesson36.dao.OrderDAO;
import lesson36.exception.DAOException;
import lesson36.exception.ServiceException;
import lesson36.model.Order;

public class OrderService {
    private OrderDAO orderDao = new OrderDAO();

    public void bookRoom(long roomId, long userId, double moneyPaid) throws DAOException, ServiceException{
        orderDao.bookRoom(roomId, userId, moneyPaid);
    }

    public void cancelReservation(long roomId, long userId){
        orderDao.cancelReservation(roomId, userId);
    }

    private void validate(Order order) throws ServiceException {
//        if(hotel.getName().equals(""))
//            throw new ServiceException("Hotel adding error: name can not be empty");
//        if(hotel.getCountry().equals(""))
//            throw new ServiceException("Hotel adding error: country can not be empty");
//        if(hotel.getCity().equals(""))
//            throw new ServiceException("Hotel adding error: city can not be empty");
//        if(hotel.getStreet().equals(""))
//            throw new ServiceException("Hotel adding error: street can not be empty");
    }
}
