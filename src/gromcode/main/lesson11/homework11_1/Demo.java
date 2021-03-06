package gromcode.main.lesson11.homework11_1;

import java.util.Arrays;
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
        API[] apis2 = new API[]{null, null, null};

        Controller controller = new Controller(apis);
        Controller controller2 = new Controller(apis2);

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


        //-----------------------------------------------------------------------
        System.out.println("\n\n-----------------------------------------------------------------------");
        //testing requestRooms(int price, int persons, String city, String hotel)
        System.out.println("testing requestRooms(int price, int persons, String city, String hotel)");
        //1. nullable city/hotel
        System.out.println("nullable city/hotel");
        System.out.println(Arrays.toString(controller.requestRooms(550, 4, null, null)));
        //2. city/hotel not in list
        System.out.println("city/hotel not in list");
        System.out.println(Arrays.toString(controller.requestRooms(550, 4, "Magadan", "Hotel15")));
        //3. apis nullable
        System.out.println("apis nullable");
        System.out.println(Arrays.toString(controller2.requestRooms(550, 4, "Kyiv", "Hotel1")));
        //4 null parameters in room
        System.out.println("null parameters in room");
        Room r505 = new Room(101, 111, 2, new Date(), null, null);
        API bookingComAPI1 = new BookingComAPI(new Room[]{r505});
        API tripAdvisorAPI1 = new TripAdvisorAPI(new Room[]{r505});
        API googleAPI1 = new GoogleAPI(new Room[]{r505});
        Controller controller1 = new Controller(new API[]{bookingComAPI1, tripAdvisorAPI1, googleAPI1});
        System.out.println(Arrays.toString(controller1.requestRooms(111, 2, "Kyiv", "Hotel1")));


        //testing check(API api1, API api2)
        System.out.println("testing check(API api1, API api2)");
        //1. apis == null
        System.out.println("apis == null");
        System.out.println(Arrays.toString(controller.check(null, null)));
        //2. check algorithm
        System.out.println("check algorithm");
        Room r101 = new Room(101, 123, 2, new Date(), "Hotel1", "Kyiv");
        Room r102 = new Room(102, 55, 1, new Date(), "Hotel1", "Kyiv");
        Room r201 = new Room(101, 123, 2, new Date(), "Hotel1", "Kyiv");

        API bookingComAPI_test = new BookingComAPI(new Room[]{r101, r102});
        API tripAdvisorAPI_test = new TripAdvisorAPI(new Room[]{r201});
        API googleAPI_test = new GoogleAPI(new Room[]{r102, r201});
        Controller controller_test = new Controller(new API[]{bookingComAPI_test, tripAdvisorAPI_test, googleAPI_test});
        System.out.println(Arrays.toString(controller_test.check(bookingComAPI_test, googleAPI_test)));
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
