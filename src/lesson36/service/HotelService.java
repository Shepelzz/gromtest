package lesson36.service;

import lesson36.dao.HotelDAO;
import lesson36.exception.BadRequestException;
import lesson36.exception.InternalServerError;
import lesson36.model.Hotel;

import java.util.Set;

public class HotelService{
    private HotelDAO hotelDAO;

    public HotelService() {
        hotelDAO = new HotelDAO();
    }

    //ADMIN
    public Hotel addHotel(Hotel hotel) throws InternalServerError {
        if(hotel.getName().equals("") || hotel.getCountry().equals("") || hotel.getCity().equals("") || hotel.getStreet().equals(""))
            throw new BadRequestException("addHotel", "Values can not be empty");
        return hotelDAO.addHotel(hotel);
    }

    //ADMIN
    public void deleteHotel(long hotelId) throws InternalServerError {
        hotelDAO.deleteHotel(hotelId);
    }

    public Set<Hotel> findHotelByName(String name) throws InternalServerError {
        if(name.equals(""))
            throw new BadRequestException("findHotelByName", "Name can not be empty");

        return hotelDAO.findHotelByName(name);
    }

    public Set<Hotel> findHotelByCity(String name) throws InternalServerError {
        if(name.equals(""))
            throw new BadRequestException("findHotelByCity", "City can not be empty");

        return hotelDAO.findHotelByCity(name);
    }
}
