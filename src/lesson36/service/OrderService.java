package lesson36.service;

import lesson36.dao.OrderDAO;

public class OrderService {
    private OrderDAO orderDao = new OrderDAO();

    public void bookRoom(long roomId, long userId, double moneyPaid) throws Exception{

        //

        orderDao.bookRoom(roomId, userId, moneyPaid);
    }

    public void cancelReservation(long roomId, long userId){
        orderDao.cancelReservation(roomId, userId);
    }
}
