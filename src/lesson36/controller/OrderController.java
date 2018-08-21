package lesson36.controller;

import lesson36.exception.ServiceException;
import lesson36.service.OrderService;

public class OrderController {
    private OrderService orderService = new OrderService();

    public void bookRoom(long roomId, long userId, double moneyPaid) throws ServiceException{
        orderService.bookRoom(roomId, userId, moneyPaid);
    }

    public void cancelReservation(long roomId, long userId) throws ServiceException {
        orderService.cancelReservation(roomId, userId);
    }
}
