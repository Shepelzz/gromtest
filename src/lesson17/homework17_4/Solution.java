package lesson17.homework17_4;

public class Solution {

    public boolean validate(String address){
        if(address == null || address.trim().equals(""))
            return false;
        if(checkProtocol(address) && checkDomainName(address) && checkDomainZone(address))
            return true;
        return false;
    }

    private boolean checkProtocol(String address){
        if(address.indexOf(":") != address.lastIndexOf(":"))
            return false;
        String[] protocols = {"http://", "https://"};
        for(String protocol : protocols)
            if(address.contains(protocol))
                return true;
        return false;
    }

    private boolean checkDomainName(String address){
        if(address.lastIndexOf(".") == -1) //сразу исключаю отсуствие доменной зоны
            return false;

        String body = address.substring(0, address.lastIndexOf(".")); //вырезаю зону из строки

        body = body.replace("http://", ""); //и удаляю протоколы, так как раз мы на этом шаге, то он точно есть
        body = body.replace("https://", "");

        if(body.contains("www."))
            body = body.substring("www.".length());  //нужно точно знать что эта фигня встретится только 1 раз в начале строки

        if(checkWord(body))
            return true;
        return false;
    }

    private boolean checkDomainZone(String address){
        if(address.lastIndexOf(".") == -1) //сразу исключаю отсуствие доменной зоны
            return false;

        String zone = address.substring(address.lastIndexOf("."));
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
