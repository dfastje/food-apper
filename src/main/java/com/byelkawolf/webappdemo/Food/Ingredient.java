package com.byelkawolf.webappdemo.Food;

import java.util.ArrayList;
import java.util.Arrays;

public class Ingredient {
    private final String name;
    private final long numIngredients;
    private final ArrayList<String> ingredients;

    private static final String vName = "name";
    private static final String vNumIngredients = "numIngredients";
    private static final String vIngredients = "ingredients";

    public Ingredient(String foodName, ArrayList<String> ingredientList){
        this.name = foodName;
        this.numIngredients = ingredientList.size();
        this.ingredients = ingredientList;
    }

    public Ingredient(String foodName){
        this.name = foodName;
        this.numIngredients = 0;
        this.ingredients = new ArrayList<>(Arrays.asList());
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public String getName() {
        return name;
    }

    public long getNumIngredients() {
        return numIngredients;
    }

    public static String getvName() {
        return vName;
    }

    public static String getvNumIngredients() {
        return vNumIngredients;
    }

    public static String getvIngredients() {
        return vIngredients;
    }

}
