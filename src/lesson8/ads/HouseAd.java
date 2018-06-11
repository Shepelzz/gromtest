package lesson8.ads;

public class HouseAd extends Ad {
    String ownerName;
    String adress;
    double square;
    int floor;

    public HouseAd(long id, int price, String ownerName, String adress, double square, int floor) {
        super(id, price);
        this.ownerName = ownerName;
        this.adress = adress;
        this.square = square;
        this.floor = floor;
    }

    boolean checkOwner(){
        Owners owners = new Owners();
        for(String owner : owners.owners){
            if(ownerName == owner)
                return true;

        }
        return false;
    }
}
