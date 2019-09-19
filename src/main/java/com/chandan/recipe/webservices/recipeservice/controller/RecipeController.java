
package com.chandan.recipe.webservices.recipeservice.controller;

import com.chandan.recipe.webservices.recipeservice.entity.Recipe;
import com.chandan.recipe.webservices.recipeservice.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController()
@RequestMapping("/recipe-service/v1")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/recipes")
    public List<Recipe> retrieveAllRecipe() {
        return recipeService.getAllRecipe();
    }

    @GetMapping("/recipes/{id}")
    public Recipe getRecipe(@PathVariable int id){
        return recipeService.findRecipe(id);
    }

    @PostMapping("/recipes")
    public void createRecipe( @Valid @RequestBody Recipe recipe) {
        recipeService.saveRecipe(recipe);
    }

    @DeleteMapping("/recipes/{id}")
    public void deleteRecipe(@PathVariable int id) {
        recipeService.removeRecipe(id);
    }

}



