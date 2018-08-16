package lesson36.dao;

import lesson36.model.Hotel;

import java.util.HashSet;
import java.util.Set;

public class HotelDAO {
    private static final String path = "src/lesson36/files/HotelDb.txt";
    private GeneralDAO<Hotel> generalDao = new GeneralDAO<>(path);

    //ADMIN
    public Hotel addHotel(Hotel hotel) throws Exception{
        return generalDao.writeToFile(new Hotel(generalDao.randomId(), hotel.getName(), hotel.getCountry(), hotel.getCity(), hotel.getStreet()));
    }

    //ADMIN
    public void deleteHotel(long hotelId) throws Exception{
        generalDao.deleteFromFile(getHotelById(hotelId));
    }

    public Set<Hotel> findHotelByName(String name) throws Exception{
        Set<Hotel> result = new HashSet<>();
        long index = 1;
        for(String line : generalDao.readFromFile()){
            Hotel h = getValidHotel(line, index++);
            if(h.getName().equals(name))
                result.add(h);
        }
        return result;
    }

    public Set<Hotel> findHotelByCity(String name) throws Exception{
        Set<Hotel> result = new HashSet<>();
        long index = 1;
        for(String line : generalDao.readFromFile()){
            Hotel h = getValidHotel(line, index++);
            if(h.getCity().equals(name))
                result.add(h);
        }
        return result;
    }

    public Hotel getHotelById(long id) throws Exception{
        long index = 1;
        for(String line : generalDao.readFromFile()){
            Hotel h = getValidHotel(line, index++);
            if(h.getId() == id)
                return h;
        }
        throw new Exception("Hotel id was not found");
    }

//    public Set<Hotel> tempGetHotels() throws Exception{
//        Set<Hotel> result = new HashSet<>();
//        long index = 1;
//        for(String line : generalDao.readFromFile()){
//            Hotel h = getValidHotel(line, index++);
//            result.add(h);
//        }
//        return result;
//    }

    private Hotel getValidHotel(String inputLine, long lineIndex) throws Exception{
        String[] hotelValues = inputLine.split(",");

        if(hotelValues.length != Hotel.class.getDeclaredFields().length)
            throw new Exception("Hotel data is not valid. Line: '"+inputLine+"'");

        try {
            return new Hotel(
                Long.valueOf(hotelValues[0]),
                hotelValues[1].trim(),
                hotelValues[2].trim(),
                hotelValues[3].trim(),
                hotelValues[4].trim()
            );
        }catch (Exception e){
            System.err.println("Can not read data. "+e.getMessage()+" Line: "+lineIndex);
        }
        return null;
    }


}
