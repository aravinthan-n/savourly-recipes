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

    @Test
    void testFindRandomWhenEmptyReturnsNull() {
        repository.clear();
        Recipe random = repository.findRandom();
        assertNull(random);
    }

    @Test
    void testFindRandomWithExcludeId() {
        repository.clear();
        Recipe r1 = new Recipe("1", "Pasta", 15);
        Recipe r2 = new Recipe("2", "Pizza", 20);
        repository.save(r1);
        repository.save(r2);

        Recipe selected = repository.findRandom("1");
        assertNotNull(selected);
        assertEquals("2", selected.getId());
        assertEquals("Pizza", selected.getName());
    }
}
