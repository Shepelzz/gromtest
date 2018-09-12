package lesson36.model;

import lesson36.dao.RoomDAO;
import lesson36.dao.UserDAO;
import lesson36.exception.InternalServerError;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Order extends Entity {
    private User user;
    private Room room;
    private Date dateFrom;
    private Date dateTo;
    private double moneyPaid;

    private Order(){}

    public User getUser() {
        return user;
    }

    public Room getRoom() {
        return room;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public double getMoneyPaid() {
        return moneyPaid;
    }

    @Override
    public String toString() {
        return
                (getId() == 0 ? "" : getId()+",")+
                        user.getId()+","+
                        room.getId()+","+
                        new SimpleDateFormat("dd-MM-yyyy").format(dateFrom)+","+
                        new SimpleDateFormat("dd-MM-yyyy").format(dateTo)+","+
                        moneyPaid;
    }

    public static Order.OrderBuilder newOrderBuilder(){
        return new lesson36.model.Order().new OrderBuilder();
    }

    public class OrderBuilder{
        private OrderBuilder(){}

        public OrderBuilder setId(long id) {
            Order.this.setId(id);
            return this;
        }

        public OrderBuilder setUser(User user) {
            Order.this.user = user;
            return this;
        }

        public OrderBuilder setRoom(Room room) {
            Order.this.room = room;
            return this;
        }

        public OrderBuilder setDateFrom(Date dateFrom) {
            Order.this.dateFrom = dateFrom;
            return this;
        }

        public OrderBuilder setDateTo(Date dateTo) {
            Order.this.dateTo = dateTo;
            return this;
        }

        public OrderBuilder setMoneyPaid(double moneyPaid) {
            Order.this.moneyPaid = moneyPaid;
            return this;
        }

        public OrderBuilder parseStringToObject(String input) throws InternalServerError {
            String[] data = input.split(",");
            try {
                setId(Long.valueOf(data[0]));
                user = new UserDAO().getEntityById(Long.valueOf(data[1]));
                room = new RoomDAO().getEntityById(Long.valueOf(data[2]));
                dateFrom = new SimpleDateFormat("dd-MM-yyyy").parse(data[3]);
                dateTo = new SimpleDateFormat("dd-MM-yyyy").parse(data[4]);
                moneyPaid = Double.valueOf(data[5]);
                return this;
            }catch (Exception e){
                throw new InternalServerError(getClass().getName(), "parseStringToObject","error parsing text data ["+input+"]", e.getMessage());
            }
        }

        public Order build(){
            return Order.this;
        }
    }
}