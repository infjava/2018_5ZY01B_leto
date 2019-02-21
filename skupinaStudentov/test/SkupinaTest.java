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
    private Student fero;
    
    @Before
    public void setUp() {
        this.skupina = new Skupina("5ZY01B");
        this.jozo = new Student("1", "Jozef", "Mrkva");
        this.fero = new Student("2", "Ferdinant", "Mrkva");
    }
    
    @Test
    public void pridavanieStudenta() {
        this.skupina.pridajStudenta(this.jozo);
        Student pridany = this.skupina.getStudent(this.jozo.getOsobneCislo());
        Assert.assertSame(this.jozo, pridany);
    }
    
    @Test
    public void neexistujuciNeexistuje() {
        Student pridany = this.skupina.getStudent("123");
        Assert.assertNull(pridany);
    }
    
    @Test
    public void nedaSaPridatStudentaDvaKrat() {
        Assert.assertTrue(this.skupina.pridajStudenta(this.jozo));
        Assert.assertFalse(this.skupina.pridajStudenta(this.jozo));
    }
    
    @Test
    public void daSaPridatDvochStudentov() {
        Assert.assertTrue(this.skupina.pridajStudenta(this.jozo));
        Assert.assertTrue(this.skupina.pridajStudenta(this.fero));
    }
}
