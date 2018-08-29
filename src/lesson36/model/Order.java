package lesson36.model;

import lesson36.dao.RoomDAO;
import lesson36.dao.UserDAO;
import lesson36.exception.UnexpectedException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Order extends Entity<Order> {
    private long id;
    private User user;
    private Room room;
    private Date dateFrom;
    private Date dateTo;
    private double moneyPaid;

    public Order(){}

    public long getId() {
        return id;
    }

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
    public void setId(long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public void setMoneyPaid(double moneyPaid) {
        this.moneyPaid = moneyPaid;
    }

    @Override
    public Order parseStringToObject(String input) throws UnexpectedException {
        String[] data = input.split(",");
        try {
            id = Long.valueOf(data[0]);
            user = new UserDAO().getEntityById(Long.valueOf(data[1]));
            room = new RoomDAO().getEntityById(Long.valueOf(data[2]));
            dateFrom = new SimpleDateFormat("dd-MM-yyyy").parse(data[3]);
            dateTo = new SimpleDateFormat("dd-MM-yyyy").parse(data[4]);
            moneyPaid = Double.valueOf(data[5]);
            return this;
        }catch (Exception e){
            throw new UnexpectedException(getClass().getName()+". Parsing. error parsing text data ["+input+"]");
        }
    }

    @Override
    public String toString() {
        return
            (id == 0 ? "" : id+",")+
            user.getId()+","+
            room.getId()+","+
            new SimpleDateFormat("dd-MM-yyyy").format(dateFrom)+","+
            new SimpleDateFormat("dd-MM-yyyy").format(dateTo)+","+
            moneyPaid;
    }
}
