package org.pichlera.carconfig;


/**
 * @author Andreas Pichler
 * @version 1.0 10.10.18
 *
 * Modell fuer Autos
 */
public class Model {

    /**
     * Name des Modells
     */
    private String name;

    /**
     * Preis des Modells
     */
    private int price;


    /**
     * Erstellt Modell mit Name und Preis
     * @param name Name
     * @param price Preis
     */
    public Model(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    /**
     *
     * @return gibt Modell zurueck
     */
    public String toString(){
        return "Model: " + getName() + "\tPrice: " + getPrice();
    }
}
