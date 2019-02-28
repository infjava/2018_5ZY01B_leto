/**
 * Trieda Hra je hlavna trieda aplikacie "World of FRI".
 * "World of FRI" je velmi jednoducha textova hra - adventura. 
 * Hrac sa moze prechadzat po niektorych priestoroch - miestnostiach fakulty. 
 * To je v tejto verzii vsetko. Hru treba skutocne zancne rozsirit,
 * aby bola zaujimava.
 * 
 * Ak chcete hrat "World of FRI", vytvorte instanciu triedy Hra (hra) 
 * a poslite jej spravu hraj.
 * 
 * Hra vytvori a inicializuje vsetky potebne objekty:
 * vytvori vsetky miestnosti, vytvori parser a zacne hru. Hra tiez vyhodnocuje
 * a vykonava prikazy, ktore vrati parser.
 * 
 * @author  Michael Kolling, David J. Barnes
 * @version 2006.03.30
 * @author  lokalizacia: Lubomir Sadlon, Jan Janech
 * @version 2012.02.21
*/
 
public class Hra  {
    private Parser parser;
    private final Hrac hrac;
    private Miestnost startovaciaMiestnost;
    
    /**
     * Vytvori a inicializuje hru.
     */
    public Hra() {
        this.vytvorMiestnosti();
        this.parser = new Parser();
        this.hrac = new Hrac(this.startovaciaMiestnost);
    }

    /**
     * Vytvori mapu hry - miestnosti.
     */
    private void vytvorMiestnosti() {
        // vytvorenie miestnosti
        Miestnost jedalen = new Miestnost("jedalen - Hmmmm... Rozvoniava tu jedlo.");
        Miestnost rc = new Miestnost("chodba RC - Chodba v podzemi.");
        Miestnost terasa = new Miestnost("terasa - Tu byva FRIFest.");
        Miestnost schodisko = new Miestnost("schodisko - Prepaja poschodia.");
        Miestnost ra13 = new Miestnost("RA13 - Miestnost plna (pocitacovych) mysi a inej havede.");
        Miestnost chodbaRA = new Miestnost("RA - Chodba");
        Miestnost vratnica = new Miestnost("vratnica - Tu ta skontroluje vratnicka");
        Miestnost chodbaRB = new Miestnost("RB - chodba na odvratenej strane fakulty");
        Miestnost wc = new Miestnost("WC - aj sem treba obcas ist");
        Miestnost ic = new Miestnost("IC - kopec knih, hadam aj nieco dobre na citanie");
        
        // inicializacia miestnosti = nastavenie vychodov
        jedalen.nastavVychod("zapad", rc);
        jedalen.nastavVychod("hore", chodbaRA);
        
        rc.nastavVychod("vychod1", schodisko);
        rc.nastavVychod("vychod2", jedalen);
        
        terasa.nastavVychod("vychod", vratnica);
        
        schodisko.nastavVychod("vychod", chodbaRA);
        schodisko.nastavVychod("zapad", rc);
        
        ra13.nastavVychod("juh", chodbaRA);
        
        chodbaRA.nastavVychod("sever", ra13);
        chodbaRA.nastavVychod("zapad", schodisko);
        chodbaRA.nastavVychod("juh", vratnica);
        chodbaRA.nastavVychod("vychod", wc);
        chodbaRA.nastavVychod("dole", jedalen);
        
        wc.nastavVychod("zapad", chodbaRA);
        
        vratnica.nastavVychod("sever", chodbaRA);
        vratnica.nastavVychod("juh", chodbaRB);
        vratnica.nastavVychod("zapad", terasa);
        vratnica.nastavVychod("vychod", ic);
        
        ic.nastavVychod("zapad", vratnica);
        
        chodbaRB.nastavVychod("sever", vratnica);

        this.startovaciaMiestnost = jedalen;
    }

    /**
     *  Hlavna metoda hry.
     *  Cyklicky opakuje kroky hry, kym hrac hru neukonci.
     */
    public void hraj() {            
        this.vypisPrivitanie();

        // Vstupny bod hlavneho cyklu.
        // Opakovane nacitava prikazy hraca
        // vykonava ich kym hrac nezada prikaz na ukoncenie hry.
                
        boolean jeKoniec;
        
        do {
            Prikaz prikaz = this.parser.nacitajPrikaz();
            jeKoniec = this.vykonajPrikaz(prikaz);
        } while (!jeKoniec);
        
        System.out.println("Maj sa fajn!");
    }

    /**
     * Vypise privitanie hraca do terminaloveho okna.
     */
    private void vypisPrivitanie() {
        System.out.println();
        System.out.println("Vitaj v hre World of FRI!");
        System.out.println("World of FRI je nova, neuveritelne nudna adventura.");
        System.out.println("Zadaj 'pomoc' ak potrebujes pomoc.");
        System.out.println();
        this.hrac.getAktualnaMiestnost().vypisInfoOMiestnosti();
    }


    /**
     * Prevezne prikaz a vykona ho.
     * 
     * @param prikaz prikaz, ktory ma byt vykonany.
     * @return true ak prikaz ukonci hru, inak vrati false.
     */
    private boolean vykonajPrikaz(Prikaz prikaz) {
        boolean jeKoniec = false;

        if (prikaz.jeNeznamy()) {
            System.out.println("Nerozumiem, co mas na mysli...");
            return false;
        }

        String nazovPrikazu = prikaz.getNazov();
        
        switch (nazovPrikazu) {
            case "pomoc":
                this.vypisNapovedu();
                return false;
            case "chod":
                this.chodDoMiestnosti(prikaz);
                return false;
            case "ukonci":
                return this.ukonciHru(prikaz);
            default:
                return false;
        }
    }

    // implementacie prikazov:

    /**
     * Vypise text pomocnika do terminaloveho okna.
     * Text obsahuje zoznam moznych prikazov.
     */
    private void vypisNapovedu() {
        System.out.println("Zabludil si. Si sam. Tulas sa po fakulte.");
        System.out.println();
        System.out.println("Mozes pouzit tieto prikazy:");
        System.out.println("   chod ukonci pomoc");
    }

    /** 
     * Vykona pokus o prechod do miestnosti urcenej danym smerom.
     * Ak je tym smerom vychod, hrac prejde do novej miestnosti.
     * Inak sa vypise chybova sprava do terminaloveho okna.
     */
    private void chodDoMiestnosti(Prikaz prikaz) {
        if (!prikaz.maParameter()) {
            // ak prikaz nema parameter - druhe slovo - nevedno kam ist
            System.out.println("Chod kam?");
            return;
        }

        String smer = prikaz.getParameter();

        this.hrac.chodSmerom(smer);
    }

    /** 
     * Ukonci hru.
     * Skotroluje cely prikaz a zisti, ci je naozaj koniec hry.
     * Prikaz ukoncenia nema parameter.
     * 
     * @return true, if this command quits the game, false otherwise.
     * @return true, ak prikaz konci hru, inak false.
     */
    private boolean ukonciHru(Prikaz prikaz) {
        if (prikaz.maParameter()) {
            System.out.println("Ukonci, co?");
            return false;
        } else {
            return true;
        }
    }
}
