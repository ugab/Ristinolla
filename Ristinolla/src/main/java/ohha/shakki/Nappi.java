
 
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
 
/**
 *
 * @author jayl
 */
public class Nappi extends JButton implements ActionListener {
 
       Vuoro vuoro;    
       Lauta lauta;
    ImageIcon X, O;
    private boolean tyhjä;
    private int korkeus;
    private int leveys;
    private JLabel teksti;
   
    public Nappi (Vuoro v, Lauta l, int kor, int lev, JLabel tekstialue){
//        X=new ImageIcon(this.getClass().getResource("x1.png"));
//        O=new ImageIcon(this.getClass().getResource("o1.png"));
        setText(null);
        vuoro=v;
        lauta=l;
        tyhjä=true;
        korkeus=kor;
        leveys=lev;
        teksti=tekstialue;
        addActionListener(this);
        teksti.setText(vuoro.jonkavuoro.nimi);
    }
   
   
    @Override
    public void actionPerformed(ActionEvent e) {
       
        if(tyhjä==true){
            if(vuoro.vuoro==1){
                setText("X");
            }else if(vuoro.vuoro==2){
                setText("O");
            }
            lauta.MerkitseRuutu(vuoro.jonkavuoro, korkeus, leveys);
            if(vuoro.jonkavuoro.haevoitto()){
                teksti.setText(vuoro.jonkavuoro.nimi+" voitti!!!!");
            }else{
                vuoro.Vuoronvaihto();
                teksti.setText(vuoro.jonkavuoro.nimi);   
            }
            
            teksti.repaint();
            tyhjä=false;
        }
       
    }
   
}