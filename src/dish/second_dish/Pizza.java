package dish.second_dish;

import dish.ingredient.Ingredient;
import dish.type.SecondDish;

import java.util.ArrayList;
import java.util.List;

public class Pizza implements SecondDish {
    private final String name;
    private final List<Ingredient> ingredients;
    private final boolean cheeseBumpers;
    private final String doughBase;

    public String getName() {
        return name;
    }

    public List<Ingredient> getIngredients() {
        return new ArrayList<>(ingredients);
    }

    public String getDoughBase() {
        return doughBase;
    }

    public boolean getCheeseBumpers() {
        return cheeseBumpers;
    }

    public Pizza(String name, List<Ingredient> ingredient, boolean cheeseBumpers, String doughBase) {
        this.name = name;
        this.ingredients = ingredient;
        this.cheeseBumpers = cheeseBumpers;
        this.doughBase = doughBase;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ",\n ingredients=" + ingredients +
                ",\n cheeseBumpers=" + cheeseBumpers +
                ",\n doughBase='" + doughBase + '\'' +
                "}\n";
    }
}
