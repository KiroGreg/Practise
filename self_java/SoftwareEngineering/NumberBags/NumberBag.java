package Blatt09_Zahlensaecke;

/**
 * Ein NumberBag ist ein Datentyp, welcher eine gewisse Anzahl an
 * unterschiedlichen (!), zufaelligen Zahlen liefert. Die Zahlen liegen 
 * dabei immer zwischen 0 und Groesse-1, d.h. ein NumberBag der Groesse 10 
 * liefert Zufallszahlen aus der Menge {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}.
 * 
 * <p>Vorstellbar ist z.B. ein NumberBag der Groesse 32, welcher immer
 * wieder neue Skatblaetter generiert. Denn: die ersten 32 gezogenen Zahlen
 * sind garantiert unterschiedlich, die naechsten 32 ebenfalls usw.
 * 
 * <p>Ein frisch generierter NumberBag ist immer leer!
 * 
 * @author Fredrik Winkler
 * @version Dezember 2009
 */
interface NumberBag
{
    /**
     * Gibt die Groesse des NumberBags.
     * 
     * @return die Groesse 
     */
    public int gibGroesse();

    /**
     * Gibt die Anzahl, der Zahlen, die sich momentan im NumberBag befinden.
     * 
     * @return die Anzahl 
     */
    public int gibAnzahl();
    
    /**
     * Ob der NumberBag leer ist.
     * 
     * @return true, falls der NumberBag leer ist
     */
    public boolean istLeer();
    
    /**
     * Entfernt eine Zahl aus dem NumberBag und liefert sie zurueck.
     * Danach ist der NumberBag um ein Element kleiner.
     * Ausnahme: Falls der NumberBag vor dem Aufruf leer ist,
     * wird er zuerst gefuellt, und nach dem Aufruf ist gibAnzahl() == gibGroesse()-1.
     * 
     * @return eine zufaellige Zahl im halboffenen Intervall [0, gibGroesse)
     */
    public int entferneZahl();
    
    /**
     * Verwirft alle uebrig gebliebenen Zahlen aus dem NumberBag.
     * istLeer() liefert anschliessend true zurueck, und gibAnzahl() liefert 0.
     */
    public void leereSack();
}
