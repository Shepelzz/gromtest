package gromcode.main.lesson11.homework11_1;

public interface API {

    Room[] findRooms(int price, int persons, String city, String hotel);

    Room[] getAll();

}