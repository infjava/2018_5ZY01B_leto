package sk.uniza.fri.wof.hrac;

import sk.uniza.fri.wof.prostredie.Miestnost;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author janik
 */
public class Hrac {

    private Miestnost aktualnaMiestnost;

    public Hrac(Miestnost startovaciaMiestnost) {
        this.aktualnaMiestnost = startovaciaMiestnost;
    }

    public Miestnost getAktualnaMiestnost() {
        return this.aktualnaMiestnost;
    }

    public void chodSmerom(String smer) {
        // Pokus o opustenie aktualnej miestnosti danym vychodom.
        Miestnost novaMiestnost = this.aktualnaMiestnost.getVychod(smer);

        if (novaMiestnost == null) {
            System.out.println("Tam nie je vychod!");
        } else {
            this.aktualnaMiestnost = novaMiestnost;
            novaMiestnost.vypisInfoOMiestnosti();
        }
    }
}
