/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logiikka;

/**
 *
 * @author jayl@cs
 *
 * Pelaaja on yksi pelin pelaajista. Tämä luokka pitää sisällään nimen sekä sen
 * onko kyseinen pelaaja voittanut.
 */
public class Pelaaja {

    final int kumpi;
    public boolean voitto;
    public String nimi;
    public int voittoja;

    /**
     * Tekstit asettaa paikalleen itse peliruudukon ylläpuolella olevat tekstit
     * ja määrittelee mitä niissä lukee.
     *
     */
    public Pelaaja(int kumpinum, String annettu) {

        nimi = annettu;
        kumpi = kumpinum;
        voitto = false;
        voittoja = 0;

    }

    public int haekumpi() {
        return kumpi;
    }

    public void voitin() {
        voitto = true;
    }

    public boolean haevoitto() {
        return voitto;
    }
}
