package lesson36.controller;

import lesson36.exception.UnexpectedException;
import lesson36.model.Hotel;
import lesson36.service.HotelService;

import java.util.Set;

public class HotelController {
    private HotelService hotelService;

    public HotelController() throws UnexpectedException{
        hotelService = new HotelService();
    }

    //ADMIN
    public Hotel addHotel(Hotel hotel) throws UnexpectedException {
        return hotelService.addHotel(hotel);
    }

    //ADMIN
    public void deleteHotel(long hotelId) throws UnexpectedException {
        hotelService.deleteHotel(hotelId);
    }

    public Set<Hotel> findHotelByName(String name) throws UnexpectedException {
        return hotelService.findHotelByName(name);
    }

    public Set<Hotel> findHotelByCity(String name) throws UnexpectedException {
        return hotelService.findHotelByCity(name);
    }

}
