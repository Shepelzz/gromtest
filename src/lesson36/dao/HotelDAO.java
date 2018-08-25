package lesson36.dao;

import lesson36.exception.UnexpectedException;
import lesson36.model.Hotel;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

public class HotelDAO extends GeneralDAO<Hotel>{
    private static final String path = "src/lesson36/files/HotelDb.txt";

    public HotelDAO() {
        super(Hotel.class, path);
    }

    //ADMIN
    public Hotel addHotel(Hotel hotel) throws UnexpectedException {
        return writeToFile(hotel);
    }

    //ADMIN
    public void deleteHotel(long hotelId) throws UnexpectedException{
        deleteFromFileById(hotelId);
    }

    public Set<Hotel> findHotelByName(String name) throws UnexpectedException{
        return getObjectsByParameters(new LinkedHashMap<String, String>(){{put("name", name);}});
    }

    public Set<Hotel> findHotelByCity(String name) throws UnexpectedException{
        return getObjectsByParameters(new LinkedHashMap<String, String>(){{put("city", name);}});
    }

    public Hotel getHotelById(long id) throws UnexpectedException {
        return getObjectByParameters(new LinkedHashMap<String, String>(){{put("id", String.valueOf(id));}});
    }

    @Override
    public Hotel parseStringToObject(String input) {
        return new Hotel(input);
    }

    @Override
    public String parseObjectToString(Hotel hotel) {
        return hotel.toString();
    }
}
