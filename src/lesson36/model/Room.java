package lesson36.model;

import lesson36.dao.HotelDAO;
import lesson36.exception.UnexpectedException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Room extends Entity<Room> {
    private long id;
    private int numberOfGuests;
    private double price;
    private boolean breakfastIncluded;
    private boolean petsAllowed;
    private Date dateAvailableFrom;
    private Hotel hotel;

    public Room(){}

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

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setBreakfastIncluded(boolean breakfastIncluded) {
        this.breakfastIncluded = breakfastIncluded;
    }

    public void setPetsAllowed(boolean petsAllowed) {
        this.petsAllowed = petsAllowed;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
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

    @Override
    public Room parseStringToObject(String input) throws UnexpectedException {
        String[] data = input.split(",");
        try {
            id = Long.valueOf(data[0]);
            numberOfGuests = Integer.valueOf(data[1]);
            price = Double.valueOf(data[2]);
            breakfastIncluded = Boolean.valueOf(data[3]);
            petsAllowed = Boolean.valueOf(data[4]);
            dateAvailableFrom = new SimpleDateFormat("dd-MM-yyyy").parse(data[5]);
            hotel = new HotelDAO().getEntityById(Long.valueOf(data[6]));
            return this;
        }catch (Exception e){
            throw new UnexpectedException(getClass().getName()+". Parsing. error parsing text data ["+input+"]");
        }
    }
}
