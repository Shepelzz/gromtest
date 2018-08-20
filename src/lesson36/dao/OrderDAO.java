package lesson36.dao;

import lesson36.exception.DAOException;
import lesson36.model.Order;

import java.util.Calendar;
import java.util.Date;

public class OrderDAO extends GeneralDAO<Order>{
    private static final String path = "src/lesson36/files/OrderDb.txt";

    public void bookRoom(long roomId, long userId, double moneyPaid) throws DAOException {
        Calendar c = Calendar.getInstance();
        Date currentDate = new Date();
        c.setTime(currentDate);
        c.add(Calendar.DATE, 3);

//        writeToFile(new Order(
//            randomId(),
//            new UserDAO().getUserById(userId),
//            new RoomDAO().getRoomById(roomId),
//            currentDate,
//            c.getTime(),
//            moneyPaid
//        ));
    }

    public void cancelReservation(long roomId, long userId){

    }

//    public Order getOrderById(long id) throws DAOException{
//            String[] data = getDataById(id, path);
//                    if(data == null)
//                        return null;
//        return parseToObjectOrder(getDataById(id, path));
//    }

//    private Order parseToObjectOrder(String[] input) throws DAOException {
//        try{
//            return new Order(
//                Long.valueOf(input[0]),
//                new UserDAO().getUserById(Long.valueOf(input[1])),
//                new RoomDAO().getRoomById(Long.valueOf(input[2])),
//                Date.valueOf(input[3]),
//                input[4],
//                Double.valueOf(input[5])
//            );
//        }catch (Exception e){
//            throw new DAOException(e.getMessage());
//        }
//    }

}
