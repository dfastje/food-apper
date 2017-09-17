package com.byelkawolf.webappdemo.services;

import com.byelkawolf.webappdemo.Food.Ingredient;
import com.byelkawolf.webappdemo.JsonDataStorage.JsonWR;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

// TODO: 9/6/2017 figure out how to scrub user input data

/*
Notes: this is both a service and the repository ... as no DB is being used
 */
@Service
public class FoodService {

    public Boolean makeFoodFile(String foodName, ArrayList<String> ingredients){
        if(ingredients.isEmpty()){
            return JsonWR.jsonWriter( new Ingredient( foodName ) );
        }else {
            return JsonWR.jsonWriter( new Ingredient( foodName, ingredients ) );
        }
    }
}
