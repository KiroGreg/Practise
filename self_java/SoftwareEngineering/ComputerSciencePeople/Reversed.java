package Blatt09_ComputerSciencePeople;

import static java.util.Objects.requireNonNull;

public class Reversed implements CustomComparator{

    private CustomComparator _objekt;



    public Reversed(CustomComparator objekt) {
        try {
            _objekt = requireNonNull(objekt);
        } catch (NullPointerException e) {
            System.out.println("Can't be null");
        }
    }

    @Override
    public int vergleiche(Person a, Person b) {
        return _objekt.vergleiche(b, a);
    }
}
