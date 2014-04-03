package ohha.shakki;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        System.out.println( "Hello World!" );
        
        new GUI(15, new Pelaaja(1, "Juntti"), new Pelaaja(2, "Hintti"));
        
    }
}
