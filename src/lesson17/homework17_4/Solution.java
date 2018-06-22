package lesson17.homework17_4;

public class Solution {
    public boolean validate(String address){
        if(address == null || address.trim().equals(""))
            return false;
        return (checkProtocol(address) && checkDomainZone(address) && checkAddressBody(address));
    }


    private boolean checkProtocol(String address){
        String[] protocols = {"https://", "http://"};
        for(String protocol : protocols)
           if(address.startsWith(protocol))
               return true;
        return false;
    }

    private boolean checkDomainZone(String address){
        String[] domains = {".com", ".org", ".net"};
        for(String domain : domains)
            if(address.endsWith(domain))
                return true;
        return false;
    }

    private boolean checkAddressBody(String address){
        return checkWord(getAddressBody(address));
    }

    private String getAddressBody(String address){
        String[] protocols = {"https://", "http://"};
        for(String protocol : protocols)
            if(address.startsWith(protocol))
                address = address.substring(protocol.length());

        String[] domains = {".com", ".org", ".net"};
        for(String domain : domains)
            if(address.endsWith(domain))
                address = address.substring(0, address.lastIndexOf(domain));

        if(address.startsWith("www."))
            address = address.substring(4);

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
