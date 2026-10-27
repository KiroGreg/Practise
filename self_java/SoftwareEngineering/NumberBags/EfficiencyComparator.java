package Blatt09_Zahlensaecke;

/**
 * This class compares the efficiency of different NumberBag implementations.
 *
 * <p>Implements the missing code in the measure(NumberBag) method!
 *
 * @author Fredrik Winkler, Christian M. Spaeh
 * @version Dezember 2013
 */
public class EfficiencyComparator
{
    /**
     * The empty explicit constructor.
     */
    public EfficiencyComparator()
    {
        
    }
    
    /**
     * Compares the efficiency of different NumberBag implementations.
     * All number bags are created with the same size.
     * 
     * @param size the size of the number bags
     */
    public void vergleiche(int groesse)
    {
        if (groesse < 1)
        {
            throw new IllegalArgumentException("groesse < 1");
        }
        
        NumberBag zs = new Naive(groesse);
        vermesse(zs);
        
        zs = new Permutation(groesse);
        vermesse(zs);
        
        zs = new Selection(groesse);
        vermesse(zs);
    }

    /**
     * Measures the time required to remove a large number of numbers from the
     * NumberBag. The result is printed to the console.
     * 
     * @param bag the number bag to measure
     */
    public void vermesse(NumberBag sack)
    {
        // Store current time as start time
 
        // Call removeNumber 1 million times

        // Store current time as stop time

        // Calculate the difference between stop time and start time
        
        // Divide difference by 1,000,000 to convert from ns to ms

        System.out.print(sack); // Print description of the number bag
        System.out.print(": "); // followed by a colon
        // Print the result to the console
        
    }
}
