/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author janik
 */
public class SkupinaTest {

    private Skupina skupina;
    private Student jozo;
    
    @Before
    public void setUp() {
        this.skupina = new Skupina("5ZY01B");
        this.jozo = new Student("1", "Jozef", "Mrkva");
    }
    
    @Test
    public void pridavanieStudenta() {
        this.skupina.pridajStudenta(this.jozo);
        Student pridany = this.skupina.getStudent(this.jozo.getOsobneCislo());
        Assert.assertNotNull(pridany);
    }
    
    @Test
    public void neexistujuciNeexistuje() {
        Student pridany = this.skupina.getStudent("123");
        Assert.assertNull(pridany);
    }
}
