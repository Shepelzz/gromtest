package lesson36.controller;

import lesson36.dao.Session;
import lesson36.exception.InternalServerError;
import lesson36.model.Hotel;
import lesson36.service.HotelService;

import java.util.Set;

public class HotelController {
    private HotelService hotelService;

    public HotelController() throws InternalServerError {
        hotelService = new HotelService();
    }

    //ADMIN
    public Hotel addHotel(Hotel hotel) throws InternalServerError {
        Session.checkAuthorization();
        return hotelService.addHotel(hotel);
    }

    //ADMIN
    public void deleteHotel(long hotelId) throws InternalServerError {
        Session.checkAuthorization();
        hotelService.deleteHotel(hotelId);
    }

    public Set<Hotel> findHotelByName(String name) throws InternalServerError {
        Session.checkAuthorization();
        return hotelService.findHotelByName(name);
    }

    public Set<Hotel> findHotelByCity(String name) throws InternalServerError {
        Session.checkAuthorization();
        return hotelService.findHotelByCity(name);
    }

}
