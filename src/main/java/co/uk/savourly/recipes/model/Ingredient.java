package co.uk.savourly.recipes.model;

import java.util.Objects;

/**
 * Represents a detailed ingredient in a recipe with a quantity and name.
 */
public class Ingredient {

    private String quantity;
    private String name;

    public Ingredient() {
    }

    public Ingredient(String quantity, String name) {
        this.quantity = quantity;
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Formats ingredient for display (e.g., "4 x Chicken Breasts", "1 tsp Thyme").
     */
    public String getFormatted() {
        if (quantity == null || quantity.trim().isEmpty()) {
            return name;
        }
        String qty = quantity.trim();
        // If quantity is numeric (e.g. "4" or "1"), format as "4 x Chicken Breasts"
        if (qty.matches("^\\d+$")) {
            return qty + " x " + name;
        }
        // Otherwise format as "1 tsp Thyme"
        return qty + " " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return Objects.equals(quantity, that.quantity) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity, name);
    }

    @Override
    public String toString() {
        return getFormatted();
    }
}
