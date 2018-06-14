package lesson15.homework15_2;

public class Controller {
    private API[] apis;

    public Controller(API[] apis) {
        this.apis = apis;
    }

    public Room[] requestRooms(int price, int persons, String city, String hotel){
        int countRooms = 0;
        for(API api : apis) {
            if(api != null)
                countRooms += api.findRooms(price, persons, city, hotel).length;
        }
        Room[] validRooms = new Room[countRooms];
        int validRoomsIndex = 0;
        for(API api : apis){
            if(api != null){
                for(Room room : api.findRooms(price, persons, city, hotel)) {
                    validRooms[validRoomsIndex] = room;
                    validRoomsIndex++;
                }
            }
        }
        return distinctRooms(validRooms);
    }

    public Room[] check(API api1, API api2){
        if(api1 == null || api2 == null)
            return null;

        int countRooms = 0;
        for(Room roomAPI1 : api1.getAll()){
            for(Room roomAPI2 : api2.getAll()){
                if(roomAPI1.equals(roomAPI2) && roomAPI1.hashCode() == roomAPI2.hashCode()){
                    countRooms++;
                }
            }
        }
        Room[] similarRooms = new Room[countRooms];
        int similarRoomsIndex = 0;
        for(Room roomAPI1 : api1.getAll()){
            for(Room roomAPI2 : api2.getAll()){
                if(roomAPI1.equals(roomAPI2) && roomAPI1.hashCode() == roomAPI2.hashCode()){
                    similarRooms[similarRoomsIndex] = roomAPI1;
                    similarRoomsIndex++;
                }
            }
        }
        return similarRooms;
    }

    private Room[] distinctRooms(Room[] rooms){
        Room[] sourceList = rooms;
        for(int i = 0; i < rooms.length; i++){
            for(int j = i-1; j >= 0 && j < i; j--){
                if(rooms[i].equals(rooms[j]) && rooms[i].hashCode() == rooms[j].hashCode()){
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
}
