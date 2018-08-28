package lesson36.controller;

import lesson36.exception.UnexpectedException;
import lesson36.service.OrderService;

public class OrderController {
    private OrderService orderService;

    public OrderController() throws UnexpectedException{
        orderService = new OrderService();
    }

    public void bookRoom(long roomId, long userId, double moneyPaid) throws UnexpectedException {
        orderService.bookRoom(roomId, userId, moneyPaid);
    }

    public void cancelReservation(long roomId, long userId) throws UnexpectedException {
        orderService.cancelReservation(roomId, userId);
    }
}
