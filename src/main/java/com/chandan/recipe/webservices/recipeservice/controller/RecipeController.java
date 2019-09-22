package com.chandan.recipe.webservices.recipeservice.controller;

import com.chandan.recipe.webservices.recipeservice.entity.Recipe;
import com.chandan.recipe.webservices.recipeservice.service.RecipeService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * This class acts as a "REST Controller" (e.g. a web controller, Front Controller)
 * to expose various resources as a end point URL's as a part of RESTFUL WEB SERVICES
 *
 * @author Chandan Kumar
 * @since 0.0.1
 */
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
            @ApiResponse(code = 200, message = "Successfully retrieved list of available recipes"),
            @ApiResponse(code = 401, message = "You would need to provide the Jwt Token to access the list of available recipes"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/recipes")
    public List<Recipe> retrieveAllRecipe() {
        return recipeService.getAllRecipe();
    }

    @ApiOperation(value = "Fetch a recipe by recipe Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully fetch a recipe with the given Id"),
            @ApiResponse(code = 401, message = "You would need to provide the Jwt Token to access this recipe"),
            @ApiResponse(code = 403, message = "Accessing the recipe you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The recipe you were trying to reach is not found")
    })
    @GetMapping("/recipes/{id}")
    public Recipe getRecipe(
            @ApiParam(value = "Recipe id from which recipe object will retrieve", required = true) @PathVariable(value = "id") int id) {
        return recipeService.findRecipe(id);
    }

    @ApiOperation(value = "Add a Recipe in the application")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created a recipe in the Recipe Service Application"),
            @ApiResponse(code = 401, message = "You would need to provide the Jwt Token to create this recipe"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @PostMapping("/recipes")
    public void createRecipe(
            @ApiParam(value = "Recipe object store in database table", required = true) @Valid @RequestBody Recipe recipe) {
        recipeService.saveRecipe(recipe);
    }

    @ApiOperation(value = "Delete a Recipe by giving a Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted a recipe with the given Id"),
            @ApiResponse(code = 401, message = "You would need to provide the Jwt Token to delete this recipe"),
            @ApiResponse(code = 403, message = "Accessing the recipe you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The recipe you were trying to reach is not found")
    })
    @DeleteMapping("/recipes/{id}")
    public void deleteRecipe(@ApiParam(value = "Recipe Id from which recipe object will deleted from database table", required = true) @PathVariable(value = "id") int id) {
        recipeService.removeRecipe(id);
    }

    @ApiOperation(value = "Update a Recipe of with a specific Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated a recipe with the given Id"),
            @ApiResponse(code = 401, message = "You would need to provide the Jwt Token to update this recipe"),
            @ApiResponse(code = 403, message = "Accessing the recipe you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The recipe you were trying to reach is not found")
    })
    @PutMapping("/recipes/{id}")
    public ResponseEntity<Recipe> updateRecipe(
            @ApiParam(value = "Recipe id for which the a specific recipe is updated", required = true) @PathVariable int id,
            @Valid @RequestBody Recipe recipeDetails
    ) {
        return recipeService.updateRecipeById(id, recipeDetails);
    }
}
