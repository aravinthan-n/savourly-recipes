package co.uk.foodco.recipes.repository;

import co.uk.foodco.recipes.model.Recipe;
import co.uk.foodco.recipes.model.Recipes;
import co.uk.foodco.recipes.model.User;

import java.util.List;

public interface RecipesRepository {
    Recipes findAll();
    void save(Recipe recipe);
    void saveAll(List<Recipe> recipes);
    Recipe findByName(String name);
    void clear();

    User findUserByName(String username);
    void saveUser(User user);
    List<Recipe> findStarredRecipesForUser(String username);
}
