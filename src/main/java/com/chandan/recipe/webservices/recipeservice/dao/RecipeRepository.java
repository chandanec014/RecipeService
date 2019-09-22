package com.chandan.recipe.webservices.recipeservice.dao;

import com.chandan.recipe.webservices.recipeservice.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This class acts as a DAO layer in our Recipe Service Application to perform various CRUD operation
 * Indicates that an annotated Interface/class is a "Repository", originally defined by
 * Domain-Driven Design (Evans, 2003) as "a mechanism for encapsulating storage,
 * retrieval, and search behavior which emulates a collection of objects
 *
 * @author Chandan Kumar
 * @since 0.0.1
 */
@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
}



