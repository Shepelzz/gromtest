package lesson36.dao;

import lesson36.exception.UnexpectedException;
import lesson36.model.Hotel;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

public class HotelDAO extends GeneralDAO<Hotel>{
    private static final String path = "src/lesson36/files/HotelDb.txt";

    public HotelDAO() {
        super(path);
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
        return getEntitiesByParameters(new LinkedHashMap<String, String>(){{put("name", name);}});
    }

    public Set<Hotel> findHotelByCity(String name) throws UnexpectedException{
        return getEntitiesByParameters(new LinkedHashMap<String, String>(){{put("city", name);}});
    }

    @Override
    public Hotel parseStringToObject(String input) {
        return new Hotel(input);
    }

    @Override
    public String parseObjectToString(Hotel hotel) {
        return hotel.toString();
    }

    @Override
    public Field[] getDeclaredFields() {
        return Hotel.class.getDeclaredFields();
    }
}
