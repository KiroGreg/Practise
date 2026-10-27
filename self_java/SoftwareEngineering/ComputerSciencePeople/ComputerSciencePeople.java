package Blatt09_ComputerSciencePeople;

/**
 * Eine Zusammenstellung von Personen, die die Informatik entscheidend gepraegt haben.
 * 
 * @author Fredrik Winkler, Volodymyr Biryuk
 * @version 9. Dezember 2019
 */
public class ComputerSciencePeople
{
    /**
     * Keine Sorge, das musst Du noch nicht verstehen! Arrays kommen erst in Woche 10.
     */
    private final Person[] _urspruenglicheReihenfolge =
    {
        new Person("Ada", "Lovelace", 1815, false),
        new Person("Charles", "Babbage", 1791, false),
        new Person("Grace", "Hopper", 1906, false),
        new Person("Konrad", "Zuse", 1910, false),
        new Person("Annie", "Easley", 1933, false),

        new Person("Alan", "Kay", 1940, true),
        new Person("Alonzo", "Church", 1903, false),
        new Person("Brian", "Kernighan", 1942, false),
        new Person("Dennis", "Ritchie", 1941, true),
        new Person("John", "Baccus", 1924, false),
        
        new Person("Kristen", "Nygaard", 1926, true),
        new Person("Margaret", "Hamilton", 1936, false),
        new Person("Niklaus", "Wirth", 1934, true),
        new Person("Ole-Johan", "Dahl", 1931, true),
        new Person("Andrew", "Yao", 1946, true),
        
        new Person("Frances", "Spence", 1922, false),
        new Person("Ken", "Thompson", 1943, true),
        new Person("Linus", "Torvalds", 1969, false),
        new Person("Richard", "Stallman", 1953, false),
        new Person("Frances", "Allen", 1932, false),

        new Person("Alan", "Turing", 1912, false),
        new Person("Claude", "Shannon", 1916, false),
        new Person("George", "Boole", 1815, false),
        new Person("Harry", "Nyquist", 1889, false),
        new Person("John", "von Neumann", 1903, false),
        
        new Person("Kurt", "Goedel", 1906, false),
        new Person("Richard", "Hamming", 1915, true),
        new Person("Barbara", "Liskov", 1939, true),
        new Person("Christiane", "Floyd", 1943, false),
        new Person("Donald", "Knuth", 1938, true),
        
        new Person("Edsger", "Dijkstra", 1930, true),
        new Person("Herman", "Hollerith", 1860, false),
        new Person("Tony", "Hoare", 1934, true),
        new Person("Shafi", "Goldwasser", 1958, true)
    };

    private Person[] _infPersoenlichkeiten;
    
    /** 
     * Der leere explizite Konstruktor.
     */
    public ComputerSciencePeople()
    {
        
    }
    
    /**
     * Schreibt die Personen auf die Konsole, geordnet nach einem Kriterium.
     * 
     * @param vergleicher vergleicher, der das Kriterium liefert
     */
    public void schreibeGeordnet(CustomComparator vergleicher)
    {
        _infPersoenlichkeiten = _urspruenglicheReihenfolge.clone();
        insertionsort(vergleicher);
        System.out.println("========== " 
            + vergleicher.getClass().toString().substring(6) + " ==========");
        for (Person p : _infPersoenlichkeiten)
        {
            System.out.println(p);
        }
        System.out.println();
    }

    /**
     * Insertionsort ist ein einfacher, aber nicht besonders effizienter Sortieralgorithmus.
     * Bitte verwendet in der Praxis Collections.sort, statt eigene Sortierroutinen zu schreiben!
     * Aber vielleicht interessiert ja den einen oder anderen Studierenden,
     * wie man ein Sortierverfahren von Hand programmieren koennte :)
     */
    private void insertionsort(CustomComparator vergleicher)
    {
        for (int i = 1; i < _infPersoenlichkeiten.length; ++i)
        {
            // Vorbedingung: Die Liste ist von 0 bis i-1 sortiert
            insert(i, vergleicher);
            // Nachbedingung: Die Liste ist von 0 bis i sortiert
        }
    }

    /**
     * Füge eine Person in die Personenliste ein.
     * @param j der index der Person aus der Personenliste
     * @param vergleicher der vergleicher nach dessen Kriterien eingefuegt werden soll
     */
    private void insert(int j, CustomComparator vergleicher)
    {
        Person einzufuegen = _infPersoenlichkeiten[j];
        while ((j > 0) && vergleicher.vergleiche(einzufuegen, _infPersoenlichkeiten[j - 1]) < 0)
        {
            _infPersoenlichkeiten[j] = _infPersoenlichkeiten[j - 1];
            --j;
        }
        _infPersoenlichkeiten[j] = einzufuegen;
    }
}
