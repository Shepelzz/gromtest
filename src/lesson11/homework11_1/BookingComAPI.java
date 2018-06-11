package lesson11.homework11_1;

public class BookingComAPI implements API {
    private Room[] rooms;

    public BookingComAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int roomsCount = 0;
        Room[] roomsFound;
        for(Room room : rooms) {
            if (checkingBookingComRoomSearchCondition(room, price, persons, city, hotel))
                roomsCount++;
        }
        roomsFound = new Room[roomsCount];

        int index = 0;
        for(Room room : rooms) {
            if (checkingBookingComRoomSearchCondition(room, price, persons, city, hotel)) {
                roomsFound[index] = room;
                index++;
            }
        }
        return roomsFound;
    }

    @Override
    public Room[] getAll() {
        return rooms;
    }

    private boolean checkingBookingComRoomSearchCondition(Room room, int price, int persons, String city, String hotel){
        if(     room != null
                && price >= (room.getPrice()-100 < 0 ? 0 : room.getPrice()-100)
                && price <= room.getPrice()+100
                && room.getPersons() == persons
                && room.getCityName() == city
                && room.getHotelName() == hotel){
            return true;
        }
        return false;
    }
}
