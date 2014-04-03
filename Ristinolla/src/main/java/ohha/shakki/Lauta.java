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
public class Lauta {
    
    private int[][] lauta;
    private int montMahtuu;
    public int montOn;
    public boolean voijatkuu;
    
    public Lauta (int koko){
        
        lauta = new int[koko][koko];
        montMahtuu=koko*koko;
        montOn=0;
        voijatkuu=true;
        
    }

    public boolean MerkitseRuutu(Pelaaja p, int kor, int lev){

        if(onkoLaudal(kor, lev)==false){
            return false;
        }
        
        if(lauta[kor][lev]!=0){
            return false;
        }else{
            lauta[kor][lev]=p.haekumpi();
            montOn++;
            mahtuuko();
            tarkista(p, kor, lev);
            return true;
        }
        
    }

    
    public boolean onkoLaudal(int lev, int kor){
        if(kor < 0 || kor > lauta.length || lev < 0 || lev > lauta.length){
            return false;
        }else{
            return true;
        }
        
    }    
    
    
    public void tarkista(Pelaaja pelaaja, int kor, int lev){
        
        if(vaaka(pelaaja.haekumpi(), kor, lev) || pysty(pelaaja.haekumpi(), kor, lev) || 
                vino(pelaaja.haekumpi(), kor, lev) || vino2(pelaaja.haekumpi(), kor, lev)){
            pelaaja.voitin();
         
        }


        //Tarkistetaan joka suuntaan, jos löytyy suora niin pelaaja merkataan voittaneeksi
        
    }
    
    
    public void mahtuuko(){
        if(montMahtuu==montOn){
            voijatkuu=false;
        }
    }
    
    
    public boolean vaaka(int pelaaja, int kor, int lev){
        
//******   
//+++***    testaa tähän suuntaan
//******     
        
        String eka = "";
        
        int korplus=kor;
        int levplus=lev+1;
        int kerta =0;        
        
        while(onkoLaudal(korplus, levplus)){

            eka=eka+lauta[korplus][levplus];
            levplus++;

            kerta++;
            if(kerta>5){
                break;
            }

        }
        
        String toka = "";
        
        int kormin=kor;
        int levmin=lev-1;
        int kerta2 =0;
        
        while(onkoLaudal(kormin, levmin)){

            toka=lauta[kormin][levmin]+toka;
            levmin--;

            kerta2++;
            if(kerta2>5){
                break;
            }

        }
        
        String jono=toka+""+pelaaja+eka;
        
        if(jono.contains("11111") || jono.contains("22222")){
            return true;
        }
        
        return false;          
            
        
    }
    
    
    public boolean pysty(int pelaaja, int kor, int lev){
        
//*+**   
//*+**    testaa tähän suuntaan
//*+**     
        
        String eka = "";
        
        int korplus=kor+1;
        int levplus=lev;
        int kerta =0;        
        
        while(onkoLaudal(korplus, levplus)){

            eka=eka+lauta[korplus][levplus];
            korplus++;

            kerta++;
            if(kerta>5){
                break;
            }

        }
        
        String toka = "";
        
        int kormin=kor-1;
        int levmin=lev;
        int kerta2 =0;
        
        while(onkoLaudal(kormin, levmin)){

            toka=lauta[kormin][levmin]+toka;
            kormin--;

            kerta2++;
            if(kerta2>5){
                break;
            }

        }
        
        String jono=toka+pelaaja+eka;
        
        if(jono.contains("11111") || jono.contains("22222")){
            return true;
        }
        
        return false;          
        
    }    

    public boolean vino(int pelaaja, int kor, int lev){

//*+****   
//**+***    testaa tähän suuntaan
//***+**     
        
        String eka = "";
        
        int korplus=kor+1;
        int levplus=lev+1;
        int kerta =0;        
        
        while(onkoLaudal(korplus, levplus)){

            eka=eka+lauta[korplus][levplus];
            korplus++;
            levplus++;
            kerta++;
            if(kerta>5){
                break;
            }

        }
        
        String toka = "";
        
        int kormin=kor-1;
        int levmin=lev-1;
        int kerta2 =0;
        
        while(onkoLaudal(kormin, levmin)){

            toka=lauta[kormin][levmin]+toka;
            kormin--;
            levmin--;
            kerta2++;
            if(kerta2>5){
                break;
            }

        }
        
        String jono=toka+""+pelaaja+eka;
        
        if(jono.contains("11111") || jono.contains("22222")){
            return true;
        }
        
        return false;     
        
    }    
    

    public boolean vino2(int pelaaja, int kor, int lev){
//***+**       
//**+***    testaa tähän suuntaan
//*+****      
        
        
        
        String eka = "";
        
        int kormin=kor-1;
        int levplus=lev+1;
        int kerta =0;        
        
        while(onkoLaudal(kormin, levplus)){

            eka=eka+lauta[kormin][levplus];
            kormin--;
            levplus++;
            kerta++;
            if(kerta>5){
                break;
            }

        }
        
        String toka = "";
                
        int korplus=kor+1;
        int levmin=lev-1;
        int kerta2 =0;
        
        while(onkoLaudal(korplus, levmin)){

            toka=lauta[korplus][levmin]+toka;
            korplus++;
            levmin--;
            kerta2++;
            if(kerta2>5){
                break;
            }

        }
        
        String jono=toka+""+pelaaja+eka;
        
        if(jono.contains("11111") || jono.contains("22222")){
            return true;
        }
        
        return false;     
        
    }        

    public int[][] haelauta(){
        return lauta;
    }

}       