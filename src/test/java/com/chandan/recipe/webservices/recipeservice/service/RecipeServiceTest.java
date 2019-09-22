package com.chandan.recipe.webservices.recipeservice.service;

import com.chandan.recipe.webservices.recipeservice.Util.RecipeUtil;
import com.chandan.recipe.webservices.recipeservice.dao.RecipeRepository;
import com.chandan.recipe.webservices.recipeservice.entity.Recipe;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RecipeServiceTest {

    @InjectMocks
    RecipeService recipeService;

    @Mock
    RecipeRepository mockRepository;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllRecipe() {
        when(mockRepository.findAll()).thenReturn(RecipeUtil.getAllRecipe());
        final List<Recipe> allRecipe = recipeService.getAllRecipe();
        assertFalse(allRecipe.isEmpty());
    }

    @Test
    public void testFindRecipe() {
        int id = 10;
        when(mockRepository.findById(id)).thenReturn(RecipeUtil.getRecipe());
        final Recipe recipe = recipeService.findRecipe(id);
        assertNotNull(recipe.getIngredients());
    }

    @Test
    public void testSaveRecipe() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -365);
        Date pastDate = cal.getTime();
        when(mockRepository.save(Mockito.any())).thenReturn(Mockito.any());
        recipeService.saveRecipe(new Recipe(100, pastDate, Boolean.TRUE, 6, "milk with cashew nuts", "boil in medium temperature"));
    }

    @Test
    public void testRemoveRecipe() {
        int id = 20;
        recipeService.removeRecipe(id);

    }
}
