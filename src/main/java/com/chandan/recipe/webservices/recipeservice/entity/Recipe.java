
package com.chandan.recipe.webservices.recipeservice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@ApiModel(description = "All details about the recipe")
public class Recipe {

    @Id
    @GeneratedValue
    private int id;

    @Past
    @ApiModelProperty(notes = "Create date should be in past")
    private Date creation;

    @NotNull
    private boolean isVegetarian;

    @NotNull
    private int sufficientForPeople;

    @Size(min = 2, message = "Ingredients should have at least 2 characters")
    @ApiModelProperty(notes = "Ingredients should have at least 2 characters")
    private String ingredients;

    @Size(min = 5, message = "cookingInstructions should have at least 5 characters")
    @ApiModelProperty(notes = "cookingInstructions should have at least 5 characters")
    private String cookingInstructions;


    public Recipe() {
    }

    public Recipe(Date creation, boolean isVegetarian, int sufficientForPeople, String ingredients, String cookingInstructions
    ) {
        this.creation = creation;
        this.isVegetarian = isVegetarian;
        this.sufficientForPeople = sufficientForPeople;
        this.ingredients = ingredients;
        this.cookingInstructions = cookingInstructions;
    }


    public Recipe(int id, Date creation, boolean isVegetarian, int sufficientForPeople, String ingredients, String cookingInstructions) {
        this.id = id;
        this.creation = creation;
        this.isVegetarian = isVegetarian;
        this.sufficientForPeople = sufficientForPeople;
        this.ingredients = ingredients;
        this.cookingInstructions = cookingInstructions;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", creation=" + creation +
                ", isVegetarian=" + isVegetarian +
                ", sufficientForPeople=" + sufficientForPeople +
                ", ingredients='" + ingredients + '\'' +
                ", cookingInstructions='" + cookingInstructions + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        isVegetarian = vegetarian;
    }

    public int getSufficientForPeople() {
        return sufficientForPeople;
    }

    public void setSufficientForPeople(int sufficientForPeople) {
        this.sufficientForPeople = sufficientForPeople;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getCookingInstructions() {
        return cookingInstructions;
    }

    public void setCookingInstructions(String cookingInstructions) {
        this.cookingInstructions = cookingInstructions;
    }
}





