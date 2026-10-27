package Blatt09_ComputerSciencePeople;

/**
 * Vergleicht zwei Personen anhand ihres Alters.
 * 
 * @author Fredrik Winkler
 * @version 8. Dezember 2014
 */
public class ByAge implements CustomComparator
{
    /**
     * Der leere explizite Konstruktor.
     */
    public ByAge()
    {

    }
    
    /**
     * @see CustomComparator#vergleiche
     */
    public int vergleiche(Person a, Person b)
    {
        // Achtung: Dieser Trick funktioniert nur, wenn die Differenz garantiert in einen int passt.
        return a.gibGeburtsjahr() - b.gibGeburtsjahr();
    }

    public int vergleicheDreistufig(Person a, Person b)
    {
        int ergebnis = vergleiche(a, b);
        if (ergebnis == 0)
        {
            ByFirstName vorname = new ByFirstName();
            ByLastName nachname = new ByLastName();
            TwoStageComparator erweiterung = new TwoStageComparator(vorname, nachname);
            ergebnis = erweiterung.vergleiche(a, b);
        }
        return ergebnis;
    }
}
