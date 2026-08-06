package co.uk.savourly.recipes.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Recipes
 *
 * @author Aravinthan Narasimhan
 */
public class Recipes {

    private List<Recipe> recipes = new ArrayList<Recipe>();

    private int totalItems;

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }
}
