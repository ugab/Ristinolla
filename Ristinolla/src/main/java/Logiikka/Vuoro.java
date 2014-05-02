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
 * Vuoro pitää kirjaa siitä kumman pelaajan vuoro on myös vuoron vaihtaminen
 * hoifetaan tässä luokassa
 */
public class Vuoro {

    public int vuoro;
    public Pelaaja p1;
    public Pelaaja p2;
    public Pelaaja jonkavuoro;

    public Vuoro(Pelaaja eka, Pelaaja toka) {

        //lauta =lau;
        p1 = eka;
        p2 = toka;
        jonkavuoro = p1;
        vuoro = 1;
    }

    public void Vuoronvaihto() {

        if (vuoro == 1) {
            vuoro = 2;
            jonkavuoro = p2;
        } else if (vuoro == 2) {
            vuoro = 1;
            jonkavuoro = p1;
        }

    }

    public int haevuoro() {
        return vuoro;
    }

    public Pelaaja haejonkavuoro() {
        return jonkavuoro;
    }
}
