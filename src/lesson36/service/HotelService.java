package lesson36.service;

import lesson36.dao.UserDAO;
import lesson36.exception.DAOException;
import lesson36.exception.ServiceException;
import lesson36.model.Hotel;
import lesson36.dao.HotelDAO;
import lesson36.model.types.UserType;

import java.util.Set;

public class HotelService{
    private HotelDAO hotelDAO = new HotelDAO();

    //ADMIN
    public Hotel addHotel(Hotel hotel) throws ServiceException{

        if(!UserDAO.getLoggedUser().getUserType().equals(UserType.ADMIN))
            throw new ServiceException("Add hotel error: Only ADMIN can perform this operation");

        validate(hotel);
        try {
            return hotelDAO.addHotel(hotel);
        }catch (DAOException e){
            throw new ServiceException(e.getMessage());
        }
    }

    //ADMIN
    public void deleteHotel(long hotelId) throws ServiceException{

        if(!UserDAO.getLoggedUser().getUserType().equals(UserType.ADMIN))
            throw new ServiceException("Delete hotel error: Only ADMIN can perform this operation");
        try {
            hotelDAO.getHotelById(hotelId);
            hotelDAO.deleteHotel(hotelId);
        }catch (DAOException e){
            throw new ServiceException(e.getMessage());
        }
    }

    public Set<Hotel> findHotelByName(String name) throws ServiceException {
        if(name.equals(""))
            throw new ServiceException("Find hotel by name error: name can not be empty");

        try {
            return hotelDAO.findHotelByName(name);
        }catch (DAOException e){
            throw new ServiceException(e.getMessage());
        }
    }

    public Set<Hotel> findHotelByCity(String name) throws ServiceException{
        if(name.equals(""))
            throw new ServiceException("Find hotel by city error: City can not be empty");

        try {
            return hotelDAO.findHotelByCity(name);
        }catch (DAOException e){
            throw new ServiceException(e.getMessage());
        }
    }

    private void validate(Hotel hotel) throws ServiceException{
        if(hotel.getName().equals(""))
            throw new ServiceException("Validation error: Hotel name can not be empty");
        if(hotel.getCountry().equals(""))
            throw new ServiceException("Validation error: Hotel country can not be empty");
        if(hotel.getCity().equals(""))
            throw new ServiceException("Validation error: Hotel city can not be empty");
        if(hotel.getStreet().equals(""))
            throw new ServiceException("Validation error: Hotel street can not be empty");
    }
}
