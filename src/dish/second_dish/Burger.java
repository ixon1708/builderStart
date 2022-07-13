package dish.second_dish;

import dish.ingredient.Ingredient;
import dish.type.SecondDish;

import java.util.List;

public class Burger implements SecondDish {
    private final String name;
    private final List<Ingredient> ingredients;
    private final String cutlet;

    public String getName() {
        return name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public String getCutlet() {
        return cutlet;
    }

    public Burger(String name, List<Ingredient> ingredients, String cutlet) {
        this.name = name;
        this.ingredients = ingredients;
        this.cutlet = cutlet;
    }

    @Override
    public String toString() {
        return "Burger{" +
                "name='" + name + '\'' +
                ",\n ingredients=" + ingredients +
                ",\n cutlet='" + cutlet + '\'' +
                "}\n";
    }
}
