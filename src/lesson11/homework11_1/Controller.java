package lesson11.homework11_1;

public class Controller {
    private API[] apis;

    public Controller(API[] apis) {
        this.apis = apis;
    }

    public Room[] requestRooms(int price, int persons, String city, String hotel){
        int countRooms = 0;
        for(API api : apis) {
            countRooms += api.findRooms(price, persons, city, hotel).length;
        }
        Room[] validRooms = new Room[countRooms];
        int validRoomsIndex = 0;
        for(API api : apis){
            for(Room room : api.findRooms(price, persons, city, hotel)) {
                validRooms[validRoomsIndex] = room;
                validRoomsIndex++;
            }
        }
        return distinctRooms(validRooms);
    }

    private Room[] distinctRooms(Room[] rooms){
        Room[] sourceList = rooms;
        for(int i = 0; i < rooms.length; i++){
            for(int j = i-1; j >= 0 && j < i; j--){
                if(rooms[i] == rooms[j]){
                    rooms[i] = null;
                    break;
                }
            }
        }

        int resultListCount = 0;
        for(Room r : sourceList){
            if(r != null)
                resultListCount++;
        }

        Room[] resultList = new Room[resultListCount];
        int resultListIndex = 0;
        for(Room r : sourceList){
            if(r != null){
                resultList[resultListIndex] = r;
                resultListIndex++;
            }
        }
        return resultList;
    }

    public Room[] check(API api1, API api2){
        int countRooms = 0;
        for(Room roomAPI1 : api1.getAll()){
            for(Room roomAPI2 : api2.getAll()){
                if(compareTwoRooms(roomAPI1, roomAPI2)){
                    countRooms++;
                }
            }
        }
        Room[] similarRooms = new Room[countRooms];
        int similarRoomsIndex = 0;
        for(Room roomAPI1 : api1.getAll()){
            for(Room roomAPI2 : api2.getAll()){
                if(compareTwoRooms(roomAPI1, roomAPI2)){
                    similarRooms[similarRoomsIndex] = roomAPI1;
                    similarRoomsIndex++;
                }
            }
        }

        return similarRooms;
    }

    private boolean compareTwoRooms(Room r1, Room r2){
        if(     r1.getPrice() == r2.getPrice()
                && r1.getHotelName() == r2.getHotelName()
                && r1.getCityName() == r2.getCityName()
                && r1.getPersons() == r2.getPersons())
            return true;
        return false;
    }
}
