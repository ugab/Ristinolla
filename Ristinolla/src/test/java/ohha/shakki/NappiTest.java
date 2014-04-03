/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohha.shakki;

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
public class NappiTest {
    
    public NappiTest() {
    }
    
    private GUI testi;
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
        
        testi = new GUI (10, p1, p2);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of actionPerformed method, of class 
     */
    
    @Test
    public void testKonstruktori(){
        assertEquals(null, testi.taulu[2][2].getText());

    }
    
    @Test
    public void testActionPerformed() {
        
        testi.taulu[9][9].doClick();
        
        assertEquals("X", testi.taulu[9][9].getText());
        
    }
}