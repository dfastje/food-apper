package com.byelkawolf.webappdemo.controllers;

import com.byelkawolf.webappdemo.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/food")
public class FoodController {
    @Autowired
    FoodService foodService;

    @RequestMapping(value = "/makeFood/{foodName}", method = RequestMethod.POST)// TODO: 9/6/2017 finish mapping
    public @ResponseBody Boolean makeFood(@PathVariable String foodName, @RequestBody ArrayList<String> ingredients){
        return foodService.makeFoodFile(foodName,ingredients);
    }
}
