/**
 * ---------------------------------------------------------------
 * The complete copyright of the code belongs to Chandan Kumar
 * ---------------------------------------------------------------
 */
package com.chandan.recipe.webservices.recipeservice.service;

import com.chandan.recipe.webservices.recipeservice.dao.RecipeRepository;
import com.chandan.recipe.webservices.recipeservice.entity.Recipe;
import com.chandan.recipe.webservices.recipeservice.exception.RecipeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class acts as business layer to perform various business related logic
 * Also indicate that a class is a "Business Service Facade" (in the Core J2EE
 * patterns sense), or something similar
 *
 * @author Chandan Kumar
 * @since 0.0.1
 */
@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    /**
     * @param
     * @return a list of Recipe objects from database
     */
    public List<Recipe> getAllRecipe() {
        return recipeRepository.findAll();
    }

    /**
     * @param id is the id of the recipe object
     * @return a recipe object for the given id
     */
    public Recipe findRecipe(int id) {
        return recipeRepository.findById(id)
                .orElseThrow(() -> new RecipeNotFoundException("ID NOT FOUND -->>  " + id));
    }

    /**
     * @param recipe which is a complete recipe object
     * @return a Recipe object which is saved in data base
     */
    public Recipe saveRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    /**
     * @param id is the recipe id for the object to be removed
     */
    public void removeRecipe(int id) {
        recipeRepository.deleteById(id);
    }

    /**
     * @param id is the id of the recipe object
     * @param recipeDetails is the recipe object which contains the property to be modified
     * @return updated recipe Object
     */
    public ResponseEntity<Recipe> updateRecipeById(int id, Recipe recipeDetails) {
        final Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new RecipeNotFoundException("ID NOT FOUND -->>  " + id));
        recipe.setCreation(recipeDetails.getCreation());
        recipe.setSufficientForPeople(recipeDetails.getSufficientForPeople());
        recipe.setIngredients(recipeDetails.getIngredients());
        recipe.setCookingInstructions(recipeDetails.getCookingInstructions());
        recipe.setVegetarian(recipeDetails.isVegetarian());
        final Recipe updatedRecipe = recipeRepository.save(recipe);
        return ResponseEntity.ok(updatedRecipe);
    }
}
