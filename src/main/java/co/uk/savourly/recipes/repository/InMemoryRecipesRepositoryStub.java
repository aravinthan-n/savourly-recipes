package co.uk.savourly.recipes.repository;

import co.uk.savourly.recipes.model.Recipe;
import co.uk.savourly.recipes.model.Recipes;
import co.uk.savourly.recipes.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("inMemoryRecipesRepositoryStub")
public class InMemoryRecipesRepositoryStub implements RecipesRepository {

    @Value("#{systemProperties['totalRecipes'] ?: 12}")
    private String totalRecipeToBuild;

    private final List<Recipe> dynamicRecipes = new ArrayList<>();
    private final Map<String, User> userMap = new HashMap<>();
    private boolean customized = false;

    @Override
    public synchronized Recipes findAll() {
        List<Recipe> recipeList;
        if (customized) {
            recipeList = new ArrayList<>(dynamicRecipes);
        } else {
            recipeList = getDefaultRecipes();
        }
        Recipes recipes = new Recipes();
        recipes.setRecipes(recipeList);
        recipes.setTotalItems(recipeList.size());
        return recipes;
    }

    private List<Recipe> getDefaultRecipes() {
        int totalRecipes = 12;
        try {
            totalRecipes = Integer.parseInt(totalRecipeToBuild);
        } catch (NumberFormatException ignored) {
        }

        if (totalRecipes == 0) {
            return Collections.emptyList();
        }

        List<Recipe> all = createSampleRecipes();
        if (totalRecipes >= all.size()) {
            return all;
        }
        return new ArrayList<>(all.subList(0, totalRecipes));
    }

    private List<Recipe> createSampleRecipes() {
        List<Recipe> list = new ArrayList<>();
        list.add(new Recipe("1", "Lemon Chicken", 30, "Lemon", "Chicken", "Thyme"));
        list.add(new Recipe("2", "Beef Stroganoff", 30, "Beef", "Mustard", "Mushrooms"));
        list.add(new Recipe("3", "Caesar Salad", 25, "Lettuce", "Croutons", "Parmesan"));
        list.add(new Recipe("4", "Lemon Rice", 15, "Lemon", "Rice", "Green Chillies"));
        list.add(new Recipe("5", "Ghee Rice", 20, "Rice", "Ghee"));
        list.add(new Recipe("6", "Coriander Rice", 25, "Coriander", "Rice"));
        list.add(new Recipe("7", "Chicken Pizza", 30, "Chicken", "Flour", "Onions"));
        list.add(new Recipe("8", "Cheese Pizza", 30, "Mozarella Cheese", "Flour", "Mushrooms"));
        list.add(new Recipe("9", "Supreme Pizza", 25, "Cheddar Cheese", "Flour", "Onions"));
        list.add(new Recipe("10", "Dosa", 90, "Rice flour", "Urad Dhal"));
        list.add(new Recipe("11", "Idly", 90, "Rice flour", "Urad Dhal"));
        list.add(new Recipe("12", "Roti", 40, "Wheat flour"));
        return list;
    }

    @Override
    public synchronized void save(Recipe recipe) {
        customized = true;
        dynamicRecipes.removeIf(r -> r.getName().equalsIgnoreCase(recipe.getName()));
        dynamicRecipes.add(recipe);
    }

    @Override
    public synchronized void saveAll(List<Recipe> recipes) {
        customized = true;
        for (Recipe r : recipes) {
            save(r);
        }
    }

    @Override
    public synchronized Recipe findByName(String name) {
        List<Recipe> source = customized ? dynamicRecipes : getDefaultRecipes();
        return source.stream()
                .filter(r -> r.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public synchronized void clear() {
        customized = true;
        dynamicRecipes.clear();
        userMap.clear();
    }

    @Override
    public synchronized User findUserByName(String username) {
        return userMap.computeIfAbsent(username, User::new);
    }

    @Override
    public synchronized void saveUser(User user) {
        userMap.put(user.getName(), user);
    }

    @Override
    public synchronized List<Recipe> findStarredRecipesForUser(String username) {
        User user = userMap.get(username);
        if (user == null || user.getStarredRecipeNames().isEmpty()) {
            return Collections.emptyList();
        }
        List<Recipe> starred = new ArrayList<>();
        for (String recipeName : user.getStarredRecipeNames()) {
            Recipe r = findByName(recipeName);
            if (r != null) {
                starred.add(r);
            }
        }
        return starred;
    }
}
