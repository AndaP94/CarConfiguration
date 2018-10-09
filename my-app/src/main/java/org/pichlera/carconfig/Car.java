package org.pichlera.carconfig;

public class Car {

    private String carBrand;
    private Model model;
    private Outfit outfit;
    private int totalPrice;

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
