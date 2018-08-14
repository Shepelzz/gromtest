package lesson36.controller;

import lesson36.model.Hotel;
import lesson36.service.HotelService;

import java.util.Set;

public class HotelController {
    private HotelService hotelService = new HotelService();

    //ADMIN
    public Hotel addHotel(Hotel hotel) throws Exception{
        return hotelService.addHotel(hotel);
    }

    //ADMIN
    public void deleteHotel(long hotelId) throws Exception{
        hotelService.deleteHotel(hotelId);
    }

    public Set<Hotel> findHotelByName(String name) throws Exception{
        return hotelService.findHotelByName(name);
    }

    public Set<Hotel> findHotelByCity(String name) throws Exception{
        return hotelService.findHotelByCity(name);
    }

}
