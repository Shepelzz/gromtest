package lesson28.homework28_1;

import java.util.Comparator;

public class FullComparator implements Comparator<Capability> {

    @Override
    public int compare(Capability o1, Capability o2) {
        //если channelName не равно - сравниваю по нему
        //если равно - перехожу к fingerprint
        //если fingerprint не равно - сравниваю по нему
        //если равно - перехожу к datecreated
        //если datecreated не равно - сравниваю по нему
        //если равно - обьекты равны

        if(!(o1.getChannelName().equals(o2.getChannelName())))
            return o1.getChannelName().compareTo(o2.getChannelName());
        else if(!(o1.getFingerPrint().equals(o2.getFingerPrint())))
            return o1.getFingerPrint().compareTo(o2.getFingerPrint());
        else return o1.getDateCreated().compareTo(o2.getDateCreated());
    }
}
