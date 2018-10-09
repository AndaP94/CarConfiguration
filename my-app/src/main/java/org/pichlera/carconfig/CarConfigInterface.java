package org.pichlera.carconfig;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;


public class CarConfigInterface {

    private String carBrand;
    private Database database;
    private int caseNumb;
    private Car orderCar;
    private Scanner scan;
    private GregorianCalendar now;
    private DateFormat df;

    public CarConfigInterface(String carBrand){

        this.carBrand = carBrand;
        this.database = new Database();
        this.caseNumb = 0;
        this.orderCar = new Car(carBrand);
        this.scan = new Scanner(System.in);
        this.now = new GregorianCalendar();
        this.df  = DateFormat.getDateInstance(DateFormat.MEDIUM);

    }


    public String showModels(){

        String list = "";
        ArrayList<Model> modelArrayList = database.getModelList(this.carBrand);

        for(int i = 0; i < modelArrayList.size(); i++){

            list+= (i+1) + ": " + modelArrayList.get(i).toString() + "\n";
        }

        return list;

    }

    public String showOutfits(Model modell){

        String list = "";
        ArrayList<Outfit> outfitArrayList = database.getOutfitList(modell);

        for(int i = 0; i < outfitArrayList.size(); i++){
            list+= (i+1) + ": " + outfitArrayList.get(i).toString() + "\n";
        }

        return list;
    }

    public String getCarBrand(){
        return this.carBrand;
    }

    private String[] getCommands(){

        String[] commandList = {"Start", "Quit", "Next", "Back"};
        return commandList;
    }

    public Database getDatabase(){
        return this.database;
    }



    public void start(){

        boolean check = false;


        do {
            switch (caseNumb) {

                case (0):
                    startText();
                    if (!(orderCar.getModel() == null)) {
                        orderCar.setModel(null);
                    }
                    commands();
                    break;

                case (1):
                    if (!(orderCar.getOutfit() == null)) {
                        orderCar.setOutfit(null);
                    }

                    stepOneModel();
                    System.out.println(orderCar.toString());
                    commands();

                    break;

                case (2):
                    stepTwoOutfit();
                    System.out.println(orderCar.toString());
                    commands();

                    break;

                case (3):
                    System.out.println("Do you want order this car ");
                    System.out.println("\n\nYour car: \n" + orderCar.toString());
                    commands();
                    break;

                case (4):
                    System.out.println("Thank you for the Order \nYour Car will come on the " + getOrderDay());


                case (9):
                    check = true;
                    System.out.println("Good Bye");
                    break;

            }

        } while (!check);
    }

    private void startText() {


        System.out.println(" Welcome at the " + getCarBrand() + " car configuration \tToday: " + df.format(now.getTime()) +
                "\n**********************************************************\n\n");

        System.out.println("In three steps you can model your own car and order it");

    }

    private void commands() {
        int size = getCommands().length;
        String[] commandList = getCommands();
        StringBuilder list = new StringBuilder();
        if (caseNumb == 0) {
            size--;
        }

        if (caseNumb == 3) {
            commandList[2] = "Order Now";
        }

        for (int i = 0; i < size; i++) {
            list.append(i + 1).append(".").append(commandList[i]).append("\t\t");
        }

        System.out.print("nextStep>> ");
        System.out.print(list + "\n\n");
        int choice;
        boolean a = false;
        do {

            choice = parser();

            if (choice >= size) {
                System.out.println("Pls type the right number");
            } else {
                a = true;
            }
        } while (!a);


        switch (choice) {
            case 0:
                caseNumb = 0;
                break;
            case 1:
                caseNumb = 9;
                break;
            case 2:
                caseNumb++;
                break;
            case 3:
                caseNumb--;
                break;
        }
    }

    private void stepOneModel() {

        System.out.println("1. Step: Choose your Model");
        System.out.println(showModels());

        Model model = null;
        do {
            try {
                int index = parser();
                model = getDatabase().getModelList(getCarBrand()).get(index);

            } catch (IndexOutOfBoundsException ex) {
                System.out.println("Pls choose a right index number! ");
                System.out.println(showModels());
            }
        } while (model == null);

        orderCar.setModel(model);

    }

    private int parser() {
        int choiceParser = 0;
        boolean checking = false;

        do {

            try {
                choiceParser = Integer.parseInt(scan.nextLine());
                checking = true;
            } catch (NumberFormatException e) {
                System.out.println("pls type a number");
            }
        } while (!checking);
        return choiceParser - 1;
    }

    private void stepTwoOutfit() {


        System.out.println("2. Step: Choose your outfit for the " + orderCar.getModel() + "\n");

        System.out.println(showOutfits(orderCar.getModel()));

        Outfit outfit = null;
        do {
            try {
                int index = parser();
                outfit = getDatabase().getOutfitList(orderCar.getModel()).get(index);

            } catch (IndexOutOfBoundsException e) {

                System.out.println("Pls choose a right index number! ");
                System.out.println(showOutfits(orderCar.getModel()));
            }

        } while (outfit == null);

        orderCar.setOutfit(outfit);

    }

    private  String getOrderDay() {

        now.add(Calendar.DAY_OF_MONTH, 30);

        if (now.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
            now.add(Calendar.DAY_OF_MONTH, 2);
        }
        if (now.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            now.add(Calendar.DAY_OF_MONTH, 1);
        }
        return df.format(now.getTime());
    }

}
