package Blatt09_ComputerSciencePeople;

/**
 * A Comparator is able to compare two persons with each other.
 * The comparison criterion used can be defined differently in each subclass.
 * 
 * @author Fredrik Winkler
 * @version 8. Dezember 2014
 */
public interface CustomComparator
{
    /**
     * Compares two persons and provides information about 
     * their relative order.
     * If both persons are equal (measured by the comparison criterion), 
     * then 0 is returned.
     * If a would precede b in an ordered list, 
     * then a negative number is returned.
     * Otherwise, a positive number is returned.
     * 
     * @param a person to compare against
     * @param b person to be compared with a
     * 
     * @return number indicating the order of a and b
     */
    public int vergleiche(Person a, Person b);
}
