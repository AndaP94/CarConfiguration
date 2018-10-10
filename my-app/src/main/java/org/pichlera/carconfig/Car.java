package org.pichlera.carconfig;


/**
 * @author Andreas Pichler
 * @version 1.0 10.10.18
 *
 * Dies ist die Car Klasse zur Erstellung eines bestellen Autos
 *
 *
 */
public class Car {
    /**
     * Dies die die Automarke des Fahrzeuges
     */
    private String carBrand;

    /**
     * Dies ist das Modell des Autos
     */
    private Model model;

    /**
     * Dies ist die Ausstatttung des Autos
     */
    private Outfit outfit;

    /**
     * Gesammtpreis des Fahrzeuges
     */
    private int totalPrice;


    /**
     * Erstellt ein Auto mit der Automarke und setzt alles auf null
     *
     * @param carBrand Automarke wird übergeben
     */
    public Car(String carBrand) {
        this.carBrand = carBrand;
        this.model = null;
        this.outfit = null;
        this.totalPrice = 0;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Outfit getOutfit() {
        return outfit;
    }

    public void setOutfit(Outfit outfit) {

        this.outfit = outfit;
    }

    public int getTotalPrice() {

        return this.totalPrice;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }


    /**
     * setzt den Preis mithilfe der einzelnen Komponenten
     */
    public void setTotalPrice() {
        int price = 0;
        if(!(model==null)){
            price+=model.getPrice();
        }
        if(!(outfit==null)){
            price+=outfit.getPrice();
        }
        this.totalPrice = price;
    }


    /**
     *
     * @return gibt das Auto mit seinen einzlenen Komponenten aus + Gesamtpreis
     */
    public String toString(){
        setTotalPrice();
        String output = getCarBrand() + "\n";
        if(!(this.model==null)){
            output += "Model: " + this.model.getName() + "\t\t\tPrice: " + this.model.getPrice();
        }
        if(!(this.outfit==null)){
            output += "\nOutfit " + this.outfit.getOutfit() + "\t\t\tPrice: " + this.outfit.getPrice();

        }

        output+="\nTotal Price: " + this.totalPrice;

        return output + "\n\n";
    }
}
