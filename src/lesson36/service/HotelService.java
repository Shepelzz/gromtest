package lesson36.service;

import lesson36.dao.HotelDAO;
import lesson36.dao.UserDAO;
import lesson36.exception.BadRequestException;
import lesson36.exception.UnexpectedException;
import lesson36.model.Hotel;
import lesson36.model.types.UserType;

import java.util.Set;

public class HotelService{
    private HotelDAO hotelDAO = new HotelDAO();

    //ADMIN
    public Hotel addHotel(Hotel hotel) throws BadRequestException, UnexpectedException {

        if(!UserDAO.getLoggedUser().getUserType().equals(UserType.ADMIN))
            throw new BadRequestException("Add hotel error: Only ADMIN can perform this operation");

        validate(hotel);
        return hotelDAO.addHotel(hotel);
    }

    //ADMIN
    public void deleteHotel(long hotelId) throws BadRequestException, UnexpectedException{
        if(!UserDAO.getLoggedUser().getUserType().equals(UserType.ADMIN))
            throw new BadRequestException("Delete hotel error: Only ADMIN can perform this operation");

        hotelDAO.deleteHotel(hotelId);

    }

    public Set<Hotel> findHotelByName(String name) throws BadRequestException, UnexpectedException {
        if(name.equals(""))
            throw new BadRequestException("Find hotel by name error: name can not be empty");

        return hotelDAO.findHotelByName(name);
    }

    public Set<Hotel> findHotelByCity(String name) throws BadRequestException, UnexpectedException{
        if(name.equals(""))
            throw new BadRequestException("Find hotel by city error: City can not be empty");

        return hotelDAO.findHotelByCity(name);
    }

    private void validate(Hotel hotel) throws BadRequestException{
        if(hotel.getName().equals(""))
            throw new BadRequestException("Validation error: Hotel name can not be empty");
        if(hotel.getCountry().equals(""))
            throw new BadRequestException("Validation error: Hotel country can not be empty");
        if(hotel.getCity().equals(""))
            throw new BadRequestException("Validation error: Hotel city can not be empty");
        if(hotel.getStreet().equals(""))
            throw new BadRequestException("Validation error: Hotel street can not be empty");
    }
}
