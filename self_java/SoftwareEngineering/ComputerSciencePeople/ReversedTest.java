//package Blatt09_ComputerSciencePeople;
//
//
//
//import java.lang.reflect.InvocationTargetException;
//
//import static org.junit.Assert.*;
//
///**
// * In dieser Klasse wird die funktionalität von Reversed getestet.
// *
// * @author Philip Hedram
// * @author Christian Rahe
// * @version 2024.12a
// */
//public class ReversedTest {
//    Person _p1;
//    Person _p2;
//    Person _p3;
//    Person _p4;
//    Person _p5;
//    Person _p6;
//
//    private static CustomComparator getReversed(CustomComparator vergleicher) throws Throwable {
//        Class<?> cls = null;
//        try {
//            cls = CustomComparator.class.getClassLoader().loadClass("Reversed");
//        } catch (ClassNotFoundException e) {
//            throw new AssertionError("Die Klasse Reversed existiert nicht oder muss noch kompiliert werden!");
//        }
//        try {
//            var ctor = cls.getDeclaredConstructor(CustomComparator.class);
//            ctor.setAccessible(true);
//            return (CustomComparator) ctor.newInstance(vergleicher);
//        } catch (InstantiationException | InvocationTargetException e) {
//            throw e.getCause();
//        } catch (NoSuchMethodException e) {
//            throw new AssertionError("Reversed hat keinen Konstruktor, der einen CustomComparator entgegennimmt!");
//        }
//    }
//
//    /**
//     * Kl2024.Test-Subjekte werden erstellt.
//     */
//    public ReversedTest() {
//        _p1 = new Person("Arjun", "Erigaisi", 2003, false);
//        _p2 = new Person("Arju", "Erigaisi", 2003, false);
//        _p3 = new Person("Magnus", "Carlsen", 1990, true);
//        _p4 = new Person("Wei", "Yi", 1994, false);
//        _p5 = new Person("wei", "Yi", 1963, false);
//        _p6 = new Person("", "", 1000, false);
//    }
//
//    private void assertSortierung(CustomComparator vergleicher, Person a, Person b, int erwartet) {
//        int ergebnis = Integer.signum(vergleicher.vergleiche(a, b));
//        assertEquals(
//                "Für einen Vergleich von \"%s\" und \"%s\" sollte der Kl2024.Ergebnis %d sein (war %d)."
//                        .formatted(a.gibVorname(), b.gibVorname(), erwartet, ergebnis),
//                erwartet, ergebnis
//        );
//    }
//
//    /**
//     * Testet, ob die Alterssortierung umgekehrt wird.
//     */
//    @Kl2024.Test
//    public void testByAge() throws Throwable {
//        CustomComparator vergleicher = getReversed(new ByAge());
//
//        assertSortierung(vergleicher, _p1, _p2, 0);
//        assertSortierung(vergleicher, _p1, _p3, -1);
//        assertSortierung(vergleicher, _p3, _p4, 1);
//        assertSortierung(vergleicher, _p5, _p6, -1);
//    }
//
//    /**
//     * Testet, ob die Nachnamenssortierung umgekehrt wird.
//     */
//    @Kl2024.Test
//    public void testByLastName() throws Throwable {
//        CustomComparator vergleicher = getReversed(new ByLastName());
//
//        assertSortierung(vergleicher, _p1, _p2, 0);
//        assertSortierung(vergleicher, _p3, _p2, 1);
//        assertSortierung(vergleicher, _p3, _p4, 1);
//        assertSortierung(vergleicher, _p4, _p1, -1);
//        assertSortierung(vergleicher, _p6, _p1, 1);
//        assertSortierung(vergleicher, _p3, _p6, -1);
//        assertSortierung(vergleicher, _p6, _p5, 1);
//    }
//}