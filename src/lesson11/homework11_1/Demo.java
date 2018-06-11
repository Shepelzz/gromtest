package lesson11.homework11_1;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Room r1 = new Room(1, 123, 2, new Date(), "Hotel1", "Kyiv");
        Room r2 = new Room(2, 55, 1, new Date(), "Hotel1", "Kyiv");
        Room r3 = new Room(3, 550, 4, new Date(), "Hotel1", "Kyiv");
        Room r4 = new Room(4, 600, 4, new Date(), "Hotel1", "Kyiv");
        Room r5 = new Room(5, 550, 9, new Date(), "Hotel1", "Kyiv");
        Room r6 = new Room(6, 1000, 5, new Date(), "Hotel1", "Kyiv");

        Room[] rooms1 = new Room[]{r1, r2, r3, r4, r5, r6};

        Room r7 = new Room(1, 123, 2, new Date(), "Hotel1", "Kyiv");
        Room r8 = new Room(2, 56, 7, new Date(), "Hotel1", "Kyiv");
        Room r9 = new Room(3, 7, 4, new Date(), "Hotel5", "Kyiv");
        Room r10 = new Room(4, 888, 1, new Date(), "Hotel5", "Kyiv");
        Room r11 = new Room(5, 550, 9, new Date(), "Hotel5", "Kyiv");
        Room r12 = new Room(6, 1000, 5, new Date(), "Hotel5", "Kyiv");

        Room[] rooms2 = new Room[]{r7, r8, r9, r10, r11, r12};

        BookingComAPI bookingComAPI = new BookingComAPI(rooms1);
        TripAdvisorAPI tripAdvisorAPI = new TripAdvisorAPI(rooms2);
        GoogleAPI googleAPI = new GoogleAPI(rooms1);

        API[] apis = new API[]{bookingComAPI, tripAdvisorAPI, googleAPI};

        Controller controller = new Controller(apis);
        Room[] requestrooms = controller.requestRooms(550, 4, "Kyiv", "Hotel1");
        Room[] similarRooms = controller.check(bookingComAPI, tripAdvisorAPI);


        System.out.println("Кол-во комнат: "+requestrooms.length);
        for(Room room : requestrooms){
            System.out.print("["+(room == null ? room : room.getId())+"]");
        }
        System.out.println();
        System.out.println("Кол-во комнат: "+similarRooms.length);
        for(Room room : similarRooms){
            System.out.print("["+(room == null ? room : room.getId())+"]");
        }


    }

    static int uniqueCount(int[] array){
        int countRepeat = 0;
        for(int i = 0; i < array.length; i++){
            for(int j = i+1; j < array.length; j++){
                if(array[i] == array[j]){
                    countRepeat++;
                    break;
                }
            }
        }
        return array.length - countRepeat;
    }
}
