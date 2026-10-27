package Blatt09_ComputerSciencePeople;

public class ByFirstName implements CustomComparator {

    /**
     * Der leere explizite Konstruktor.
     */
    public ByFirstName()
    {

    }

    /**
     * @see CustomComparator#vergleiche
     */
    public int vergleiche(Person a, Person b)
    {
        return a.gibVorname().compareTo(b.gibVorname());
    }
}
