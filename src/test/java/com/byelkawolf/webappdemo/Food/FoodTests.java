package com.byelkawolf.webappdemo.Food;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class FoodTests {

    @Test
    public void TestBaseFoodSetter(){
        String foodName = "Testing";
        Ingredient aFood = new Ingredient(foodName);
        Assert.assertEquals(aFood.getName(),foodName);
        Assert.assertEquals(aFood.getNumIngredients(),0);
        Assert.assertTrue(aFood.getIngredients().isEmpty());
    }

    @Test
    public void TestFoodSetter(){
        String foodName = "Testing";
        String ingredientName1 = "anIngredient";
        String ingredientName2 = "anotherIngredient";
        ArrayList<String> someIngredients = new ArrayList<>( Arrays.asList(ingredientName1,ingredientName2) );
        Ingredient aFood = new Ingredient(foodName, someIngredients);
        Assert.assertEquals(aFood.getName(),foodName);
        Assert.assertEquals(aFood.getNumIngredients(),someIngredients.size());
        Assert.assertTrue(aFood.getIngredients().contains(ingredientName1));
        Assert.assertTrue(aFood.getIngredients().contains(ingredientName2));
    }
}
