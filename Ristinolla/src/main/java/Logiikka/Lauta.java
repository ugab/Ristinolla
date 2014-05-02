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
 * Lauta pitää kirjaa pelissä tehdyistä siirroista ja tarkistaa joka siirron
 * jälkeen onko voittoehto täyttynyt.
 */
public class Lauta {

    private int[][] lauta;
    private int montMahtuu;
    public int montOn;
    public boolean täynnä;

    public Lauta(int koko) {

        lauta = new int[koko][koko];
        montMahtuu = koko * koko;
        montOn = 0;
        täynnä = true;

    }

    /**
     *
     * Asettaa taulukkoon lauta anettuihin koordinaatteihin joko 1 tai 2
     * riippuen siita kumpi pelaaja on kyseessä ja lisäksi kutsuu metodeja
     * mahtuuko ja tarkista.
     *
     * @param p pelaaja jonka vuoron on
     * @param kor koordinaatti
     * @param lev koordinaatti
     *
     * @return palauttaa true jos kyseinen ruutu on tyhjä, palauttaa false jos
     * koordinaatit laudan ulkopuolella tai jos ruutu ei tyhjä.
     */
    public boolean MerkitseRuutu(Pelaaja p, int kor, int lev) {

        if (onkoLaudal(kor, lev) == false) {
            return false;
        }

        if (lauta[kor][lev] != 0) {
            return false;
        } else {
            lauta[kor][lev] = p.haekumpi();
            montOn++;
            mahtuuko();
            tarkista(p, kor, lev);
            return true;
        }

    }

    /**
     *
     * tarkistaa onko annetut koordinaatit laudalla.
     *
     * @param kor koordinaatti
     * @param lev koordinaatti
     *
     * @return palauttaa true jos koordinaatit laudalla, palauttaa false jos
     * koordinaatit laudan ulkopuolella.
     */
    public boolean onkoLaudal(int lev, int kor) {
        if (kor < 0 || kor >= lauta.length || lev < 0 || lev >= lauta.length) {
            return false;
        } else {
            return true;
        }

    }

    /**
     *
     * Tarkistetaan joka suuntaan, jos löytyy suora niin pelaaja merkataan
     * voittaneeksi
     *
     * @param pelaaja pelaaja jonka vuoron on
     * @param kor koordinaatti
     * @param lev koordinaatti
     *
     */
    public void tarkista(Pelaaja pelaaja, int kor, int lev) {

        if (vaaka(pelaaja.haekumpi(), kor, lev) || pysty(pelaaja.haekumpi(), kor, lev)
                || vino(pelaaja.haekumpi(), kor, lev) || vino2(pelaaja.haekumpi(), kor, lev)) {
            pelaaja.voitin();

        }




    }

    public void mahtuuko() {
        if (montMahtuu == montOn) {
            täynnä = false;
        }
    }

    /**
     *
     * ******
     * *+++** Metodi testaa tähän suuntaan onko laudalla viiden suoraa. ******
     *
     *
     *
     * @param pelaaja Viimeisimmän merkinnän tehnyt pelaaja.
     * @param kor Viimeisimmän merkinnän sijainti korkeussuunnassa
     * @param lev Viimeisimmän merkinnän sijainti leveyssuunnassa
     *
     * @return true jos löytyi suora false jos ei löytynyt
     */
    public boolean vaaka(int pelaaja, int kor, int lev) {


        String eka = "";

        int korplus = kor;
        int levplus = lev + 1;
        int kerta = 0;

        while (onkoLaudal(korplus, levplus)) {

            eka = eka + lauta[korplus][levplus];
            levplus++;

            kerta++;
            if (kerta > 5) {
                break;
            }

        }

        String toka = "";

        int kormin = kor;
        int levmin = lev - 1;
        int kerta2 = 0;

        while (onkoLaudal(kormin, levmin)) {

            toka = lauta[kormin][levmin] + toka;
            levmin--;

            kerta2++;
            if (kerta2 > 5) {
                break;
            }

        }

        String jono = toka + "" + pelaaja + eka;

        if (jono.contains("11111") || jono.contains("22222")) {
            return true;
        }

        return false;


    }

    /**
     *
     * **+*** **+*** Metodi testaa tähän suuntaan onko laudalla viiden suoraa.
     * **+***
     *
     *
     *
     * @param pelaaja Viimeisimmän merkinnän tehnyt pelaaja.
     * @param kor Viimeisimmän merkinnän sijainti korkeussuunnassa
     * @param lev Viimeisimmän merkinnän sijainti leveyssuunnassa
     *
     * @return true jos löytyi suora false jos ei löytynyt
     */
    public boolean pysty(int pelaaja, int kor, int lev) {

        String eka = "";

        int korplus = kor + 1;
        int levplus = lev;
        int kerta = 0;

        while (onkoLaudal(korplus, levplus)) {

            eka = eka + lauta[korplus][levplus];
            korplus++;

            kerta++;
            if (kerta > 5) {
                break;
            }

        }

        String toka = "";

        int kormin = kor - 1;
        int levmin = lev;
        int kerta2 = 0;

        while (onkoLaudal(kormin, levmin)) {

            toka = lauta[kormin][levmin] + toka;
            kormin--;

            kerta2++;
            if (kerta2 > 5) {
                break;
            }

        }

        String jono = toka + pelaaja + eka;

        if (jono.contains("11111") || jono.contains("22222")) {
            return true;
        }

        return false;

    }

    /**
     *
     * *+**** **+*** Metodi testaa tähän suuntaan onko laudalla viiden suoraa.
     * ***+**
     *
     *
     *
     * @param pelaaja Viimeisimmän merkinnän tehnyt pelaaja.
     * @param kor Viimeisimmän merkinnän sijainti korkeussuunnassa
     * @param lev Viimeisimmän merkinnän sijainti leveyssuunnassa
     *
     * @return true jos löytyi suora false jos ei löytynyt
     */
    public boolean vino(int pelaaja, int kor, int lev) {

        String eka = "";

        int korplus = kor + 1;
        int levplus = lev + 1;
        int kerta = 0;

        while (onkoLaudal(korplus, levplus)) {

            eka = eka + lauta[korplus][levplus];
            korplus++;
            levplus++;
            kerta++;
            if (kerta > 5) {
                break;
            }

        }

        String toka = "";

        int kormin = kor - 1;
        int levmin = lev - 1;
        int kerta2 = 0;

        while (onkoLaudal(kormin, levmin)) {

            toka = lauta[kormin][levmin] + toka;
            kormin--;
            levmin--;
            kerta2++;
            if (kerta2 > 5) {
                break;
            }

        }

        String jono = toka + "" + pelaaja + eka;

        if (jono.contains("11111") || jono.contains("22222")) {
            return true;
        }

        return false;

    }

    /**
     *
     * ***+** **+*** Metodi testaa tähän suuntaan onko laudalla viiden suoraa.
     * *+****
     *
     *
     *
     * @param pelaaja Viimeisimmän merkinnän tehnyt pelaaja.
     * @param kor Viimeisimmän merkinnän sijainti korkeussuunnassa
     * @param lev Viimeisimmän merkinnän sijainti leveyssuunnassa
     *
     * @return true jos löytyi suora false jos ei löytynyt
     */
    public boolean vino2(int pelaaja, int kor, int lev) {



        String eka = "";

        int kormin = kor - 1;
        int levplus = lev + 1;
        int kerta = 0;

        while (onkoLaudal(kormin, levplus)) {

            eka = eka + lauta[kormin][levplus];
            kormin--;
            levplus++;
            kerta++;
            if (kerta > 5) {
                break;
            }

        }

        String toka = "";

        int korplus = kor + 1;
        int levmin = lev - 1;
        int kerta2 = 0;

        while (onkoLaudal(korplus, levmin)) {

            toka = lauta[korplus][levmin] + toka;
            korplus++;
            levmin--;
            kerta2++;
            if (kerta2 > 5) {
                break;
            }

        }

        String jono = toka + "" + pelaaja + eka;

        if (jono.contains("11111") || jono.contains("22222")) {
            return true;
        }

        return false;

    }

    public int[][] haelauta() {
        return lauta;
    }
}
