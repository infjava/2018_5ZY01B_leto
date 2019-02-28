/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author janik
 */
public class Svet {

    private final Miestnost startovaciaMiestnost;

    public Svet() {
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

    public Miestnost getStartovaciaMiestnost() {
        return this.startovaciaMiestnost;
    }
}
