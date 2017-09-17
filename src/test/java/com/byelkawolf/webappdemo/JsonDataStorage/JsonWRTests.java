package com.byelkawolf.webappdemo.JsonDataStorage;

import com.byelkawolf.webappdemo.Food.Ingredient;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class JsonWRTests {
    static String foodName1;
    static String foodName2;

    static {
        foodName1 = "TestingBaseFood";
        foodName2 = "TestingFood";
    }

    @Test
    public void jsonWRTest() {
        Ingredient food1 = new Ingredient(JsonWRTests.foodName1);
        JsonWR.jsonWriter(food1);

        Ingredient readIngredient = JsonWR.jsonReader( food1.getName() );
        Assert.assertEquals( readIngredient.getName() , food1.getName() );
        Assert.assertEquals( readIngredient.getNumIngredients() , food1.getNumIngredients() );
        Assert.assertTrue(readIngredient.getIngredients().isEmpty());

        ArrayList<String> ingredientsList = new ArrayList<>( Arrays.asList(readIngredient.getName()) );
        Ingredient food2 = new Ingredient(JsonWRTests.foodName2,ingredientsList);
        JsonWR.jsonWriter( food2 );

        Ingredient readIngredientAgain = JsonWR.jsonReader(food2.getName());
        Assert.assertEquals( readIngredientAgain.getName() , food2.getName() );
        Assert.assertEquals( readIngredientAgain.getNumIngredients() , food2.getNumIngredients() );
        Assert.assertFalse(readIngredientAgain.getIngredients().isEmpty());

        ArrayList<String> anotherIngredientsList = new ArrayList<>(
                Arrays.asList( readIngredient.getName() ,
                               readIngredientAgain.getName() ) );
        Ingredient food3 = new Ingredient(food1.getName()+food2.getName(),anotherIngredientsList);
        JsonWR.jsonWriter( food3 );

        Ingredient readIngredient3 = JsonWR.jsonReader(food3.getName());
        Assert.assertEquals( readIngredient3.getName() , food3.getName() );
        Assert.assertEquals( readIngredient3.getNumIngredients() , food3.getNumIngredients() );
        Assert.assertFalse( readIngredient3.getIngredients().isEmpty());



    }


}
