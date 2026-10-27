package Blatt09_ComputerSciencePeople;

/**
 * Vergleicht zwei Personen anhand ihres Turing Award Titels.
 * 
 * @author Volodymyr Biryuk
 * @version 10. Dezember 2019
 */
public class ByTuringAward implements CustomComparator
{
    /**
     * Der leere explizite Konstruktor.
     */
    public ByTuringAward()
    {

    }
    
    /**
     * @see CustomComparator#vergleiche
     */
    public int vergleiche(Person a, Person b)
    {
        return Boolean.compare(a.hatTuringAward(), b.hatTuringAward());
    }
}
