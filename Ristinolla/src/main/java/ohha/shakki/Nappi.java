
 
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
   
    public Nappi (Vuoro v, Lauta l, int kor, int lev, JLabel tekstialue){
//        X=new ImageIcon(this.getClass().getResource("/images/x1.png"));
//        O=new ImageIcon(this.getClass().getResource("/images/o1.png"));
        setText(null);
        setIcon(null);
        vuoro=v;
        lauta=l;
        korkeus=kor;
        leveys=lev;
        teksti=tekstialue;
        
        teksti.setText("Pelaajan: "+vuoro.jonkavuoro.nimi+" vuoro");
        teksti.setHorizontalAlignment(SwingConstants.CENTER);
        
        addActionListener(this);
    }
   
   
    @Override
    public void actionPerformed(ActionEvent e) {
       
        boolean tyhjä = lauta.MerkitseRuutu(vuoro.jonkavuoro, korkeus, leveys);
        System.out.println(""+tyhjä);
        System.out.println(""+lauta.haelauta()[korkeus][leveys]);

        if(tyhjä==true){

            if(vuoro.vuoro==1){
                setText("X");
//                setIcon(X);
            }else if(vuoro.vuoro==2){
                setText("O");
//                setIcon(O);
            }
            
            
            if(vuoro.jonkavuoro.haevoitto()){
                teksti.setText(vuoro.jonkavuoro.nimi+" voitti!!!!");
            }else{
                vuoro.Vuoronvaihto();
                teksti.setText("Pelaajan: "+vuoro.jonkavuoro.nimi+" vuoro");
            }
            
            if(lauta.voijatkuu==false){
                teksti.setText("Tasapeli");
            }
            
            teksti.repaint();
            
        }
       
    }
   
}