package lesson36.controller;

import lesson36.dao.Session;
import lesson36.exception.InternalServerError;
import lesson36.service.OrderService;

public class OrderController {
    private OrderService orderService;

    public OrderController() throws InternalServerError {
        orderService = new OrderService();
    }

    public void bookRoom(long roomId, long userId, double moneyPaid) throws InternalServerError {
        Session.checkAuthorization();
        orderService.bookRoom(roomId, userId, moneyPaid);
    }

    public void cancelReservation(long roomId, long userId) throws InternalServerError {
        Session.checkAuthorization();
        orderService.cancelReservation(roomId, userId);
    }
}
