package Blatt09_Zahlensaecke;

import java.util.Random;

/**
 * Diese Klasse implementiert den NumberBag mittels eines Arrays.
 * Die Zahlen werden bei erst bei Bedarf zufaellig herausgepickt.
 * 
 * @author Fredrik Winkler, Christian Spaeh
 * @version Dezember 2010
 */
public class Selection implements NumberBag
{
    private final String _string;
    private final Random _zufall;
    private final int[] _sack;
    private int _anzahl;
    
    /**
     * Der Konstruktor, um einen Selection NumberBag mit einer Groesse zu erzeugen.
     * 
     * @param groesse die Groesse des NumberBags
     */
    public Selection(int groesse)
    {
        _string = "Selection (" + groesse + ")";
        _zufall = new Random();
        _sack = new int[groesse];
        _anzahl = 0;
    }
    
    /**
     * @see NumberBag#gibGroesse()
     */
    public int gibGroesse()
    {
        return _sack.length;
    }

    /**
     * @see NumberBag#gibAnzahl()
     */
    public int gibAnzahl()
    {
        return _anzahl;
    }
    
    /**
     * Gibt wieder, ob der NumberBag leer ist.
     * 
     * @return true, falls der NumberBag leer ist
     */
    public boolean istLeer()
    {
        return _anzahl == 0;
    }
    
    /**
     * Fuellt den NumberBag mit gibGroesse() verschiedenen Zufallszahlen
     * im halboffenen Intervall [0, gibGroesse).
     */
    private void fuelleSack()
    {
        _anzahl = _sack.length;
        for (int i = 0; i < _anzahl; ++i)
        {
            _sack[i] = i;
        }
    }
    
    /**
     * Entfernt eine Zahl aus dem NumberBag und liefert sie zurueck.
     * Danach ist der NumberBag um ein Element kleiner.
     * Ausnahme: Falls der NumberBag vor dem Aufruf leer ist,
     * wird er zuerst gefuellt, und nach dem Aufruf ist gibAnzahl() == gibGroesse()-1.
     * 
     * @return eine zufaellige Zahl im halboffenen Intervall [0, gibGroesse)
     */
    public int entferneZahl()
    {
        if (istLeer()) 
        { 
            fuelleSack();
        }
        final int i = _zufall.nextInt(_anzahl);
        final int zahl = _sack[i];
        _sack[i] = _sack[--_anzahl];
        return zahl;
    }
    
    /**
     * Verwirft alle uebrig gebliebenen Zahlen aus dem NumberBag.
     * istLeer() liefert anschliessend true zurueck, und gibAnzahl() liefert 0.
     */
    public void leereSack()
    {
        _anzahl = 0;
    }
    
    /**
     * Gibt den verwendete Algorithmus sowie die Groesse des NumberBags als String zurueck.
     * 
     * @return der verwendete Algorithmus und die Groesse
     */
    public String toString()
    {
        return _string;
    }
}
