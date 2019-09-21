
package com.chandan.recipe.webservices.recipeservice.controller;

import com.chandan.recipe.webservices.recipeservice.entity.Recipe;
import com.chandan.recipe.webservices.recipeservice.service.RecipeService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController()
@RequestMapping("/recipe-service/v1")
@Api(value = "Recipe Management System which exposes the various end point URL's as a resource")
public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @ApiOperation(value = "View a list of available Recipes", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list of available Recipes"),
            @ApiResponse(code = 401, message = "You would need to provide the Jwt Token to Access This resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/recipes")
    public List<Recipe> retrieveAllRecipe() {
        return recipeService.getAllRecipe();
    }


    @ApiOperation(value = "Get a recipe by Id")
    @GetMapping("/recipes/{id}")
    public Recipe getRecipe(
            @ApiParam(value = "Recipe id from which recipe object will retrieve", required = true) @PathVariable(value = "id") int id) {
        return recipeService.findRecipe(id);
    }

    @ApiOperation(value = "Add a Recipe")
    @PostMapping("/recipes")
    public void createRecipe(
            @ApiParam(value = "Recipe object store in database table", required = true) @Valid @RequestBody Recipe recipe) {
        recipeService.saveRecipe(recipe);
    }

    @ApiOperation(value = "Delete a Recipe")
    @DeleteMapping("/recipes/{id}")
    public void deleteRecipe(@ApiParam(value = "Recipe Id from which recipe object will deleted from database table", required = true) @PathVariable(value = "id") int id) {
        recipeService.removeRecipe(id);
    }
}
