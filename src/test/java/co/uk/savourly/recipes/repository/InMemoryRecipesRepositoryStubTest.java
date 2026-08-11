package co.uk.savourly.recipes.repository;

import co.uk.savourly.recipes.model.Recipe;
import co.uk.savourly.recipes.model.Recipes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryRecipesRepositoryStubTest {

    private InMemoryRecipesRepositoryStub repository;

    @BeforeEach
    void setUp() {
        repository = new InMemoryRecipesRepositoryStub();
    }

    @Test
    void testFindRandomReturnsDefaultRecipe() {
        Recipe random = repository.findRandom();
        assertNotNull(random);
        assertNotNull(random.getName());
    }

    @Test
    void testFindRandomCachesDefaultRecipes() {
        Recipe first = repository.findRandom();
        Recipe second = repository.findRandom();
        assertNotNull(first);
        assertNotNull(second);
        // Verify multiple calls work cleanly without re-reading or erroring
        Recipes all = repository.findAll();
        assertEquals(12, all.getTotalItems());
    }

    @Test
    void testSaveAndFindRandomWithCustomRecipes() {
        Recipe customRecipe = new Recipe("100", "Custom Pasta", 15, "Pasta", "Tomato");
        repository.save(customRecipe);

        Recipe random = repository.findRandom();
        assertNotNull(random);
        assertEquals("Custom Pasta", random.getName());
    }
}
