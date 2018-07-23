package lesson28;

import java.util.Date;

public class Capability implements Comparable<Capability>{
    private long id;
    private String channelName;
    private String fingerPrint;
    private boolean isActive;
    private Date dateCreated;

    public Capability(long id, String channelName, String fingerPrint, boolean isActive, Date dateCreated) {
        this.id = id;
        this.channelName = channelName;
        this.fingerPrint = fingerPrint;
        this.isActive = isActive;
        this.dateCreated = dateCreated;
    }

    public long getId() {
        return id;
    }

    public String getChannelName() {
        return channelName;
    }

    public String getFingerPrint() {
        return fingerPrint;
    }

    public boolean isActive() {
        return isActive;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    @Override
    public int compareTo(Capability capability) {
        System.out.println("compareTo is used");
        return (int) (this.id-capability.getId());

        //befor: 1001, 1005, 900
        //step1: 1001 - 1005 = -4
        //after: 1001, 1005, 900

        //befor: 1001, 1005, 900
        //step2: 1005 - 900 = 105
        //after: 1001, 900, 1005

        //befor: 1001, 900, 1005
        //step3: 1001 - 900 = 101
        //after: 900, 1001, 1005


    }

    @Override
    public String toString() {
        return "Capability{" +
                "id=" + id +
                ", channelName='" + channelName + '\'' +
                ", fingerPrint='" + fingerPrint + '\'' +
                ", isActive=" + isActive +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
