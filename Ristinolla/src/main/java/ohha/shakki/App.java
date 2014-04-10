package ohha.shakki;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        System.out.println( "Hello World!" );
        
        new GUI(20, new Pelaaja(1, "X"), new Pelaaja(2, "O"));
        
    }
}
