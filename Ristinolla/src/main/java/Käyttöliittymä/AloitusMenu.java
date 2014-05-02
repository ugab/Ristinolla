/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Käyttöliittymä;

import Logiikka.Pelaaja;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author jayl@cs
 *
 * AloitusMenu kysyy käyttäjältä pelaajien nimiä sekä laudan kokoa ja kutsuu
 * luokkaa GUI näillä annetuilla parametreilla.
 *
 */
public final class AloitusMenu {

    JFrame frame;

    public AloitusMenu() {

        frame = new JFrame("Ristinolla");

        luoKomponentit(frame);
        frame.setSize(new Dimension(600, 200));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void luoKomponentit(Container container) {

        GridLayout layout = new GridLayout(4, 2);
        container.setLayout(layout);

        JLabel nimi1Teksti = new JLabel("Anna pelaajan X nimi (1-12 merkkiä) ");
        final JTextField nimi1Kentta = new JTextField();

        JLabel nimi2Teksti = new JLabel("Anna pelaajan O nimi (1-12 merkkiä) ");
        final JTextField nimi2Kentta = new JTextField();

        JLabel kokoTeksti = new JLabel("Anna pelilaudan koko (väliltä 5-30) ");
        final JTextField kokoKentta = new JTextField();


        JButton AloitaNappi = new JButton("Aloita peli!");
        AloitaNappi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (tarkista(kokoKentta.getText(), nimi1Kentta.getText(), nimi2Kentta.getText())) {
                    new Ruudukko(Integer.parseInt(kokoKentta.getText()), new Pelaaja(1, nimi1Kentta.getText()), new Pelaaja(2, nimi2Kentta.getText()));
                }
            }
        });

        container.add(nimi1Teksti);
        container.add(nimi1Kentta);

        container.add(nimi2Teksti);
        container.add(nimi2Kentta);

        container.add(kokoTeksti);
        container.add(kokoKentta);

        container.add(new JLabel(""));
        container.add(AloitaNappi);
    }

    /**
     *
     * @param koko kokokentästä löytyvä teksti.
     * @param nimi1 Käyttäjän syöttämä nimi nimi1kentästä.
     * @param nimi2 Käyttäjän syöttämä nimi nimi1kentästä.
     *
     * @return true jos mikään annetuista parametreistä ei riko niille annettuja
     * rajoitteita, muuten false.
     */
    public boolean tarkista(String koko, String nimi1, String nimi2) {

        try {
            Integer.parseInt(koko);
        } catch (NumberFormatException e) {
            return false;
        }

        if (Integer.parseInt(koko) < 5) {
            return false;
        }

        if (Integer.parseInt(koko) > 30) {
            return false;
        }

        if (nimi1.length() < 1 || nimi1.length() > 12) {
            return false;
        }

        if (nimi2.length() < 1 || nimi2.length() > 12) {
            return false;
        }

        return true;



    }
}
