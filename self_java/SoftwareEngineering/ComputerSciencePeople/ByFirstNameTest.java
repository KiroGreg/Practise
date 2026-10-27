//package Blatt09_ComputerSciencePeople;
//
//import org.junit.jupiter.api.Kl2024.Test;
//
//import java.lang.reflect.InvocationTargetException;
//
//import static org.junit.Assert.*;
//
///**
// * In dieser Klasse wird die funktionalität von ByFirstName getestet.
// *
// * @author Philip Hedram
// * @author Christian Rahe
// * @version 2024.12a
// */
//public class ByFirstNameTest {
//    Person _p1;
//    Person _p2;
//    Person _p3;
//    Person _p4;
//    Person _p5;
//    Person _p6;
//    CustomComparator _perVorname;
//
//    private static CustomComparator getByFirstName() throws Throwable {
//        Class<?> cls = null;
//        try {
//            cls = CustomComparator.class.getClassLoader().loadClass("ByFirstName");
//        } catch (ClassNotFoundException e) {
//            throw new AssertionError("Die Klasse ByFirstName existiert nicht oder muss noch kompiliert werden!");
//        }
//        try {
//            var ctor = cls.getDeclaredConstructor();
//            ctor.setAccessible(true);
//            return (CustomComparator) ctor.newInstance();
//        } catch (InstantiationException | InvocationTargetException e) {
//            throw e.getCause();
//        } catch (NoSuchMethodException e) {
//            throw new AssertionError("ByFirstName hat keinen parameterlosen Konstruktor!");
//        }
//    }
//
//    /**
//     * Kl2024.Test-Subjekte werden erstellt.
//     */
//    public ByFirstNameTest() throws Throwable {
//        _p1 = new Person("Arjun", "Erigaisi", 2003, false);
//        _p2 = new Person("Arju", "Erigaisi", 2003, false);
//        _p3 = new Person("Magnus", "Carlsen", 1990, true);
//        _p4 = new Person("Wei", "Yi", 1994, false);
//        _p5 = new Person("wei", "Yi", 1994, false);
//        _p6 = new Person("", "", 1000, false);
//        _perVorname = getByFirstName();
//    }
//
//    private void assertSortierung(Person a, Person b, int erwartet) {
//        int ergebnis = Integer.signum(_perVorname.vergleiche(a, b));
//        assertEquals(
//                "Für einen Vergleich von \"%s\" und \"%s\" sollte der Kl2024.Ergebnis %d sein (war %d)."
//                        .formatted(a.gibVorname(), b.gibVorname(), erwartet, ergebnis),
//                erwartet, ergebnis
//        );
//    }
//
//    /**
//     * Testet, ob die Vergleiche der Vornamen den erwarteten Wert haben.
//     */
//    @Kl2024.Test
//    public void testSortierung() {
//        assertSortierung(_p1, _p2, 1);
//        assertSortierung(_p2, _p1, -1);
//        assertSortierung(_p3, _p2, 1);
//        assertSortierung(_p2, _p3, -1);
//        assertSortierung(_p4, _p3, 1);
//        assertSortierung(_p3, _p4, -1);
//    }
//
//    /**
//     * Testet ob die Sortierung mit Kleinbuchstaben bei sonst gleichem Namen funktioniert.
//     */
//    @Kl2024.Test
//    public void testKleinbuchstaben() {
//        assertTrue("Der Vergleich von \"%s\" und \"%s\" sollte -1 oder 0 sein.".formatted(_p4.gibVorname(), _p5.gibVorname()),
//                _perVorname.vergleiche(_p4, _p5) <= 0);
//        assertTrue("Der Vergleich von \"%s\" und \"%s\" sollte 1 oder 0 sein.".formatted(_p5.gibVorname(), _p4.gibVorname()),
//                _perVorname.vergleiche(_p5, _p4) >= 0);
//    }
//
//    /**
//     * Testet ob der Vergleich mit einem leeren String funktioniert.
//     */
//    @Kl2024.Test
//    public void testLeererString() {
//        assertSortierung(_p6, _p5, -1);
//        assertSortierung(_p5, _p6, 1);
//        assertSortierung(_p6, _p4, -1);
//        assertSortierung(_p4, _p6, 1);
//        assertSortierung(_p6, _p3, -1);
//    }
//}
