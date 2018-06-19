package lesson17.homework17_4;

public class Solution {

    public boolean validate(String address){
        if(!(address == null) && !(address.trim().equals("")) && checkProtocol(address) && checkDomainName(address) && checkDomainZone(address))
            return true;
        return false;
    }

    private boolean checkProtocol(String address){
        String[] protocols = {"http://", "https://"};
        for(String protocol : protocols)
            if(address.contains(protocol))
                return true;
        return false;
    }

    private boolean checkDomainName(String address){
        String body = address.substring(address.indexOf(":")+3,
                                        address.lastIndexOf(".") == -1 ? address.length() : address.lastIndexOf(".")
        );
        if(body.contains("www."))
            body = body.substring(4);
        if(checkWord(body))
            return true;
        return false;
    }

    private boolean checkDomainZone(String address){
        String zone = address.lastIndexOf(".") == -1 ? "" : address.substring(address.lastIndexOf("."));
        String[] domains = {".com", ".org", ".net"};
        for(String domain : domains)
            if(zone.contains(domain))
                return true;
        return false;
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
