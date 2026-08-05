package co.uk.foodco.recipes.model;

import java.util.ArrayList;
import java.util.List;

/**
 * User model representing a system user and their starred recipes.
 */
public class User {

    private String name;
    private List<String> starredRecipeNames = new ArrayList<>();

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getStarredRecipeNames() {
        return starredRecipeNames;
    }

    public void setStarredRecipeNames(List<String> starredRecipeNames) {
        this.starredRecipeNames = starredRecipeNames;
    }

    public void starRecipe(String recipeName) {
        if (!starredRecipeNames.contains(recipeName)) {
            starredRecipeNames.add(recipeName);
        }
    }

    public void unstarRecipe(String recipeName) {
        starredRecipeNames.remove(recipeName);
    }
}
