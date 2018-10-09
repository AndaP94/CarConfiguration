package org.pichlera.carconfig;

import java.util.ArrayList;
import java.util.HashMap;

public class Database {

    private HashMap<String, ArrayList<Model>> modellList;
    private HashMap<Model, ArrayList<Outfit>> outfitList;


    public Database() {

        this.modellList = new HashMap<>();
        this.outfitList = new HashMap<>();
        fillDatabaseDemoAudi();

    }

    public ArrayList<Model> getModelList(String carBrand) {

        return this.modellList.get(carBrand);

    }

    public ArrayList<Outfit> getOutfitList(Model modell) {

        return this.outfitList.get(modell);
    }

    public void addModell(String carBrand, ArrayList<Model> modList) {

        this.modellList.put(carBrand, modList);
    }

    public void addOutfit(Model modell, ArrayList<Outfit> outList) {
        this.outfitList.put(modell, outList);
    }

    public HashMap<String, ArrayList<Model>> getModellList() {
        return modellList;
    }

    public void setModellList(HashMap<String, ArrayList<Model>> modelList) {
        this.modellList = modelList;
    }

    public HashMap<Model, ArrayList<Outfit>> getOutfitList() {
        return outfitList;
    }

    public void setOutfitList(HashMap<Model, ArrayList<Outfit>> outfitList) {
        this.outfitList = outfitList;
    }

    private void fillDatabaseDemoAudi() {

        String carBrand = "Audi";
        Model mod1 = new Model("A1", 50000);
        Model mod2 = new Model("A3", 80000);
        Model mod3 = new Model("A6", 150000);
        Outfit out1 = new Outfit("Sport", 30000);
        Outfit out2 = new Outfit("Minimal", 5000);
        Outfit out3 = new Outfit("Complete", 15000);
        Outfit out4 = new Outfit("Limousine", 40000);
        ArrayList<Model> modelArrayList = new ArrayList<>();
        modelArrayList.add(mod1);
        modelArrayList.add(mod2);
        modelArrayList.add(mod3);

        ArrayList<Outfit> mod1Out = new ArrayList<>();
        mod1Out.add(out1);
        mod1Out.add(out2);
        mod1Out.add(out3);

        ArrayList<Outfit> mod2Out = new ArrayList<>();
        mod2Out.add(out1);
        mod2Out.add(out2);
        mod2Out.add(out3);

        ArrayList<Outfit> mod3Out = new ArrayList<>();
        mod3Out.add(out1);
        mod3Out.add(out2);
        mod3Out.add(out4);

        addModell(carBrand, modelArrayList);
        addOutfit(mod1, mod1Out);
        addOutfit(mod2, mod2Out);
        addOutfit(mod3, mod3Out);

    }
}
