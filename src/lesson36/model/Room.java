package lesson36.model;

import lesson36.dao.HotelDAO;
import lesson36.exception.BadRequestException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Room extends GeneralModel {
    private long id;
    private int numberOfGuests;
    private double price;
    private boolean breakfastIncluded;
    private boolean petsAllowed;
    private Date dateAvailableFrom;
    private Hotel hotel;

    public Room(long id, int numberOfGuests, double price, boolean breakfastIncluded, boolean petsAllowed, Date dateAvailableFrom, Hotel hotel) {
        this.id = id;
        this.numberOfGuests = numberOfGuests;
        this.price = price;
        this.breakfastIncluded = breakfastIncluded;
        this.petsAllowed = petsAllowed;
        this.dateAvailableFrom = dateAvailableFrom;
        this.hotel = hotel;
    }

    public Room(int numberOfGuests, double price, boolean breacfastIncluded, boolean petsAllowed, Date dateAvailableFrom, Hotel hotel) {
        this.numberOfGuests = numberOfGuests;
        this.price = price;
        this.breakfastIncluded = breacfastIncluded;
        this.petsAllowed = petsAllowed;
        this.dateAvailableFrom = dateAvailableFrom;
        this.hotel = hotel;
    }

    public Room(String textData) {
        String[] data = textData.split(",");
        try {
            id = Long.valueOf(data[0]);
            numberOfGuests = Integer.valueOf(data[1]);
            price = Double.valueOf(data[2]);
            breakfastIncluded = Boolean.valueOf(data[3]);
            petsAllowed = Boolean.valueOf(data[4]);
            dateAvailableFrom = new SimpleDateFormat("dd-MM-yyyy").parse(data[5]);
            hotel = new HotelDAO().getHotelById(Long.valueOf(data[6]));
        }catch (Exception e){
            throw new BadRequestException(getClass().getName(), "Parsing", "error parsing text data ["+textData+"]");
        }
    }

    public long getId() {
        return id;
    }

    public void setDateAvailableFrom(Date dateAvailableFrom) {
        this.dateAvailableFrom = dateAvailableFrom;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public double getPrice() {
        return price;
    }

    public boolean isBreakfastIncluded() {
        return breakfastIncluded;
    }

    public boolean isPetsAllowed() {
        return petsAllowed;
    }

    public Date getDateAvailableFrom() {
        return dateAvailableFrom;
    }

    public Hotel getHotel() {
        return hotel;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return
            (id == 0 ? "" : id+",")+
            numberOfGuests+","+
            price+","+
            breakfastIncluded+","+
            petsAllowed+","+
            new SimpleDateFormat("dd-MM-yyyy").format(dateAvailableFrom)+","+
            hotel.getId();
    }

}
