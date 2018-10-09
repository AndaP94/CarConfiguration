package org.pichlera.carconfig;

public class Outfit {

    private String outfit;
    private int price;

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

    public String toString(){

        return "Outfit: " + getOutfit() + "\tPrice " + getPrice();
    }
}
