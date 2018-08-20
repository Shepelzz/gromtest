package lesson36.demo;

import lesson36.controller.HotelController;
import lesson36.dao.HotelDAO;
import lesson36.model.Hotel;
import lesson36.model.User;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Date;

public class DemoHotel {
    public static void main(String[] args) throws Exception{
        HotelController hotelController = new HotelController();
//        System.out.println(hotelController.findHotelByCity("Odessa"));
//
//        System.out.println(hotelController.findHotelByName("Hotel 3"));

        test(User.class);
    }

    static void test(Class o){
        for(Field f : o.getDeclaredFields())
            System.out.println(f.getName());
    }


}
