package lesson36.demo;

import lesson36.controller.HotelController;
import lesson36.dao.HotelDAO;
import lesson36.model.Hotel;

import java.util.Date;

public class DemoHotel {
    public static void main(String[] args) throws Exception{
        HotelController hotelController = new HotelController();

//        Hotel hotel = new Hotel("testtesttest", "RU", "Moscow", "lenina 3");
//        hotelController.addHotel(hotel);


        Date date = null;
        System.out.println(date);

        java.sql.Date sqlDate = null;
        sqlDate.valueOf("02-02-2018");
        System.out.println(sqlDate);
    }

}
