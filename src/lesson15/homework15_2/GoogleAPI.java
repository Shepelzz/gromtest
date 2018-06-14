package lesson15.homework15_2;

public class GoogleAPI implements API {
    private Room[] rooms;

    public GoogleAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int roomsCount = 0;
        Room[] roomsFound;
        for(Room room : rooms) {
            if (checkingGoogleRoomSearchCondition(room, price, persons, city, hotel))
                roomsCount++;
        }
        roomsFound = new Room[roomsCount];

        int index = 0;
        for(Room room : rooms) {
            if (checkingGoogleRoomSearchCondition(room, price, persons, city, hotel)) {
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

    private boolean checkingGoogleRoomSearchCondition(Room room, int price, int persons, String city, String hotel){
        Room checkedRoom = new Room(0001, price, persons, null, hotel, city);

        if(room.equals(checkedRoom) && room.hashCode() == checkedRoom.hashCode()){
            return true;
        }
        return false;
    }
}
