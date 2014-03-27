package ohha.shakki;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        System.out.println( "Hello World!" );
        
        new GUI(5, new Pelaaja(1), new Pelaaja(2));
        
    }
}
