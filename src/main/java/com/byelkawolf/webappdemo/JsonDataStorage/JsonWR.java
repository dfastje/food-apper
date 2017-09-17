package com.byelkawolf.webappdemo.JsonDataStorage;

import com.byelkawolf.webappdemo.Food.Ingredient;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

// TODO: 9/6/2017 add a delete method 
public class JsonWR {

    private final static String dataStorageLocation;

    static { // TODO: 8/27/2017 change this to grabbing from a properties file
        dataStorageLocation = "C:\\Users\\dfast\\Google Drive\\Development\\HealthApp\\Data\\";
    }

    public static Boolean jsonWriter(Ingredient food){
        String filename = JsonWR.dataStorageLocation + food.getName()+".json";
        JSONObject obj = new JSONObject();
        obj.put(Ingredient.getvName(), food.getName());
        obj.put(Ingredient.getvNumIngredients(), food.getNumIngredients());

        if(food.getNumIngredients()>0) {
            int iterator = 1;
            for (String thisIngredient : food.getIngredients()) {
                obj.put(Ingredient.getvIngredients() + iterator, thisIngredient);
                iterator++;
            }
        }

        try (FileWriter file = new FileWriter(filename)) {
            file.write(obj.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static Ingredient jsonReader(String foodName) {
        //------------------------------------------------------------------------
        // setup file reading
        JSONParser parser = new JSONParser();
        String filename = JsonWR.getDataStorageLocation() + foodName + ".json";
        Ingredient aFood;
        String nameRead;
        long ingredientListLength;
        ArrayList<String> anIngredientList;
        //------------------------------------------------------------------------
        // Read file
        try {
            Object obj = parser.parse(new FileReader(filename));

            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(jsonObject);
            nameRead = (String) jsonObject.get(Ingredient.getvName());
//            ingredientListLength = (int) jsonObject.get(Ingredient.getvNumIngredients());
            ingredientListLength = (long) jsonObject.get(Ingredient.getvNumIngredients());

            int iterator = 0;
            anIngredientList = new ArrayList<>();
            for( int i=0 ; i < ingredientListLength ; i++ ) {
                iterator++;
                anIngredientList.add( (String) jsonObject.get( Ingredient.getvIngredients() + iterator ) );
            }

            aFood = new Ingredient( nameRead, anIngredientList );
            return aFood;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.print("Failed to read food file");
        return null;
    }

    public static String getDataStorageLocation() {
        return dataStorageLocation;
    }
}
