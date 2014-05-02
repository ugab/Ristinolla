/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logiikka;

import Logiikka.Pelaaja;
import Logiikka.Lauta;
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
public class LautaTest {
    
    public LautaTest() {
    }
    
    Lauta lauta;
    Lauta lauta2;
    Lauta määrätestit;
    Lauta pieni;
    Pelaaja p1;
    Pelaaja p2;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        lauta = new Lauta(15);
        lauta2 = new Lauta(15);
        määrätestit = new Lauta(20);
        pieni = new Lauta(2);
        p1 = new Pelaaja(1, "P1");
        p2 = new Pelaaja(2, "P2");
        
        lauta2.haelauta()[1][1]=1;
        lauta2.haelauta()[2][1]=1;
        lauta2.haelauta()[3][1]=1;
        lauta2.haelauta()[4][1]=1;
        lauta2.haelauta()[5][1]=1;
        lauta2.haelauta()[6][1]=1;
        lauta2.haelauta()[4][2]=1;
        lauta2.haelauta()[5][3]=1;
        lauta2.haelauta()[6][4]=1;
        lauta2.haelauta()[7][5]=1;
        lauta2.haelauta()[8][6]=1;
        
        
        
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void testKonstruktori(){
        Lauta uusilauta = new Lauta(20);
        assertEquals(20, uusilauta.haelauta().length);        
        
    }

    @Test
    public void test2Konstruktori(){
        Lauta uusilauta = new Lauta(20);
        assertEquals(0, uusilauta.haelauta()[1][1]);        
        
    }    
    
    @Test
    public void testVaaka() {
        boolean onko=lauta2.vaaka(1, 1, 1);
        assertEquals(onko, false);    
    }
    
    @Test
    public void testPysty() {
        boolean onko=lauta2.pysty(1, 3, 1);
        assertEquals(onko, true);    
    }    
    
     @Test
    public void testVino() {
        boolean onko=lauta2.vino(1, 6, 4);
        assertEquals(onko, true);    
    }       
    
    @Test
    public void testVino2() {
        boolean onko=lauta2.vino2(1, 6, 4);
        assertEquals(onko, false);    
    }       
    
    @Test
    public void testtarkista(){

        lauta2.tarkista(p1, 3, 1);
        assertEquals(true, p1.haevoitto()); 

    }
    
    @Test
    public void test2tarkista(){

        lauta2.tarkista(p1, 3, 2);
        assertEquals(false, p1.haevoitto()); 

    }
    
    
    @Test
    public void testRaapusta() {
        System.out.println("raapusta");

        int kor=3;
        int lev=2;

        lauta.MerkitseRuutu(p2, kor, lev);

        int expResult = 2;
        int[][] la = lauta.haelauta();
        int result = la[kor][lev];
        assertEquals(expResult, result);

    }

    @Test
    public void test2Raapusta() {
        System.out.println("raapusta");

        int kor=3;
        int lev=2;
        
        lauta.haelauta()[3][2]=2;

        boolean onko =lauta.MerkitseRuutu(p1, kor, lev);

        assertEquals(false, onko);

    }    
    

    
    @Test
    public void test3Raapusta() {
        System.out.println("raapusta");

        määrätestit.MerkitseRuutu(p1, 1, 2);
        määrätestit.MerkitseRuutu(p2, 1, 3);
        määrätestit.MerkitseRuutu(p1, 1, 4);
        määrätestit.MerkitseRuutu(p2, 1, 5);
        määrätestit.MerkitseRuutu(p1, 1, 7);
        määrätestit.MerkitseRuutu(p2, 9, 1);
        määrätestit.MerkitseRuutu(p1, 5, 1);
        määrätestit.MerkitseRuutu(p2, 6, 5);
        määrätestit.MerkitseRuutu(p1, 4, 4);
        määrätestit.MerkitseRuutu(p2, 8, 7);

        assertEquals(10, määrätestit.montOn);

    } 
    
    @Test
    public void testmahtuuko() {

        Lauta lauta3 = new Lauta(2);
        lauta3.MerkitseRuutu(p1, 0, 0);
        lauta3.MerkitseRuutu(p1, 1, 0);
        lauta3.MerkitseRuutu(p1, 1, 1);
        lauta3.MerkitseRuutu(p1, 0, 1);
        
        assertEquals(lauta3.täynnä, false);
    }        
     
}
