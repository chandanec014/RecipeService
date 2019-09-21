
package com.chandan.recipe.webservices.recipeservice.controller;

import com.chandan.recipe.webservices.recipeservice.entity.Recipe;
import com.chandan.recipe.webservices.recipeservice.service.RecipeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController()
@RequestMapping("/recipe-service/v1")
@Api(value = "Recipe Management System")
public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipes")
    public List<Recipe> retrieveAllRecipe() {
        return recipeService.getAllRecipe();
    }

    @GetMapping("/recipes/{id}")
    public Recipe getRecipe(@PathVariable int id) {
        return recipeService.findRecipe(id);
    }

    @PostMapping("/recipes")
    public void createRecipe(@Valid @RequestBody Recipe recipe) {
        recipeService.saveRecipe(recipe);
    }

    @DeleteMapping("/recipes/{id}")
    public void deleteRecipe(@PathVariable int id) {
        recipeService.removeRecipe(id);
    }

}



