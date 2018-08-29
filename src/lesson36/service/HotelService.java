package lesson36.service;

import lesson36.dao.HotelDAO;
import lesson36.exception.BadRequestException;
import lesson36.exception.UnexpectedException;
import lesson36.model.Hotel;
import lesson36.model.types.UserType;

import java.util.Set;

public class HotelService{
    private HotelDAO hotelDAO;

    public HotelService() throws UnexpectedException{
        hotelDAO = new HotelDAO();
    }

    //ADMIN
    public Hotel addHotel(Hotel hotel) throws UnexpectedException {
        UserService.checkAuthorization();
        if(!UserService.getLoggedUser().getUserType().equals(UserType.ADMIN))
            throw new BadRequestException("Add hotel", "Access", "Only ADMIN can perform this operation");

        if(hotel.getName().equals("") || hotel.getCountry().equals("") || hotel.getCity().equals("") || hotel.getStreet().equals(""))
            throw new BadRequestException("Add hotel", "Validation", "Value can not be empty");

        return hotelDAO.addHotel(hotel);
    }

    //ADMIN
    public void deleteHotel(long hotelId) throws UnexpectedException{
        UserService.checkAuthorization();
        if(!UserService.getLoggedUser().getUserType().equals(UserType.ADMIN))
            throw new BadRequestException("Delete hotel", "Access", "Only ADMIN can perform this operation");

        hotelDAO.deleteHotel(hotelId);

    }

    public Set<Hotel> findHotelByName(String name) throws UnexpectedException {
        UserService.checkAuthorization();
        if(name.equals(""))
            throw new BadRequestException("Find hotel by name", "Validation", "Name can not be empty");

        return hotelDAO.findHotelByName(name);
    }

    public Set<Hotel> findHotelByCity(String name) throws UnexpectedException{
        UserService.checkAuthorization();
        if(name.equals(""))
            throw new BadRequestException("Find hotel by city", "Validation", "City can not be empty");

        return hotelDAO.findHotelByCity(name);
    }
}
