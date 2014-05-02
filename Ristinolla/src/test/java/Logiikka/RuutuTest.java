/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logiikka;

import Käyttöliittymä.Ruudukko;
import Logiikka.Pelaaja;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ylinen
 */
public class RuutuTest {
    
    public RuutuTest() {
    }
    
    public Ruudukko testi;
    private Pelaaja p1;
    private Pelaaja p2;

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        
        p1 = new Pelaaja(1, "Juntti");
        p2 = new Pelaaja(2, "Juippi");
        
        testi = new Ruudukko (10, p1, p2);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of actionPerformed method, of class 
     */
    
    @Test
    public void testKonstruktori(){
        assertEquals(null, testi.taulu[2][2].getIcon());

    }
    
//    @Test
//    public void testActionPerformed() {
//        
//        testi.taulu[9][9].doClick();
//        
//        assertEquals(this.getClass().getResource("/main/java/kuvat/50_x1.png"), testi.taulu[9][9].getIcon());
//        
//    }
//    
    @Test
    public void testActionPerformed2() {
        
        testi.taulu[0][0].doClick();
        
        assertEquals(1, testi.lauta.haelauta()[0][0]);
        
    }    
}