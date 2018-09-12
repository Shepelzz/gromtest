package lesson36.model;

import java.util.Date;

public class Filter {

    private int numberOfGuests = 0;
    private double price = 0.0;
    private boolean breakfastIncluded = false;
    private boolean petsAllowed = false;
    private Date dateAvailableFrom = null;
    private String name = null;
    private String country = null;
    private String city = null;

    private Filter() {}

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public double getPrice() {
        return price;
    }

    public boolean isBreakfastIncluded() {
        return breakfastIncluded;
    }

    public boolean isPetsAllowed() {
        return petsAllowed;
    }

    public Date getDateAvailableFrom() {
        return dateAvailableFrom;
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

//    public static FilterBuilder newFilterBuilder(){
//        return new Filter().new FilterBuilder();
//    }
//
//    public class FilterBuilder{
//        private FilterBuilder(){}
//
//        public FilterBuilder setNumberOfGuests(int numberOfGuests) {
//            Filter.this.numberOfGuests = numberOfGuests;
//            return this;
//        }
//
//        public FilterBuilder setPrice(double price) {
//            Filter.this.price = price;
//            return this;
//        }
//
//        public FilterBuilder setBreakfastIncluded(boolean breakfastIncluded) {
//            Filter.this.breakfastIncluded = breakfastIncluded;
//            return this;
//        }
//
//        public FilterBuilder setPetsAllowed(boolean petsAllowed) {
//            Filter.this.petsAllowed = petsAllowed;
//            return this;
//        }
//
//        public FilterBuilder setDateAvailableFrom(Date dateAvailableFrom) {
//            Filter.this.dateAvailableFrom = dateAvailableFrom;
//            return this;
//        }
//
//        public FilterBuilder setName(String name) {
//            Filter.this.name = name;
//            return this;
//        }
//
//        public FilterBuilder setCountry(String country) {
//            Filter.this.country = country;
//            return this;
//        }
//
//        public FilterBuilder setCity(String city) {
//            Filter.this.city = city;
//            return this;
//        }
//
//        public Filter build(){
//            return Filter.this;
//        }
//    }
}
