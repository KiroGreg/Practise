package Blatt09_Zahlensaecke;

import java.util.Random;
import java.util.Arrays;

/**
 * Diese Klasse implementiert den NumberBag mittels eines Arrays,
 * in dem sich fuer jede Zahl gemerkt wird, ob sie bereits gezogen wurde.
 * 
 * @author Fredrik Winkler, Christian Spaeh
 * @version Dezember 2010
 */
public class Naive implements NumberBag
{
    private final String _string;
    private final Random _zufall;
    private final boolean[] _bereitsGezogen;
    private final int _groesse;
    private int _anzahl;
    
    /**
     * @param groesse die Groesse des NumberBags
     */
    public Naive(int groesse)
    {
        _string = "Naive (" + groesse + ")";
        _zufall = new Random();
        _bereitsGezogen = new boolean[groesse];
        _groesse = groesse;
        _anzahl = 0;
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
        return _anzahl;
    }
    
    /**
     * @return true, falls der NumberBag leer ist
     */
    public boolean istLeer()
    {
        return _anzahl == 0;
    }
    
    /**
     * Fuellt den NumberBag mit gibGroesse() verschiedenen Zufallszahlen.
     * im halboffenen Intervall [0, gibGroesse)
     */
    private void fuelleSack()
    {
        Arrays.fill(_bereitsGezogen, false);
        _anzahl = _groesse;
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
        int zahl;
        do
        {
            zahl = _zufall.nextInt(_groesse);
        }
        while (_bereitsGezogen[zahl]);
        
        _bereitsGezogen[zahl] = true;
        --_anzahl;
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
     * @return der verwendete Algorithmus sowie die Groesse des NumberBags
     */
    public String toString()
    {
        return _string;
    }
}
