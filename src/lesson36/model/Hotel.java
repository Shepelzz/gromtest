package lesson36.model;

import lesson36.exception.UnexpectedException;

public class Hotel extends Entity {
    private String name;
    private String country;
    private String city;
    private String street;

    public Hotel(){}

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

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public Hotel parseStringToObject(String input) throws UnexpectedException {
        String[] data = input.split(",");
        try {
            setId(Long.valueOf(data[0]));
            name = data[1];
            country = data[2];
            city = data[3];
            street = data[4];
            return this;
        }catch (Exception e){
            throw new UnexpectedException(getClass().getName()+". Parsing. error parsing text data ["+input+"]");
        }
    }

    @Override
    public String toString() {
        return
            (getId() == 0 ? "" : getId()+",")+
            name+","+
            country+","+
            city+","+
            street;
    }
}
