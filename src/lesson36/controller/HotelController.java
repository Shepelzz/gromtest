package lesson36.controller;

import lesson36.exception.ServiceException;
import lesson36.model.Hotel;
import lesson36.service.HotelService;

import java.util.Set;

public class HotelController {
    private HotelService hotelService = new HotelService();

    //ADMIN
    public Hotel addHotel(Hotel hotel) throws ServiceException {
        return hotelService.addHotel(hotel);
    }

    //ADMIN
    public void deleteHotel(long hotelId) throws ServiceException{
        hotelService.deleteHotel(hotelId);
    }

    public Set<Hotel> findHotelByName(String name) throws ServiceException{
        return hotelService.findHotelByName(name);
    }

    public Set<Hotel> findHotelByCity(String name) throws ServiceException{
        return hotelService.findHotelByCity(name);
    }

}
