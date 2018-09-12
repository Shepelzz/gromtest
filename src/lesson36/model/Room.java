package lesson36.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Room extends Entity {
    private int numberOfGuests;
    private double price;
    private boolean breakfastIncluded;
    private boolean petsAllowed;
    private Date dateAvailableFrom;
    private Hotel hotel;

    private Room(){}

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
    public String toString() {
        return
            (getId() == 0 ? "" : getId()+",")+
            numberOfGuests+","+
            price+","+
            breakfastIncluded+","+
            petsAllowed+","+
            new SimpleDateFormat("dd-MM-yyyy").format(dateAvailableFrom)+","+
            hotel.getId();
    }

//    public static RoomBuilder newRoomBuilder(){
//        return new Room().new RoomBuilder();
//    }
//
//    public class RoomBuilder {
//        private RoomBuilder(){}
//
//        public RoomBuilder setId(long id){
//            Room.this.setId(id);
//            return this;
//        }
//
//        public RoomBuilder setNumberOfGuests(int numberOfGuests) {
//            Room.this.numberOfGuests = numberOfGuests;
//            return this;
//        }
//
//        public RoomBuilder setPrice(double price) {
//            Room.this.price = price;
//            return this;
//        }
//
//        public RoomBuilder setBreakfastIncluded(boolean breakfastIncluded) {
//            Room.this.breakfastIncluded = breakfastIncluded;
//            return this;
//        }
//
//        public RoomBuilder setPetsAllowed(boolean petsAllowed) {
//            Room.this.petsAllowed = petsAllowed;
//            return this;
//        }
//
//        public RoomBuilder setHotel(Hotel hotel) {
//            Room.this.hotel = hotel;
//            return this;
//        }
//
//        public RoomBuilder parseStringToObject(String input) throws InternalServerError {
//            String[] data = input.split(",");
//            try {
//                setId(Long.valueOf(data[0]));
//                numberOfGuests = Integer.valueOf(data[1]);
//                price = Double.valueOf(data[2]);
//                breakfastIncluded = Boolean.valueOf(data[3]);
//                petsAllowed = Boolean.valueOf(data[4]);
//                dateAvailableFrom = new SimpleDateFormat("dd-MM-yyyy").parse(data[5]);
//                hotel = new HotelDAO().getEntityById(Long.valueOf(data[6]));
//                return this;
//            }catch (Exception e){
//                throw new InternalServerError(getClass().getName(), "parseStringToObject","error parsing text data ["+input+"]", e.getMessage());
//            }
//        }
//
//        public Room build(){
//            return Room.this;
//        }
//    }
}
