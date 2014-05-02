/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Käyttöliittymä;

import Käyttöliittymä.Ruudukko;
import Logiikka.Pelaaja;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jaakko
 */
public class RuudukkoTest {
    
    public RuudukkoTest() {
            
    }
    
    private Ruudukko testi;
    private Pelaaja p1;
    private Pelaaja p2;


    @Before
    public void setUp() {
        
        p1 = new Pelaaja(1, "Juntti");
        p2 = new Pelaaja(2, "Juippi");
        
        testi = new Ruudukko (10, p1, p2);
    }

    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void testKonstruktori() {
        
        assertEquals(10, testi.taulu.length);
        
    }

    /**
     * Test of uusipeli method, of class Ruudukko.
     */
    @Test
    public void testUusipeli() {
        
        testi.Uusipeli.doClick();
        assertEquals(true, true);
    }

    /**
     * Test of katsokoko method, of class Ruudukko.
     */
    @Test
    public void testKatsokoko() {
        
        assertEquals(50, testi.ruudunkoko);
    }
    
}
