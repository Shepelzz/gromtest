package lesson36.model;

import lesson36.exception.InternalServerError;

public class Hotel extends Entity {
    private String name;
    private String country;
    private String city;
    private String street;

    private Hotel(){}

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
    public String toString() {
        return
            (getId() == 0 ? "" : getId()+",")+
            name+","+
            country+","+
            city+","+
            street;
    }

    public static HotelBuilder newHotelBuilder(){
        return new Hotel().new HotelBuilder();
    }

    public class HotelBuilder {
        private HotelBuilder() {}

        public HotelBuilder setId(long id){
            Hotel.this.setId(id);
            return this;
        }

        public HotelBuilder setName(String name) {
            Hotel.this.name = name;
            return this;
        }

        public HotelBuilder setCountry(String country) {
            Hotel.this.country = country;
            return this;
        }

        public HotelBuilder setCity(String city) {
            Hotel.this.city = city;
            return this;
        }

        public HotelBuilder setStreet(String street) {
            Hotel.this.street = street;
            return this;
        }

        public HotelBuilder parseStringToObject(String input) throws InternalServerError{
            String[] data = input.split(",");
            try {
                setId(Long.valueOf(data[0]));
                name = data[1];
                country = data[2];
                city = data[3];
                street = data[4];
                return this;
            }catch (Exception e){
                throw new InternalServerError(getClass().getName(), "parseStringToObject","error parsing text data ["+input+"]", e.getMessage());
            }
        }

        public Hotel build(){
            return Hotel.this;
        }
    }
}
