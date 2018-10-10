package org.pichlera.carconfig;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * @author Andreas Pichler
 * @version 1.0 10.10.18
 *
 * Dies ist die Datenbank für die Fahrzeugmodelle und ihren Ausstattungen
 */
public class Database {


    /**
     * Liste für Modelle
     */
    private HashMap<String, ArrayList<Model>> modelList;

    /**
     * Liste für Ausstattungen
     */
    private HashMap<Model, ArrayList<Outfit>> outfitList;


    /**
     * Erstellt Datanbank für Modelle und Aussttatungen
     */
    public Database() {

        this.modelList = new HashMap<>();
        this.outfitList = new HashMap<>();
        fillDatabaseDemoAudi();

    }


    /**
     *
     * @param carBrand Automarke
     * @return gibt alle Modelle der Automarke aus
     */
    public ArrayList<Model> getModelList(String carBrand) {

        return this.modelList.get(carBrand);

    }

    /**
     *
     * @param model Modelle
     * @return gibt alle Ausstattungen aus fuer das Modell
     */
    public ArrayList<Outfit> getOutfitList(Model model) {

        return this.outfitList.get(model);
    }


    /**
     * Fuegt ein Modell hinzu
     * @param carBrand Automarke fuer Modell
     * @param modList Modellliste
     */
    public void addModel(String carBrand, ArrayList<Model> modList) {

        this.modelList.put(carBrand, modList);
    }

    /**
     * Fuegt Ausstattunge hinzu mithilfe des Modells
     * @param model Modell
     * @param outList Ausstatungsliste
     */
    public void addOutfit(Model model, ArrayList<Outfit> outList) {
        this.outfitList.put(model, outList);
    }

    public HashMap<String, ArrayList<Model>> getModelList() {
        return modelList;
    }

    public void setModelList(HashMap<String, ArrayList<Model>> modelList) {
        this.modelList = modelList;
    }

    public HashMap<Model, ArrayList<Outfit>> getOutfitList() {
        return outfitList;
    }

    public void setOutfitList(HashMap<Model, ArrayList<Outfit>> outfitList) {
        this.outfitList = outfitList;
    }


    /**
     * Demo Datenbank INSERT fuer Audi
     */
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

        addModel(carBrand, modelArrayList);
        addOutfit(mod1, mod1Out);
        addOutfit(mod2, mod2Out);
        addOutfit(mod3, mod3Out);

    }
}
