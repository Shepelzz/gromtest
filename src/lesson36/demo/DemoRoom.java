package lesson36.demo;

import lesson36.controller.RoomController;
import lesson36.model.Filter;

import java.util.*;

public class DemoRoom {
    public static void main(String[] args) throws Exception{
        RoomController roomController = new RoomController();

        Filter filter = new Filter(0, 0, true, false, new Date(), null, null, "Kiev");
        //roomController.findRooms(filter);


        //roomController.deleteRoom(4587729999860716510L);

//        roomController.addRoom(new Room(
//            3,
//            4555,
//            true,
//            true,
//            new Date(),
//            new HotelDAO().getHotelById(26540059603440722L)
//        ));



//        System.out.println(new SimpleDateFormat("dd-MM-yyyy").parse("20-02-2018"));
//
//
//        String dt = "18-08-2018";
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
//        Date date = simpleDateFormat.parse(dt);
//        System.out.println(date);
//
//        System.out.println(new SimpleDateFormat("dd-MM-yyyy").parse("18-08-2018"));




        ArrayList<String> sb = new ArrayList<>();

        Map<Integer, String> parametersMap = new LinkedHashMap<>();
        parametersMap.put(0, "101");
        parametersMap.put(1, "test2");


        sb.add("100,test1");
        sb.add("101,test2");
        sb.add("102,test3");
        sb.add("103,test4");




        for(String line : sb){
            String[] dataLine = line.split(",");
            System.out.println(line);
            for(Integer index : parametersMap.keySet()) {
                System.out.println(parametersMap.values().toArray()[index]+" = "+dataLine[index]);
                if(!parametersMap.values().toArray()[index].equals(dataLine[index]))
                    break;
            }
            System.out.println("---------");
        }




    }
}
