package lesson36.demo;

import lesson36.controller.HotelController;
import lesson36.dao.HotelDAO;

public class DemoHotel {
    public static void main(String[] args) throws Exception{
        HotelController hotelController = new HotelController();
        HotelDAO hotelDAO = new HotelDAO();

//        try{
//            hotelController.deleteHotel(7311701335048307041L);
//        }catch (Exception e){
//            System.err.println(e.getMessage());
//        }

//        try{
////            Hotel hotel = new Hotel("InterContinental", "Ukraine", "Kiev", "test");
////            hotelDAO.addHotel(hotel);
//            for(Hotel h : hotelDAO.findHotelByName("InterContinental"))
//                System.out.println(h.toString());
//
//            System.out.println();
//
//            for(Hotel h : hotelDAO.findHotelByCity("Odessa"))
//                System.out.println(h.toString());
//
//            System.out.println();
//
//            for(Hotel h : hotelDAO.tempGetHotels())
//                System.out.println(h.toString());
//        }catch (Exception e){
//            System.err.println(e.getMessage());
//        }

//        Order o = new Order(
//                121233456,
//                new User(11111, "User1", "pass", "UA", UserType.ADMIN),
//                new Room(22222, 3, 5600.78, true, true, new Date(), new Hotel(3411111, "InterContinental", "Ukraine", "Kiev", "test")),
//                new Date(),
//                new Date(),
//                5600.9
//            );
//        System.out.println(o.toString());
    }

}
