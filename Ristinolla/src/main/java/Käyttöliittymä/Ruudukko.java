package Käyttöliittymä;

import Logiikka.Ruutu;
import Logiikka.Lauta;
import Logiikka.Pelaaja;
import Logiikka.Vuoro;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

/**
 *
 * @author jayl@cs Ruudukko luo graafisen käyttöliittymän ja luo nappi olion
 * jokaiselle laudan ruudulle.
 *
 */
public class Ruudukko {

    JFrame frame;
    Vuoro vuoro;
    public Lauta lauta;
    public Ruutu[][] taulu;
    final int laudankoko;
    public int ruudunkoko;
    public JLabel tekstialue;
    public JLabel Xpelaaja;
    public JLabel Opelaaja;
    public JLabel Ovoittoja;
    public JLabel Xvoittoja;
    public JButton Uusipeli;
    ImageIcon X, O;

    public Ruudukko(int alkukoko, Pelaaja p1, Pelaaja p2) {

        lauta = new Lauta(alkukoko);
        vuoro = new Vuoro(p1, p2);
        laudankoko = alkukoko;

        Ovoittoja = new JLabel();
        Xvoittoja = new JLabel();

        frame = new JFrame("Ristinolla");

        katsokoko();
        uusipeli();

        tekstialue = new JLabel();
        Xpelaaja = new JLabel();
        Opelaaja = new JLabel();

        luoKomponentit(frame, laudankoko);

        frame.pack();
        frame.setVisible(true);
    }

    /**
     *
     * Uusipeli luo JButtonin jota painamalla ruudukon voi pyyhkiä tyhjäksi ja
     * pelin voi aloittaa alusta.
     *
     */
    public void uusipeli() {

        Uusipeli = new JButton("Uusi peli");

        Uusipeli.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lauta = new Lauta(laudankoko);

                Vuoro uusivuoro = new Vuoro(vuoro.p1, vuoro.p2);
                vuoro = uusivuoro;

                if (vuoro.jonkavuoro.voitto) {
                    vuoro.jonkavuoro.voittoja++;
                }

                for (int i = 0; i < laudankoko; i++) {
                    for (int j = 0; j < laudankoko; j++) {

                        taulu[i][j].tyhjennä();
                        taulu[i][j].lauta = lauta;
                        taulu[i][j].vuoro = vuoro;

                    }
                }

                Xvoittoja.setText("Voittoja " + vuoro.p2.voittoja + "");
                Ovoittoja.setText("Voittoja " + vuoro.p1.voittoja + "");

                tekstialue.setText("Pelaajan: " + vuoro.jonkavuoro.nimi + " vuoro");

                Xvoittoja.repaint();
                Ovoittoja.repaint();
                tekstialue.repaint();

                vuoro.p1.voitto = false;
                vuoro.p2.voitto = false;
            }
        });

    }

    /**
     *
     * Katsokoko määrittelee ruudukon JButtoneille sopivan koon ruudukon koon
     * mukaan.
     *
     */
    public void katsokoko() {
        if (laudankoko < 10) {
            ruudunkoko = 90;
            X = new ImageIcon(this.getClass().getResource("/main/java/kuvat/x1.png"));
            O = new ImageIcon(this.getClass().getResource("/main/java/kuvat/o1.png"));

        } else if (laudankoko >= 10 && laudankoko < 18) {
            ruudunkoko = 50;
            X = new ImageIcon(this.getClass().getResource("/main/java/kuvat/50_x1.png"));
            O = new ImageIcon(this.getClass().getResource("/main/java/kuvat/50_o1.png"));

        } else {
            ruudunkoko = 27;
            X = new ImageIcon(this.getClass().getResource("/main/java/kuvat/25_x1.png"));
            O = new ImageIcon(this.getClass().getResource("/main/java/kuvat/25_o1.png"));

        }
    }

    private void luoKomponentit(Container container, int koko) {

        container.add(tekstit(), BorderLayout.NORTH);
        container.add(luoRuudukko(koko), BorderLayout.SOUTH);
    }

    /**
     * Tekstit asettaa paikalleen itse peliruudukon ylläpuolella olevat tekstit
     * ja määrittelee mitä niissä lukee.
     *
     */
    private Component tekstit() {
        JPanel panel = new JPanel(new GridLayout(2, 3));
        panel.add(Xpelaaja);
        panel.add(tekstialue);
        panel.add(Opelaaja);

        panel.add(Ovoittoja);
        panel.add(Uusipeli);
        panel.add(Xvoittoja);

        Xvoittoja.setText("Voittoja " + vuoro.p2.voittoja + "");
        Ovoittoja.setText("Voittoja " + vuoro.p1.voittoja + "");

        Xpelaaja.setText(vuoro.p1.nimi + " (X)");
        Opelaaja.setText(vuoro.p2.nimi + " (O)");

        tekstialue.setHorizontalAlignment(SwingConstants.CENTER);
        Opelaaja.setHorizontalAlignment(SwingConstants.RIGHT);


        Uusipeli.setHorizontalAlignment(SwingConstants.CENTER);
        Xvoittoja.setHorizontalAlignment(SwingConstants.RIGHT);

        return panel;
    }

    /**
     *
     * @param koko ruudukon koko
     *
     * luoRuudukko luo Ruutu taulukon joka on täynnä Ruutu olioita.
     *
     * @return panel jossa kaikki nappi oliot on.
     *
     */
    private Component luoRuudukko(int koko) {
        JPanel panel = new JPanel(new GridLayout(koko, koko));
        taulu = new Ruutu[koko][koko];


        for (int i = 0; i < koko; i++) {
            for (int j = 0; j < koko; j++) {

                taulu[j][i] = new Ruutu(vuoro, lauta, i, j, tekstialue, X, O);

                panel.add(taulu[j][i]);
                taulu[j][i].setPreferredSize(new Dimension(ruudunkoko, ruudunkoko));
            }
        }

        return panel;

    }
}