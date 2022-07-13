package dish.builders;

import dish.ingredient.Ingredient;
import dish.second_dish.Burger;

import java.util.ArrayList;
import java.util.List;

public class BurgerBuilder {
    private String name;
    private List<Ingredient> ingredients;
    private String bun;

    public BurgerBuilder() {
        ingredients = new ArrayList<>();
    }

    public BurgerBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public BurgerBuilder addIngredients(Ingredient ingredient) {
        ingredients.add(ingredient);
        return this;
    }

    public BurgerBuilder removeIngredients(Ingredient ingredient) {
        ingredients.remove(ingredient);
        return this;
    }

    public BurgerBuilder resetIngredients() {
        ingredients = new ArrayList<>();
        return this;
    }

    public BurgerBuilder setBun(String bun) {
        this.bun = bun;
        return this;
    }

    public Burger build() {
       if (bun == null || bun.isEmpty()) {
           throw new RuntimeException("Попытка создания бургера без булки");
       }
       if (name == null || name.isEmpty()) {
            name = "normal";
       }
       if (ingredients == null || ingredients.isEmpty()) {
           throw new RuntimeException("Попытка создания бургера без ингредиентов");
       }
       return new Burger(name, new ArrayList<>(ingredients), bun);
    }
}