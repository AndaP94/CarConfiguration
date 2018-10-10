package org.pichlera.carconfig;


/**
 * @author Andreas Pichler
 * @version 1.0 10.10.18
 *
 * Ausstatung fuer Auto
 */
public class Outfit {

    /**
     * Name der Ausstatung
     */
    private String outfit;

    /**
     * Preis der Ausstatung
     */
    private int price;


    /**
     * Erstellt Ausstattung fuer das Modell mit Name und Preis
     * @param outfit Ausstattung
     * @param price Preis
     */
    public Outfit(String outfit, int price) {
        this.outfit = outfit;
        this.price = price;
    }

    public String getOutfit() {
        return outfit;
    }

    public void setOutfit(String outfit) {
        this.outfit = outfit;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    /**
     *
     * @return gibt die Ausstatung aus
     */
    public String toString(){

        return "Outfit: " + getOutfit() + "\tPrice " + getPrice();
    }
}
