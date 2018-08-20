package lesson36.demo;

import lesson36.controller.HotelController;
import lesson36.dao.HotelDAO;
import lesson36.model.Hotel;

import java.util.Date;

public class DemoHotel {
    public static void main(String[] args) throws Exception{
        HotelController hotelController = new HotelController();
        System.out.println(hotelController.findHotelByCity("Odessa"));

        System.out.println(hotelController.findHotelByName("Hotel 3"));

    }

}
