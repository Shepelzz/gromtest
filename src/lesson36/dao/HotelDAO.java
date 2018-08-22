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
        Set<Hotel> result = new HashSet<>();
        Set<String[]> data = getObjectsByParameters(new LinkedHashMap<String, String>(){{put("name", name);}});

        for(String[] dataElement : data)
            result.add(parseToObject(dataElement));
        return result;
    }

    public Set<Hotel> findHotelByCity(String name) throws UnexpectedException{
        Set<Hotel> result = new HashSet<>();
        Set<String[]> data = getObjectsByParameters(new LinkedHashMap<String, String>(){{put("city", name);}});

        for(String[] lineElements : data)
            result.add(parseToObject(lineElements));
        return result;
    }

    public Hotel getHotelById(long id) throws UnexpectedException {
        String[] data = getObjectByParameters(new LinkedHashMap<String, String>(){{put("id", String.valueOf(id));}});
        if(data == null)
            return null;
        return parseToObject(data);
    }

    private Hotel parseToObject(String[] input) throws UnexpectedException {
        try{
            return new Hotel(
                    Long.valueOf(input[0]),
                    input[1],
                    input[2],
                    input[3],
                    input[4]
            );
        }catch (Exception e){
            throw new UnexpectedException(e.getMessage());
        }
    }
}
