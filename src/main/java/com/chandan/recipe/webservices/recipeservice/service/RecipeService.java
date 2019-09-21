package com.chandan.recipe.webservices.recipeservice.service;

import com.chandan.recipe.webservices.recipeservice.dao.RecipeRepository;
import com.chandan.recipe.webservices.recipeservice.entity.Recipe;
import com.chandan.recipe.webservices.recipeservice.exception.RecipeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
