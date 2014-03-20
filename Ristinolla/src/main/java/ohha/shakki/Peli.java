/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ohha.shakki;

/**
 *
 * @author jayl@cs
 */
public class Peli {
    
    private int vuoro;
    public Pelaaja p1;
    public Pelaaja p2;
    public Lauta lauta;
    
    public Peli(Lauta lau, Pelaaja eka, Pelaaja toka){
        
        lauta =lau;
        p1=eka;
        p2=toka;
        vuoro = 1;
    }
    
    public void Vuorot(){
        
    }
    
}
