/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logiikka;

import Logiikka.Pelaaja;
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
        p1 = new Pelaaja(1, "Juntti");
    }

    @Test
    public void TestKonstruktori(){
        
        Pelaaja p2=new Pelaaja(2, "Hintti");
        
        assertEquals(2, p2.haekumpi()); 
        
    }
    
    @Test
    public void Testvoitin(){
        assertEquals(false, p1.haevoitto()); 
        p1.voitin();
        assertEquals(true, p1.haevoitto()); 
    }
    
    @Test
    public void Testhaekumpi(){

        assertEquals(1, p1.kumpi); 
    }
    
    @Test
    public void Testhaevoitto(){

        assertEquals(false, p1.haevoitto()); 
    }    
}
