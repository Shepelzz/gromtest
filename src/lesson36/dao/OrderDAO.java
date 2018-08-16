package lesson36.dao;

import lesson36.model.Order;

public class OrderDAO {
    private static final String path = "src/lesson36/files/OrderDb.txt";
    private GeneralDAO<Order> generalDao = new GeneralDAO<>(path);

    public void bookRoom(long roomId, long userId, long hotelId) throws Exception{ //зачем hotel id?
//        generalDao.writeToFile(new Order(
//            generalDao.randomId(),
//            new UserDAO().getUserById(userId),
//            new RoomDAO().getRoomById(roomId),
//
//
//
//
//        ));
    }

    public void cancelReservation(long roomId, long userId){

    }

}
