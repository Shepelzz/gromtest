package lesson36.controller;

import lesson36.dao.Session;
import lesson36.exception.InternalServerError;
import lesson36.model.Hotel;
import lesson36.model.types.UserType;
import lesson36.service.HotelService;

import java.util.Set;

public class HotelController {
    private HotelService hotelService;

    public HotelController() {
        hotelService = new HotelService();
    }

    //ADMIN
    public Hotel addHotel(Hotel hotel) throws InternalServerError {
        Session.checkAuthorization("addHotel", UserType.ADMIN);
        return hotelService.addHotel(hotel);
    }

    //ADMIN
    public void deleteHotel(long hotelId) throws InternalServerError {
        Session.checkAuthorization("deleteHotel", UserType.ADMIN);
        hotelService.deleteHotel(hotelId);
    }

    public Set<Hotel> findHotelByName(String name) throws InternalServerError {
        Session.checkAuthorization("findHotelByName");
        return hotelService.findHotelByName(name);
    }

    public Set<Hotel> findHotelByCity(String name) throws InternalServerError {
        Session.checkAuthorization("findHotelByCity");
        return hotelService.findHotelByCity(name);
    }

}
