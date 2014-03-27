
package ohha.shakki;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class GUI {
       JFrame frame;
       JButton[][] taulu;
       Lauta lauta;
       Vuoro vuoro;
       public int pi;
       public int pj;
       public int koko;
       
        GUI(int alkukoko, Pelaaja p1, Pelaaja p2){
            lauta = new Lauta(5);
            vuoro =new Vuoro(p1, p2);
            koko=alkukoko;
            frame=new JFrame("Ristinolla");

            luoKomponentit(frame, koko);
            
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);   
        }

        private void luoKomponentit(Container container, int koko) {
            container.add(new JTextArea());
            container.add(luoRuudukko(koko), BorderLayout.SOUTH);
        }        

    private Component luoRuudukko(int koko ) {
            JPanel panel = new JPanel(new GridLayout(koko,koko));
            taulu=new JButton[koko][koko];
            Paina paina = new Paina();

            for(int i=0; i<koko; i++){
                   for(int j=0; j<koko; j++){
                       pi=i;
                       pj=j;
                       taulu[j][i]=new JButton(lauta.haelauta()[j][i]+"");
                       taulu[j][i].addActionListener(paina);
                       panel.add(taulu[j][i]);
                   }
            }

        return panel;

    }
        
        private class Paina implements ActionListener{
            
            public void actionPerformed(ActionEvent klik){
                
                    
            }
            
        }
}