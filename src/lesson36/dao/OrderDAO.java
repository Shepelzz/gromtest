package lesson36.dao;

import lesson36.model.Order;

import java.util.Calendar;
import java.util.Date;

public class OrderDAO {
    private static final String path = "src/lesson36/files/OrderDb.txt";
    private GeneralDAO<Order> generalDao = new GeneralDAO<>(path);

    public void bookRoom(long roomId, long userId, double moneyPaid) throws Exception{ //зачем hotel id?
        Calendar c = Calendar.getInstance();
        Date currentDate = new Date();
        c.setTime(currentDate);
        c.add(Calendar.DATE, 3);

        generalDao.writeToFile(new Order(
            generalDao.randomId(),
            new UserDAO().getUserById(userId),
            new RoomDAO().getRoomById(roomId),
            currentDate,
            c.getTime(),
            moneyPaid
        ));
    }

    public void cancelReservation(long roomId, long userId){

    }

}
