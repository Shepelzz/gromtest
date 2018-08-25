package lesson36.model;

import lesson36.exception.BadRequestException;

public class Hotel extends GeneralModel implements Comparable<Hotel> {
    private long id;
    private String name;
    private String country;
    private String city;
    private String street;

    public Hotel(long id, String name, String country, String city, String street){
        this.id = id;
        this.name = name;
        this.country = country;
        this.city = city;
        this.street = street;
    }

    public Hotel(String name, String country, String city, String street){
        this.name = name;
        this.country = country;
        this.city = city;
        this.street = street;
    }

    public Hotel(String textData) {
        String[] data = textData.split(",");
        try {
            id = Long.valueOf(data[0]);
            name = data[1];
            country = data[2];
            city = data[3];
            street = data[4];
        }catch (Exception e){
            throw new BadRequestException(getClass().getName(), "Parsing", "error parsing text data ["+textData+"]");
        }
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return
            (id == 0 ? "" : id+",")+
            name+","+
            country+","+
            city+","+
            street;
    }

    @Override
    public int compareTo(Hotel hotel) {
        return (int) (this.id-hotel.getId());
    }
}
