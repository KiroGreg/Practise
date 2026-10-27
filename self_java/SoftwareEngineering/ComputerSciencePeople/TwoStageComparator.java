package Blatt09_ComputerSciencePeople;

import static java.util.Objects.requireNonNull;

/**
 * Vergleicht zwei Personen anhand eines primaeren CustomComparators.
 * Wenn die beiden Personen laut diesem primaeren CustomComparator gleich sind,
 * dann werden die Personen anhand eines sekundaeren CustomComparators verglichen.
 * 
 * @author Fredrik Winkler
 * @version 8. Dezember 2014
 */
public class TwoStageComparator implements CustomComparator
{
    private final CustomComparator _primaer;
    private final CustomComparator _sekundaer;
    
    /**
     * @param primaer der primaere CustomComparator
     * @param sekundaer der sekundaere CustomComparator
     */
    public TwoStageComparator(CustomComparator primaer, CustomComparator sekundaer)
    {
        _primaer = requireNonNull(primaer);
        _sekundaer = requireNonNull(sekundaer);
    }

    /**
     * @see CustomComparator#vergleiche
     */
    public int vergleiche(Person a, Person b)
    {
        int ergebnis = _primaer.vergleiche(a, b);
        if (ergebnis == 0)
        {
            ergebnis = _sekundaer.vergleiche(a, b);
        }
        return ergebnis;
    }
}
