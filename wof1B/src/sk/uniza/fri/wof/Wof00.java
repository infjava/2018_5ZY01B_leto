package sk.uniza.fri.wof;

import sk.uniza.fri.wof.system.Hra;

/**
 * Hlavna trieda hry WoF s metodou main - spustanie v NB
 * 
 * @author Lubomir Sadlon
 * @version 21.2.2012
 */
public class Wof00 {
    /*
    - predmety
        - inventar
        - pero
        - pozvanka na ples
        - bageta (+HP)
        - zhnita bageta (-HP)
        - kluc od miestnosti
    - npc
        - skusky (suboj)
        - ucitel
        - dialogy
    - charakteristiky
        - HP
        - inteligencia
        - sila
        - obratnost
    - eventy
    - questy
        - spravit skusku
    */
    
    /**
     * @param args parametre programu
     */
    public static void main(String[] args) {
        Hra hra = new Hra();
        hra.hraj();
    }
}
