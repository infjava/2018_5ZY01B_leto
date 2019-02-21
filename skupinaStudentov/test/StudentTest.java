/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author janik
 */
public class StudentTest {
    
    @Test
    public void meno() {
        Student jozo = new Student("8", "Jozef", "Mrkvicka");
        String meno = jozo.getMeno();
        Assert.assertEquals("Jozef", meno);
    }
    
    @Test
    public void menoJeNull() {
        Student jozo = new Student("8", null, "Mrkvicka");
        String meno = jozo.getMeno();
        Assert.assertNull(meno);
    }
}
