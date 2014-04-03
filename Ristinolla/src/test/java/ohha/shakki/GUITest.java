/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ohha.shakki;

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
public class GUITest {
    
    public GUITest() {
            
    }
    
    private GUI testi;
    private Pelaaja p1;
    private Pelaaja p2;

    
    @Before
    public void setUp() {
        
        p1 = new Pelaaja(1, "Juntti");
        p2 = new Pelaaja(2, "Juippi");
        
        testi = new GUI (10, p1, p2);
    }
    
    @Test
    public void testKonstruktori() {
        
        assertEquals(10, testi.taulu.length);
        
    }
    
}
