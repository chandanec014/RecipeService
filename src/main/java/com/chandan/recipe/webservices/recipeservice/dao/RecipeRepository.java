
package com.chandan.recipe.webservices.recipeservice.dao;

import com.chandan.recipe.webservices.recipeservice.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
}



