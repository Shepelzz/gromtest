package lesson36.dao;

import lesson36.exception.DAOException;
import lesson36.exception.ObjectNotFoundException;
import lesson36.exception.ParsingException;
import lesson36.model.Hotel;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

public class HotelDAO extends GeneralDAO<Hotel>{
    private static final String path = "src/lesson36/files/HotelDb.txt";

    //ADMIN
    public Hotel addHotel(Hotel hotel) throws DAOException{
        return writeToFile(hotel, path);
    }

    //ADMIN
    public void deleteHotel(long hotelId) throws DAOException{
        deleteFromFileById(hotelId, path);
    }

    public Set<Hotel> findHotelByName(String name) throws DAOException{
        Set<Hotel> result = new HashSet<>();
        Set<String[]> data = getObjectsByParameters(new LinkedHashMap<String, String>(){{put("name", name);}}, Hotel.class, path);
//        if(data.isEmpty())
//            throw new ObjectNotFoundException("Hotel with name "+name+" was not found");

        for(String[] dataElement : data)
            result.add(parseToObject(dataElement));
        return result;
    }

    public Set<Hotel> findHotelByCity(String name) throws DAOException{
        Set<Hotel> result = new HashSet<>();
        Set<String[]> data = getObjectsByParameters(new LinkedHashMap<String, String>(){{put("city", name);}}, Hotel.class, path);
//        if(data.isEmpty())
//            throw new ObjectNotFoundException("Hotel with city "+name+" was not found");

        for(String[] lineElements : data)
            result.add(parseToObject(lineElements));
        return result;
    }

    public Hotel getHotelById(long id) throws DAOException {
        String[] data = getObjectByParameters(new LinkedHashMap<String, String>(){{put("id", String.valueOf(id));}}, Hotel.class, path);
        if(data == null)
            throw new ObjectNotFoundException("Hotel with id: "+id+" was not found");
        return parseToObject(data);
    }

    private Hotel parseToObject(String[] input) throws ParsingException {
        try{
            return new Hotel(
                    Long.valueOf(input[0]),
                    input[1],
                    input[2],
                    input[3],
                    input[4]
            );
        }catch (Exception e){
            throw new ParsingException(e.getMessage());
        }
    }
}
