package Blatt09_ComputerSciencePeople;

import static java.util.Objects.requireNonNull;

/**
 * Eine Person hat einen Vornamen, einen Nachnamen, ein Geburtsjahr und 
 * ein Attribut was zeigt, ob die Person einen Turing Award erhalten hat.
 * 
 * @author Fredrik Winkler, Volodymyr Biryuk
 * @version 9. Dezember 2019
 */
public class Person
{
    private final String _vorname;
    private final String _nachname;
    private final int _geburtsjahr;
    private final boolean _turingAward;
    
    /**
     * Initializes a Person object with the specified data.
     * 
     * @param vorname the first name
     * @param nachname the last name
     * @param geburtsjahr the birth year
     * @param turingAward whether the person has a Turing Award
     */
    public Person(String vorname, String nachname, int geburtsjahr, boolean turingAward)
    {
        _vorname = requireNonNull(vorname);
        _nachname = requireNonNull(nachname);
        _geburtsjahr = geburtsjahr;
        _turingAward = turingAward;
    }

    /**
     * Returns the first name.
     * 
     * @return the first name
     */
    public String gibVorname()
    {
        return _vorname;
    }
    
    /**
     * Returns the last name.
     * 
     * @return the last name
     */
    public String gibNachname()
    {
        return _nachname;
    }
    
    /**
     * Returns the birth year.
     * 
     * @return the birth year
     */
    public int gibGeburtsjahr()
    {
        return _geburtsjahr;
    }
    
    /**
     * Indicates whether the person received a Turing Award.
     * 
     * @return true if the person has a Turing Award, false otherwise
     */
    public boolean hatTuringAward()
    {
        return _turingAward;
    }
    
    /**
     * Returns a string representation in the format
     * Mustermann, Max (1987, turingAward).
     * 
     * @return the formatted string
     */
    public String toString()
    {
        return String.format("%s, %s (%d, %s)", _nachname, _vorname, _geburtsjahr,
        _turingAward ? "hat Turing Award" : "hat keinen Turing Award");
    }
}
