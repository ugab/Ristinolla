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
public class Pelaaja {
    
    final int kumpi;
    private boolean voitto;
    
    public Pelaaja(int kumpinum){
        
        kumpi=kumpinum;
        voitto=false;
        
    }
    
    
    public int haekumpi(){
        return kumpi;
    }
    
    public void voitin(){
        voitto=true;
    }
    
    public boolean haevoitto(){
        return voitto;
    }    

}
