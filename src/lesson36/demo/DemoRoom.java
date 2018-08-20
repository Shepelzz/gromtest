package lesson36.demo;

import lesson36.controller.RoomController;
import lesson36.model.Filter;

import java.util.ArrayList;
import java.util.Date;

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


        int[] parameterNumbers = {0,1};
        String[] parameters = {"101","test"};
        ArrayList<String> sb = new ArrayList<>();
        sb.add("100,test1");
        sb.add("101,test2");
        sb.add("102,test3");
        sb.add("103,test4");


        for(String line : sb){
            boolean mapped = false;
            String[] dataLine = line.split(",");

            for(int col : parameterNumbers)
                mapped = dataLine[col].equals(parameters[col]);

            if(mapped) {
                System.out.println(line);
                break;
            }
        }



    }
}
