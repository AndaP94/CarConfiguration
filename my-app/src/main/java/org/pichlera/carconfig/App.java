package org.pichlera.carconfig;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        CarConfigInterface carConfigInterface = new CarConfigInterface("Audi");
        carConfigInterface.start();
    }
}
