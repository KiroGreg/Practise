package Blatt09_ComputerSciencePeople;

/**
 * Vergleicht zwei Personen anhand ihres Nachnamens.
 * 
 * @author Fredrik Winkler
 * @version 8. Dezember 2014
 */
public class ByLastName implements CustomComparator
{
    /**
     * Der leere explizite Konstruktor.
     */
    public ByLastName()
    {

    }
    
    /**
     * @see CustomComparator#vergleiche
     */
    public int vergleiche(Person a, Person b)
    {
        return a.gibNachname().compareTo(b.gibNachname());
    }
}
