package lesson36.demo;

import lesson36.controller.RoomController;
import lesson36.model.Filter;
import lesson36.model.User;
import lesson36.model.types.UserType;

import java.lang.reflect.Field;
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

        Map<String, String> parametersMap = new LinkedHashMap<>();
        parametersMap.put("id", "101");
        parametersMap.put("userName", "test2");


        sb.add("1001,admin,admin,UA,ADMIN");
        sb.add("1002,admin,admin,UA,ADMIN");
        sb.add("1003,Vasya,1111,RU,USER");
        sb.add("1004,Vasya1,1111,RU,USER");


        Class c = User.class;

        for(String userData : sb){
            boolean mapped = false;
            String[] dataLine = userData.split(",");


            for(String field : parametersMap.keySet()) {
                int index = getFieldIndex(c, field);
                System.out.println(parametersMap.get(field));
                mapped = parametersMap.get(field).equals(dataLine[index]);
            }

            if(mapped)
                System.out.println(Arrays.toString(dataLine));

        }

        System.out.println(Arrays.toString(getObjectByParameters(new LinkedHashMap<Integer, String>(){{put(0, "1003");}}, sb)));
    }

    static int getFieldIndex(Class c, String fieldName) throws Exception{
        int index = 0;
        for(Field f : c.getDeclaredFields())
            if(f.getName().equals(fieldName))
                return index;
        throw new Exception("no field with name "+fieldName+" was found in class "+c.getName());
    }

    static String[] getObjectByParameters(Map<Integer, String> parametersMap, ArrayList<String> sb) throws Exception{
        for(String line : sb) {
            boolean mapped = false;
            String[] dataLine = line.split(",");

            for (Integer index : parametersMap.keySet())
                mapped = parametersMap.values().toArray()[index].equals(dataLine[index]);

            if (mapped)
                return dataLine;
        }
        return null;
    }
}
