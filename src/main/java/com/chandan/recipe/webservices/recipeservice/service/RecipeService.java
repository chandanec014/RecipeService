package com.chandan.recipe.webservices.recipeservice.service;

import com.chandan.recipe.webservices.recipeservice.dao.RecipeRepository;
import com.chandan.recipe.webservices.recipeservice.entity.Recipe;
import com.chandan.recipe.webservices.recipeservice.exception.RecipeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

/**
 * This class acts as service class in bussiness layer to perform operation
 */
@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    /**
     * @param
     * @return List of Recipe objects
     */
    public List<Recipe> getAllRecipe() {
        return recipeRepository.findAll();
    }

    /**
     * @param id which is the id of the recipe object
     * @return a recipe object
     */
    //Trying to implement HATEOS concept here
    public Recipe findRecipe(int id) {
        return recipeRepository.findById(id).orElseThrow(() -> new RecipeNotFoundException("ID NOT FOUND -->>  " + id));
/*        final Resource<Recipe> recipeResource = new Resource<>(recipe.get());
        final ControllerLinkBuilder linkTo = linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getAllRecipe());
        recipeResource.add(linkTo.withRel("all-recipe"));*/
    }

    /**
     * @param recipe which is a complete recipe object
     * @return a Recipe object which is saved in data base
     */
    public Recipe saveRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    /**
     * @param id which is the id object to be removed
     */
    public void removeRecipe(int id) {
        recipeRepository.deleteById(id);
    }


    /**
     *
     * @param id for which the recipe to be modified
     * @param recipeDetails is the recipe object which contains the property to be modified
     * @return updated recipe Object
     */
    public ResponseEntity<Recipe> updateRecipeById(int id, Recipe recipeDetails) {
        final Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new RecipeNotFoundException("Recipe not found for the given Id :: -->>" + id));
        recipe.setCreation(recipeDetails.getCreation());
        recipe.setSufficientForPeople(recipeDetails.getSufficientForPeople());
        recipe.setIngredients(recipeDetails.getIngredients());
        recipe.setCookingInstructions(recipeDetails.getCookingInstructions());
        recipe.setVegetarian(recipeDetails.isVegetarian());
        final Recipe updatedRecipe = recipeRepository.save(recipe);
        return ResponseEntity.ok(updatedRecipe);
    }

}
