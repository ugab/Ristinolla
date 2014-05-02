/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Käyttöliittymä;

import Käyttöliittymä.AloitusMenu;
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
public class AloitusMenuTest {
    
    public AloitusMenuTest() {
    }
    
    AloitusMenu aa;
    
    @Before
    public void setUp() {
        aa = new AloitusMenu();
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testtarkista() {
        // TODO review the generated test code and remove the default call to fail.
        String koko="asd";
        String nimi1="juntti";
        String nimi2="juntti2";

        assertEquals(aa.tarkista(koko, nimi1, nimi2), false);
    }

    @Test
    public void testtarkista2() {
        // TODO review the generated test code and remove the default call to fail.
        String koko="19";
        String nimi1="juntti";
        String nimi2="piiiiiiiiiiitkääääääääääää kissssssaaaaaaaa";

        
        
        assertEquals(aa.tarkista(koko, nimi1, nimi2), false);
    }
    
    @Test
    public void testtarkista3() {
        // TODO review the generated test code and remove the default call to fail.
        String koko="15";
        String nimi1="juntti";
        String nimi2="juntti2";

        assertEquals(aa.tarkista(koko, nimi1, nimi2), true);
    }    
     
    
}
