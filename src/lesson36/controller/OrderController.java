package lesson36.controller;

import lesson36.service.OrderService;

public class OrderController {
    private OrderService orderService = new OrderService();

    public void bookRoom(long roomId, long userId, long hotelId) throws Exception{
        orderService.bookRoom(roomId, userId, hotelId);
    }

    public void cancelReservation(long roomId, long userId){
        orderService.cancelReservation(roomId, userId);
    }
}
