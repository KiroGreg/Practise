package Blatt09_Zahlensaecke;

import java.util.*;

/**
 * This class implements NumberBag using a linked list and
 * a shuffle algorithm. The numbers are already in random order
 * in the number bag and only need to be returned sequentially.
 * 
 * @author Fredrik Winkler, Christian Spaeh
 * @version Dezember 2010
 */
public class Permutation implements NumberBag
{
    private final String _string;
    private final LinkedList<Integer> _sack;
    private final int _groesse;
    
    /**
     * Constructor to create a permutation number bag with a given size.
     * 
     * @param groesse the size of the number bag
     */
    public Permutation(int groesse)
    {
        _string = "Permutation (" + groesse + ")";
        _sack = new LinkedList<Integer>();
        _groesse = groesse;
    }

    /**
     * @see NumberBag#gibGroesse()
     */
    public int gibGroesse()
    {
        return _groesse;
    }

    /**
     * @see NumberBag#gibAnzahl()
     */
    public int gibAnzahl()
    {
        return _sack.size();
    }

    /**
     * Returns whether the number bag is empty.
     * 
     * @return true, if the number bag is empty
     */
    public boolean istLeer()
    {
        return _sack.isEmpty();
    }

    /**
     * Fills the number bag with gibGroesse() distinct random numbers
     * in the half-open interval [0, gibGroesse).
     */
    private void fuelleSack()
    {
        leereSack();
        for (int i = 0; i < _groesse; ++i)
        {    
            _sack.add(i);
        }
        Collections.shuffle(_sack);
    }

    /**
     * Removes a number from the number bag and returns it.
     * Afterwards, the number bag is smaller by one element.
     * Exception: If the number bag is empty before the call,
     * it is first filled, and after the call gibAnzahl() == gibGroesse()-1.
     *
     * @return a random number in the half-open interval [0, gibGroesse)
     */
    public int entferneZahl()
    {
        if (istLeer()) 
        {
            fuelleSack();
        }
        return _sack.removeFirst();
    }
    
    /**
     * Discards all remaining numbers from the number bag.
     * isEmpty() then returns true, and gibAnzahl() returns 0.
     */
    public void leereSack()
    {
        _sack.clear();
    }
    
    /**
     * Gibt den verwendete Algorithmus sowie the size of the number bag als String zurueck.
     * 
     * @return der verwendete Algorithmus und die Groesse
     */
    public String toString()
    {
        return _string;
    }
}
