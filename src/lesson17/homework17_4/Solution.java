package lesson17.homework17_4;

public class Solution {

    public boolean validate(String address){
        if(!(address == null) && !(address.trim().equals("")) && checkProtocol(address) && checkDomainName(address) && checkDomainZone(address))
            return true;
        return false;
    }

    private boolean checkProtocol(String address){
        if(address.contains("http://") || address.contains("https://"))
            return true;
        return false;
    }

    private boolean checkDomainName(String address){
        String body = address.substring(address.indexOf(":")+3,
                                        address.lastIndexOf(".") == -1 ? address.length() : address.lastIndexOf(".")
        );
        if(body.contains("www."))
            body = body.substring(4);
        if(checkBytes(body.getBytes()))
            return true;
        return false;
    }

    private boolean checkDomainZone(String address){
        String zone = address.lastIndexOf(".") == -1 ? "" : address.substring(address.lastIndexOf("."));
        if(zone.contains(".com") || zone.contains(".org") || zone.contains(".net"))
            return true;
        return false;
    }

    private boolean checkBytes(byte[] bytes){
        boolean checkWord = false;
        for (byte b : bytes) {
            if ((b >= 65 && b <= 90) || (b >= 97 && b <= 122))
                checkWord = true;
            else
                return false;
        }
        return checkWord;
    }
}
