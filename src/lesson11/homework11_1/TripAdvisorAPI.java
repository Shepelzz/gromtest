package lesson11.homework11_1;

public class TripAdvisorAPI implements API {
    private Room[] rooms;

    public TripAdvisorAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int roomsCount = 0;
        Room[] roomsFound;
        for(Room room : rooms) {
            if (checkingTripAdvisorRoomSearchCondition(room, price, persons, city, hotel))
                roomsCount++;
        }
        roomsFound = new Room[roomsCount];

        int index = 0;
        for(Room room : rooms) {
            if (checkingTripAdvisorRoomSearchCondition(room, price, persons, city, hotel)) {
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

    private boolean checkingTripAdvisorRoomSearchCondition(Room room, int price, int persons, String city, String hotel){
        if(     room != null
                && persons >= (room.getPersons()-1 < 0 ? 0 : room.getPersons()-1)
                && persons <= room.getPersons()+1
                && room.getPrice() == price
                && room.getCityName() == city
                && room.getHotelName() == hotel){
            return true;
        }
        return false;
    }
}
