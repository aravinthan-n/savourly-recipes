package co.uk.foodco.recipes.service;

import co.uk.foodco.recipes.model.Recipe;
import co.uk.foodco.recipes.model.Recipes;
import co.uk.foodco.recipes.model.User;

import java.util.List;

public interface RecipesService {
    Recipes listRecipes();
    Recipes listRecipes(int pageNo, int itemsPerPage);

    Recipe getRecipeByName(String name);
    Recipes filterRecipesByTerm(String term);
    Recipes filterRecipesByMaxCookingMinutes(int maxMinutes);

    void starRecipeForUser(String username, String recipeName);
    void unstarRecipeForUser(String username, String recipeName);
    Recipes getStarredRecipesForUser(String username);

    void saveRecipe(Recipe recipe);
    void saveRecipes(List<Recipe> recipes);
    void clear();
    User getUser(String username);
}
