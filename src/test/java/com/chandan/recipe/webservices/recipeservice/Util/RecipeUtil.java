package com.chandan.recipe.webservices.recipeservice.Util;

import com.chandan.recipe.webservices.recipeservice.entity.Recipe;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Calendar;

public class RecipeUtil {

    public static List<Recipe> getAllRecipe(){
        final ArrayList<Recipe> recipes = new ArrayList<>();

        recipes.add(new Recipe(100, new Date(), Boolean.TRUE, 2, "Potato", "Cook in high temperature"));
        recipes.add(new Recipe(101, new Date(), Boolean.TRUE, 4, "Rice", "Cook in Pressure Cooker"));
        recipes.add(new Recipe(102, new Date(), Boolean.FALSE, 6, "Rice, Chicken and Black Pepper", "Cook in low flame"));
        return recipes;
    }

    public static Optional<Recipe> getRecipe(){
        final Recipe recipe = new Recipe(10, new Date(), Boolean.TRUE, 4, "Potato", "Cook in high temperature");
        return Optional.ofNullable(recipe);
    }

    public static Recipe createRecipe(){
        return new Recipe(103, new Date(), Boolean.TRUE, 3, "bread and butter", "bake in induction");
    }

    public static Recipe getRecipeWithoutOptional(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -365);
        Date pastDate = cal.getTime();
        return new Recipe(pastDate, Boolean.TRUE, 6, "milk with cashew nuts", "boil in medium temperature");
    }

    public static Recipe getRecipeWithoutGivingId(){

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -365);
        Date pastDate = cal.getTime();
        Recipe recipe = new Recipe(pastDate, Boolean.TRUE, 6, "milk with cashew nuts", "boil in medium temperature");
        System.out.println(recipe);
        return recipe;
    }

    public static URI getURI(){
        return URI.create("http://localhost:8080/recipe-service/v1/recipes/1");
    }
}
