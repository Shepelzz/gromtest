package lesson28;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

public class DemoComparator {
    public static void main(String[] args) {
        Capability capability4 = new Capability(900, "test", "rrrr", false, new Date());
        Capability capability2 = new Capability(1005, "test", "rrrr", false, new Date());
        Capability capability3 = new Capability(900, "test", "rrrr", true, new Date());
        Capability capability1 = new Capability(1001, "test", "rrrr", true, new Date());


        ArrayList<Capability> capabilities = new ArrayList<>();
        capabilities.add(capability1);
        capabilities.add(capability2);
        capabilities.add(capability3);

        System.out.println(capabilities.toString());

        capabilities.sort(new IsActiveComparator());

        System.out.println(capabilities.toString());

        Comparator<Capability> comparator = new Comparator<Capability>() {
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
                else if(!(o1.getDateCreated().equals(o2.getDateCreated())))
                    return o1.getDateCreated().compareTo(o2.getDateCreated());
                else return 0;

            }
        };
    }
}
