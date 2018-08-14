package lesson36.service;

import lesson36.model.Hotel;
import lesson36.dao.HotelDAO;

import java.util.Set;

public class HotelService {
    private HotelDAO hotelDAO = new HotelDAO();

    //ADMIN
    public Hotel addHotel(Hotel hotel) throws Exception{
        validate(hotel);
        return hotelDAO.addHotel(hotel);
    }

    //ADMIN
    public void deleteHotel(long hotelId) throws Exception{
        hotelDAO.deleteHotel(hotelId);
    }

    public Set<Hotel> findHotelByName(String name) throws Exception{
        if(name.equals(""))
            throw new Exception(getClass().getName()+". Hotel adding error: name can not be empty");
        return hotelDAO.findHotelByName(name);
    }

    public Set<Hotel> findHotelByCity(String name) throws Exception{
        if(name.equals(""))
            throw new Exception(getClass().getName()+". Hotel adding error: city can not be empty");
        return hotelDAO.findHotelByCity(name);
    }

    private void validate(Hotel hotel) throws Exception{
        if(hotel.getName().equals(""))
            throw new Exception(getClass().getName()+". Hotel adding error: name can not be empty");
        if(hotel.getCountry().equals(""))
            throw new Exception(getClass().getName()+". Hotel adding error: country can not be empty");
        if(hotel.getCity().equals(""))
            throw new Exception(getClass().getName()+". Hotel adding error: city can not be empty");
        if(hotel.getStreet().equals(""))
            throw new Exception(getClass().getName()+". Hotel adding error: street can not be empty");
    }
}
