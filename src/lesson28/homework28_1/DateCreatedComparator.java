package lesson28.homework28_1;

import java.util.Comparator;

public class DateCreatedComparator implements Comparator<Capability> {
    @Override
    public int compare(Capability o1, Capability o2) {
        return o1.getDateCreated().compareTo(o2.getDateCreated());
    }
}
