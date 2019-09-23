package com.chandan.recipe.webservices.recipeservice.service;

import com.chandan.recipe.webservices.recipeservice.Util.RecipeUtil;
import com.chandan.recipe.webservices.recipeservice.dao.RecipeRepository;
import com.chandan.recipe.webservices.recipeservice.entity.Recipe;
import com.chandan.recipe.webservices.recipeservice.exception.RecipeNotFoundException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * This class is used to write JUnits for various scenarios as to have code coverage
 * various corner cases have been incorporated
 *
 * @author Chandan Kumar
 * @since 0.0.1
 */
public class RecipeServiceTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule().strictness(Strictness.LENIENT);

    @InjectMocks
    RecipeService recipeService;

    @Mock
    RecipeRepository mockRepository;

    @Before
    public void setUp() {
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

    @Test(expected = RecipeNotFoundException.class)
    public void testFindRecipe_withInvalidId() {
        int id = -1;
        recipeService.findRecipe(id);
    }

    @Test
    public void testSaveRecipe() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -365);
        Date pastDate = cal.getTime();
        when(mockRepository.save(Mockito.any())).thenReturn(Mockito.any());
        recipeService.saveRecipe(new Recipe(100, pastDate, Boolean.TRUE, 6, "milk with cashew nuts", "boil in medium temperature"));
    }

    @Test()
    public void testSaveRecipe_withInvalid_cookingInstructions_as_input() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -365);
        Date pastDate = cal.getTime();
        when(mockRepository.save(Mockito.any())).thenReturn(Mockito.any());
        recipeService.saveRecipe(new Recipe(100, pastDate, Boolean.TRUE, 6, "milk with cashew nuts", "bo"));
        verify(mockRepository, never()).save(new Recipe(100, pastDate, Boolean.TRUE, 6, "milk with cashew nuts", "bo"));
    }

    @Test()
    public void testSaveRecipe_withInvalid_ingredients_as_input() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -365);
        Date pastDate = cal.getTime();
        when(mockRepository.save(Mockito.any())).thenReturn(Mockito.any());
        recipeService.saveRecipe(new Recipe(100, pastDate, Boolean.TRUE, 6, "a", "boil in medium temperature"));
        verify(mockRepository, never()).save(new Recipe(100, pastDate, Boolean.TRUE, 6, "a", "boil in medium temperature"));
    }

    @Test()
    public void testSaveRecipe_byGiving_createDate_as_Null() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -365);
        when(mockRepository.save(Mockito.any())).thenReturn(Mockito.any());
        recipeService.saveRecipe(new Recipe(100, null, Boolean.TRUE, 6, "a", "boil in medium temperature"));
        verify(mockRepository, never()).save(new Recipe(100, null, Boolean.TRUE, 6, "a", "boil in medium temperature"));
    }

    @Test
    public void testRemoveRecipe() {
        int id = 20;
        recipeService.removeRecipe(id);
        verify(mockRepository).deleteById(id);
    }

    @Test
    public void testUpdateRecipeById() {
        int id = 12;
        Recipe recipeDetails = RecipeUtil.getRecipeToBeUpdated();
        when(mockRepository.findById(id)).thenReturn(RecipeUtil.getRecipe());
        when(mockRepository.save(Mockito.any())).thenReturn(recipeDetails);
        assertNotNull(recipeDetails.getIngredients());
    }

    @Test(expected = RecipeNotFoundException.class)
    public void testUpdateRecipeById_withInvalidId() {
        int id = -1;
        Recipe recipeDetails = RecipeUtil.getRecipeToBeUpdated();
        recipeService.updateRecipeById(id, recipeDetails);
    }

    @Test
    public void testUpdateRecipeById_withInvalidData_asCookingInstructions() {
        int id = 12;
        when(mockRepository.findById(id)).thenReturn(RecipeUtil.getRecipe());
        recipeService.updateRecipeById(12, RecipeUtil.getInvalidRecipe());
        verify(mockRepository, never()).save(RecipeUtil.getInvalidRecipe());
    }

    @Test
    public void testUpdateRecipeById_withInvalidInput_likeCreateDate_as_Null() {
        int id = 12;
        when(mockRepository.findById(id)).thenReturn(RecipeUtil.getRecipe());
        recipeService.updateRecipeById(12, RecipeUtil.getInvalidRecipeWithDateAsNull());
        verify(mockRepository, never()).save(RecipeUtil.getInvalidRecipe());
    }
}
