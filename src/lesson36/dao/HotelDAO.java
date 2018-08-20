package lesson36.dao;

import lesson36.exception.DAOException;
import lesson36.model.Hotel;

import java.util.HashSet;
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
        for(String[] lineElements : getDataByElement(1, name, path))
            result.add(parseToObjectHotel(lineElements));
        return result;
    }

    public Set<Hotel> findHotelByCity(String name) throws DAOException{
        Set<Hotel> result = new HashSet<>();
        for(String[] lineElements : getDataByElement(3, name, path))
            result.add(parseToObjectHotel(lineElements));
        return result;
    }

    public Hotel getHotelById(long id) throws DAOException {
        String[] data = getDataById(id, path);
        if(data == null)
            return null;
        return parseToObjectHotel(getDataById(id, path));
    }

    private Hotel parseToObjectHotel(String[] input) throws DAOException {
        try{
            return new Hotel(
                    Long.valueOf(input[0]),
                    input[1],
                    input[2],
                    input[3],
                    input[4]
            );
        }catch (Exception e){
            throw new DAOException(e.getMessage());
        }
    }
}
