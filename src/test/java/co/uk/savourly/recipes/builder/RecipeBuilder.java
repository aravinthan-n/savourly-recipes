package co.uk.savourly.recipes.builder;

import co.uk.savourly.recipes.model.Recipe;

import java.util.ArrayList;
import java.util.List;

/**
 * RecipeBuilder test fixture builder.
 *
 * @author Aravinthan Narasimhan
 */
public class RecipeBuilder {

    private final Recipe recipe = new Recipe();

    public Recipe build() {
        return recipe;
    }

    public RecipeBuilder withId(String id) {
        recipe.setId(id);
        return this;
    }

    public RecipeBuilder withName(String name) {
        recipe.setName(name);
        return this;
    }

    public RecipeBuilder withCookingMinutes(int minutes) {
        recipe.setCookingMinutes(minutes);
        return this;
    }

    public RecipeBuilder addIngredients(String... ingredients) {
        for (String ingredient : ingredients) {
            recipe.getMainIngredients().add(ingredient);
        }
        return this;
    }

    public static List<Recipe> getOneRecipe() {
        Recipe lemonChicken = buildRecipe("1", "Lemon Chicken", 30, "Lemon", "Chicken", "Thyme");

        List<Recipe> recipeList = new ArrayList<>();
        recipeList.add(lemonChicken);
        return recipeList;
    }

    public static List<Recipe> getThreeRecipes() {
        Recipe lemonChicken = buildRecipe("1", "Lemon Chicken", 30, "Lemon", "Chicken", "Thyme");
        Recipe beefStroganoff = buildRecipe("2", "Beef Stroganoff", 30, "Beef", "Mustard", "Mushrooms");
        Recipe caesarSalad = buildRecipe("3", "Caesar Salad", 25, "Lettuce", "Croutons", "Parmesan");

        List<Recipe> recipeList = new ArrayList<>();
        recipeList.add(lemonChicken);
        recipeList.add(beefStroganoff);
        recipeList.add(caesarSalad);
        return recipeList;
    }

    public static List<Recipe> getTenRecipes() {
        Recipe lemonChicken = buildRecipe("1", "Lemon Chicken", 30, "Lemon", "Chicken", "Thyme");
        Recipe beefStroganoff = buildRecipe("2", "Beef Stroganoff", 30, "Beef", "Mustard", "Mushrooms");
        Recipe caesarSalad = buildRecipe("3", "Caesar Salad", 25, "Lettuce", "Croutons", "Parmesan");

        Recipe lemonRice = buildRecipe("4", "Lemon Rice", 15, "Lemon", "Rice", "Green Chillies");
        Recipe gheeRice = buildRecipe("5", "Ghee Rice", 20, "Rice", "Ghee");
        Recipe corianderRice = buildRecipe("6", "Coriander Rice", 25, "Coriander", "Rice");

        Recipe chickenPizza = buildRecipe("7", "Chicken Pizza", 30, "Chicken", "Flour", "Onions");
        Recipe cheesePizza = buildRecipe("8", "Cheese Pizza", 30, "Mozarella Cheese", "Flour", "Mushrooms");
        Recipe supremePizza = buildRecipe("9", "Supreme Pizza", 25, "Cheddar Cheese", "Flour", "Onions");

        Recipe dosa = buildRecipe("10", "Dosa", 90, "Rice flour", "Urad Dhal");

        List<Recipe> recipeList = new ArrayList<>();
        recipeList.add(lemonChicken);
        recipeList.add(beefStroganoff);
        recipeList.add(caesarSalad);

        recipeList.add(lemonRice);
        recipeList.add(gheeRice);
        recipeList.add(corianderRice);

        recipeList.add(chickenPizza);
        recipeList.add(cheesePizza);
        recipeList.add(supremePizza);

        recipeList.add(dosa);

        return recipeList;
    }

    public static List<Recipe> getTwelveRecipes() {
        Recipe lemonChicken = buildRecipe("1", "Lemon Chicken", 30, "Lemon", "Chicken", "Thyme");
        Recipe beefStroganoff = buildRecipe("2", "Beef Stroganoff", 30, "Beef", "Mustard", "Mushrooms");
        Recipe caesarSalad = buildRecipe("3", "Caesar Salad", 25, "Lettuce", "Croutons", "Parmesan");

        Recipe lemonRice = buildRecipe("4", "Lemon Rice", 15, "Lemon", "Rice", "Green Chillies");
        Recipe gheeRice = buildRecipe("5", "Ghee Rice", 20, "Rice", "Ghee");
        Recipe corianderRice = buildRecipe("6", "Coriander Rice", 25, "Coriander", "Rice");

        Recipe chickenPizza = buildRecipe("7", "Chicken Pizza", 30, "Chicken", "Flour", "Onions");
        Recipe cheesePizza = buildRecipe("8", "Cheese Pizza", 30, "Mozarella Cheese", "Flour", "Mushrooms");
        Recipe supremePizza = buildRecipe("9", "Supreme Pizza", 25, "Cheddar Cheese", "Flour", "Onions");

        Recipe dosa = buildRecipe("10", "Dosa", 90, "Rice flour", "Urad Dhal");
        Recipe idly = buildRecipe("11", "Idly", 90, "Rice flour", "Urad Dhal");
        Recipe roti = buildRecipe("12", "Roti", 40, "Wheat flour");

        List<Recipe> recipeList = new ArrayList<>();
        recipeList.add(lemonChicken);
        recipeList.add(beefStroganoff);
        recipeList.add(caesarSalad);

        recipeList.add(lemonRice);
        recipeList.add(gheeRice);
        recipeList.add(corianderRice);

        recipeList.add(chickenPizza);
        recipeList.add(cheesePizza);
        recipeList.add(supremePizza);

        recipeList.add(dosa);
        recipeList.add(idly);
        recipeList.add(roti);

        return recipeList;
    }

    public static Recipe buildRecipe(String id, String name, int cookingMinutes, String... ingredients) {
        return new RecipeBuilder().withId(id).withName(name).withCookingMinutes(cookingMinutes).addIngredients(ingredients).build();
    }
}
