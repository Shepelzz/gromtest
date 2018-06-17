package lesson17.homework17_4;

public class Solution {

    public boolean validate(String address){
        if(checkProtocol(address) && checkDomainName(address) && checkDomainZone(address))
            return true;
        return false;
    }

    private boolean checkProtocol(String address){
        if(address.contains("http://") || address.contains("https://"))
            return true;
        return false;
    }

    private boolean checkDomainName(String address){

        return false;
    }

    private boolean checkDomainZone(String address){

        return false;
    }
}
