package co.uk.savourly.recipes;

import co.uk.savourly.recipes.model.Recipe;
import co.uk.savourly.recipes.model.Recipes;
import co.uk.savourly.recipes.repository.InMemoryRecipesRepositoryStub;
import co.uk.savourly.recipes.service.DefaultRecipesService;

/**
 * Console entry point allowing direct single-file Java execution in VS Code / IDEs.
 */
public class Application {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("  Savourly Recipes Application (JDK 25)");
        System.out.println("==================================================");

        InMemoryRecipesRepositoryStub repository = new InMemoryRecipesRepositoryStub();
        DefaultRecipesService service = new DefaultRecipesService();
        service.setRecipesRepository(repository);

        Recipes recipes = service.listRecipes();
        System.out.println("Loaded Recipes Count: " + recipes.getTotalItems());
        for (Recipe recipe : recipes.getRecipes()) {
            System.out.printf("- %-20s | Cooking Time: %-10s | Ingredients: %s%n",
                    recipe.getName(), recipe.getCookingTime(), recipe.getMainIngredients());
        }

        System.out.println("==================================================");
        System.out.println("Application executed successfully!");
    }
}
