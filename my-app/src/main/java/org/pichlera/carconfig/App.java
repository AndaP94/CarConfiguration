package org.pichlera.carconfig;

/**
 * CarConfig
 * Die App startet Den Autokonfigurator
 * @author Andreas Pichler
 * @version 1.0 10.10.18
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
