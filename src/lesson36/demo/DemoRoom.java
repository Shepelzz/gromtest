package lesson36.demo;

import lesson36.controller.RoomController;
import lesson36.model.Filter;

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

    }
}
