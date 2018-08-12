package gromcode.main.lesson15.homework15_2;

public class GoogleAPI implements API {
    private Room[] rooms;

    public GoogleAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        Room checkedRoom = new Room(0001, price, persons, null, hotel, city);
        int roomsCount = 0;
        Room[] roomsFound;
        for(Room room : rooms) {
            if (room.equals(checkedRoom) && room.hashCode() == checkedRoom.hashCode())
                roomsCount++;
        }
        roomsFound = new Room[roomsCount];

        int index = 0;
        for(Room room : rooms) {
            if (room.equals(checkedRoom) && room.hashCode() == checkedRoom.hashCode()) {
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
}
