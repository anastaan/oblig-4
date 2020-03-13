public class TestLege {
    private static int antallTester = 0;
    private static int antallPasserte = 0;
    private static int antallFeil = 0;

    public static void main(String[] args) {
        testLeger();
    }

    static void testLeger(){
        //Lege(navn)
        //Spesialist(navn, kontrollID))

        /*  * lager noen leger,
            * legger dem i lista,
            * tester kreftene deres
                *
        */

        Lege l0 = new Lege("l0");
        Lege l1 = new Lege("l1");
        Lege l2 = l0;
        Lege l3 = new Lege("l3");
        sjekk(true, l0.compareTo(l1) < 0, "ser om 'l0' < 'l1'");
        sjekk(true, l3.compareTo(l1) > 0, "ser om 'l3' > 'l1'");
        sjekk(true, l2.compareTo(l0) == 0, "ser om 'l2 (=l0)' == 'l0'");


        // Liste<Lege> liste = new Lenkeliste<Lege>();
        // liste.leggTil(l0);
        // liste.leggTil(l1);
        // liste.leggTil(l2);
        // liste.leggTil(l3);
    }

    static void sjekk(Object forventet, Object faktisk, String testmelding) {
        if (forventet.equals(faktisk)) {
            sjekkPasserte();
        } else {
            sjekkFeilet(testmelding);
            System.out.println("  > Forventet verdi: " + forventet);
            System.out.println("  > Faktisk verdi: " + faktisk);
        }
    }
    static void sjekkPasserte() {
        antallTester++;
        antallPasserte++;
        System.out.println("- Test " + antallTester + ": OK");
    }

    static void sjekkFeilet(String testmelding) {
        antallTester++;
        antallFeil++;
        System.out.println("- Test " + antallTester + " feilet: " + testmelding);
    }
}
