package lesson36.service;

import lesson36.dao.OrderDAO;

public class OrderService {
    private OrderDAO orderDao = new OrderDAO();

    public void bookRoom(long roomId, long userId, long hotelId) throws Exception{
        orderDao.bookRoom(roomId, userId, hotelId);
    }

    public void cancelReservation(long roomId, long userId){
        orderDao.cancelReservation(roomId, userId);
    }
}
