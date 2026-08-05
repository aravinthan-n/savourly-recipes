package co.uk.foodco.recipes.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Recipe domain model.
 *
 * @author Aravinthan Narasimhan
 */
public class Recipe {

    private String id;
    private String name;
    private int cookingMinutes;
    private String cookingTime;
    private String imageUrl;
    private List<String> mainIngredients = new ArrayList<>();
    private List<Ingredient> ingredients = new ArrayList<>();

    public Recipe() {
    }

    public Recipe(String id, String name, int cookingMinutes, String... mainIngredients) {
        this.id = id;
        this.name = name;
        this.cookingMinutes = cookingMinutes;
        this.cookingTime = cookingMinutes + " minutes";
        for (String ing : mainIngredients) {
            this.mainIngredients.add(ing);
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCookingMinutes() {
        return cookingMinutes;
    }

    public void setCookingMinutes(int cookingMinutes) {
        this.cookingMinutes = cookingMinutes;
        if (this.cookingTime == null || this.cookingTime.isEmpty()) {
            this.cookingTime = cookingMinutes + " minutes";
        }
    }

    public String getCookingTime() {
        if (cookingTime == null && cookingMinutes > 0) {
            return cookingMinutes + " minutes";
        }
        return cookingTime;
    }

    public void setCookingTime(String cookingTime) {
        this.cookingTime = cookingTime;
        if (cookingTime != null) {
            try {
                String numeric = cookingTime.replaceAll("[^0-9]", "");
                if (!numeric.isEmpty()) {
                    this.cookingMinutes = Integer.parseInt(numeric);
                }
            } catch (NumberFormatException ignored) {
            }
        }
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<String> getMainIngredients() {
        return mainIngredients;
    }

    public void setMainIngredients(List<String> mainIngredients) {
        this.mainIngredients = mainIngredients;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void addIngredient(String quantity, String name) {
        this.ingredients.add(new Ingredient(quantity, name));
    }
}
