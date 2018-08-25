package lesson36.model;

import lesson36.dao.RoomDAO;
import lesson36.dao.UserDAO;
import lesson36.exception.BadRequestException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Order extends GeneralModel{
    private long id;
    private User user;
    private Room room;
    private Date dateFrom;
    private Date dateTo;
    private double moneyPaid;

    public Order(long id, User user, Room room, Date dateFrom, Date dateTo, double moneyPaid) {
        this.id = id;
        this.user = user;
        this.room = room;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.moneyPaid = moneyPaid;
    }

    public Order(User user, Room room, Date dateFrom, Date dateTo, double moneyPaid) {
        this.user = user;
        this.room = room;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.moneyPaid = moneyPaid;
    }

    public Order(String textData) {
        String[] data = textData.split(",");
        try {
            id = Long.valueOf(data[0]);
            user = new UserDAO().getUserById(Long.valueOf(data[1]));
            room = new RoomDAO().getRoomById(Long.valueOf(data[2]));
            dateFrom = new SimpleDateFormat("dd-MM-yyyy").parse(data[3]);
            dateTo = new SimpleDateFormat("dd-MM-yyyy").parse(data[4]);
            moneyPaid = Double.valueOf(data[5]);
        }catch (Exception e){
            throw new BadRequestException(getClass().getName(), "Parsing", "error parsing text data ["+textData+"]");
        }
    }

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
