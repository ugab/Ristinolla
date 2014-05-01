/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logiikka;

import Logiikka.Pelaaja;
import Logiikka.Vuoro;
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
public class VuoroTest {
    
    Vuoro vuoro;
    Pelaaja p1;
    Pelaaja p2;
    
    public VuoroTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        p1=new Pelaaja(1, "Juntti");
        p2=new Pelaaja(2, "Hintti");
        vuoro=new Vuoro(p1, p2);
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testKonstruktori(){
        Vuoro testi = new Vuoro(p1, p2);
        assertEquals(p1, testi.p1);   
        
    }

    @Test
    public void testKonstruktori2(){
        Vuoro testi = new Vuoro(p1, p2);
        assertEquals(p2, testi.p2);   
        
    }    
    
    @Test
    public void testKonstruktori3(){
        Vuoro testi = new Vuoro(p1, p2);
        assertEquals(1, testi.haevuoro());   
        
    }      
    
    @Test
    public void testVuoronvaihto(){
        
        Vuoro testi = new Vuoro(p1, p2);
        testi.Vuoronvaihto();
        assertEquals(2, testi.haevuoro());   
        
    }          
}
