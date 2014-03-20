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
 * @author jayl@cs
 */
public class PelaajaTest {
    
    public PelaajaTest() {
    }
    
    Pelaaja p1;    
    @Before
    public void setUp() {
        p1 = new Pelaaja(1);
    }


    
    @Test
    public void TestKonstruktori(){
        
        Pelaaja p2=new Pelaaja(2);
        
        assertEquals(2, p2.haekumpi()); 
        
    }
    
    @Test
    public void Testvoitin(){
        assertEquals(false, p1.haevoitto()); 
        p1.voitin();
        assertEquals(true, p1.haevoitto()); 
    }
}
