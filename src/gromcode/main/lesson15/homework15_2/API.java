package gromcode.main.lesson15.homework15_2;

public interface API {

    Room[] findRooms(int price, int persons, String city, String hotel);

    Room[] getAll();

}
