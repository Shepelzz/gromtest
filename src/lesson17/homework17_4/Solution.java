package lesson17.homework17_4;

public class Solution {
    private String[] protocols = {"https://", "http://"};
    private String[] domains = {".com", ".org", ".net"};
    private String urlBodyPrefix = "www.";

    public boolean validate(String address){
        if(address == null || address.trim().equals(""))
            return false;
        return (checkProtocol(address) && checkDomainZone(address) && checkAddressBody(address));
    }


    private boolean checkProtocol(String address){
        for(String protocol : protocols)
           if(address.startsWith(protocol))
               return true;
        return false;
    }

    private boolean checkDomainZone(String address){
        for(String domain : domains)
            if(address.endsWith(domain))
                return true;
        return false;
    }

    private boolean checkAddressBody(String address){
        return checkWord(getAddressBody(address));
    }

    private String getAddressBody(String address){
        for(String protocol : protocols)
            if(address.startsWith(protocol))
                address = address.substring(protocol.length());

        for(String domain : domains)
            if(address.endsWith(domain))
                address = address.substring(0, address.lastIndexOf(domain));

        if(address.startsWith(urlBodyPrefix))
            address = address.substring(urlBodyPrefix.length());

        return address;
    }

    private boolean checkWord(String word){
        if(word == null || word.equals(""))
            return false;
        for(Character ch : word.toCharArray())
            if(!Character.isLetter(ch))
                return false;
        return true;
    }

}
