
 
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
package ohha.shakki;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
 
/**
 *
 * @author jayl
 * 
 * Nappi on pelin ruutu jota painamalla voi merkitä kyseiseen ruutuun joko ristin tai nollan.
 */

public class Nappi extends JButton implements ActionListener {
 
       Vuoro vuoro;    
       Lauta lauta;
    ImageIcon X, O;

    private final int korkeus;
    private final int leveys;
    private JLabel teksti;
   
    public Nappi (Vuoro v, Lauta l, int kor, int lev, JLabel tekstialue, ImageIcon aX, ImageIcon aO){
        X=aX;
        O=aO;
//        setText(null);
        setIcon(null);
        vuoro=v;
        lauta=l;
        korkeus=kor;
        leveys=lev;
        teksti=tekstialue;
        
        teksti.setText("Pelaajan: "+vuoro.jonkavuoro.nimi+" vuoro");
        
        addActionListener(this);
    }

    public void tyhjennä(){
        setIcon(null);
    }
    
    
/**
 *
 * @author jayl
 * 
 * actionPerformed asettaa X:n tai O:n tähän ruutuun riippuen kumman vuoro on.
 * Jos ruudussa on jo merkki niin mitään merkintää ei tehdä eikä vuoro vaihdu.
 * Vuoro vaihtuu aina kun merkki tehdään.
 * 
 */
    
   
    @Override
    public void actionPerformed(ActionEvent e) {
       
        boolean tyhjä = lauta.MerkitseRuutu(vuoro.jonkavuoro, korkeus, leveys);
        System.out.println(""+tyhjä);
        System.out.println(""+lauta.haelauta()[korkeus][leveys]);

        if(tyhjä==true){

            if(vuoro.vuoro==1){
//                setText("X");
                setIcon(X);
            }else if(vuoro.vuoro==2){
//                setText("O");
                setIcon(O);
            }
            
            
            if(vuoro.jonkavuoro.haevoitto()){
                teksti.setText(vuoro.jonkavuoro.nimi+" voitti!!!!");
            }else{
                vuoro.Vuoronvaihto();
                teksti.setText("Pelaajan: "+vuoro.jonkavuoro.nimi+" vuoro");
            }
            
            if(lauta.täynnä==false && vuoro.p1.haevoitto()==false && vuoro.p2.haevoitto()==false){
                teksti.setText("Tasapeli");
            }
            
            teksti.repaint();
            
        }
       
    }
   
}