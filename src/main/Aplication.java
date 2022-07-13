package main;

import dish.builders.BurgerBuilder;
import dish.builders.OrderBuilder;
import dish.builders.PizzaBuilder;
import dish.dessert.Cake;
import dish.drink.FruitFresh;
import dish.first_dish.Bouillon;
import dish.first_dish.Soup;
import dish.ingredient.Ingredient;
import dish.ingredient.IngredientType;
import dish.second_dish.Burger;
import dish.second_dish.Macaroni;
import dish.second_dish.Pizza;
import dish.snack.CheeseSticks;
import dish.type.FirstDish;
import dish.type.Snack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Aplication {
    public static void main(String[] args) {
        Order order = new OrderBuilder()
                .addSnack(new CheeseSticks())
                .addDessert(new Cake())
                .build();

        Order order1 = new OrderBuilder()
                .addFirstDish(new Soup())
                .addSecondDish(new Macaroni())
                .addDrink(new FruitFresh())
                .build();

        OrderBuilder orderBuilder = new OrderBuilder();
        Snack snack = new CheeseSticks();
        orderBuilder.addSnack(snack);
        FirstDish firstDish = new Bouillon();
        orderBuilder.addFirstDish(firstDish);
        Order order2 = orderBuilder.build();

//        Pizza pizza = makePizza();
//        System.out.println(pizza);

        Burger burger = makeBurger();
        System.out.println(burger);
    }

    public static Pizza makePizza() {
        PizzaBuilder pizzaBuilder = new PizzaBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Здравствуйте!");
        System.out.println("Выберите основу для пиццы: 1 - тонкая, 2 - обычная, 3 - толстая, 4 - закрытая");
        String doughBase;
        try {
            String answer = reader.readLine();
            switch (answer) {
                case "1":
                    doughBase = "thin";
                    break;
                case "3":
                    doughBase = "lush";
                    break;
                case "4":
                    doughBase = "closed";
                    break;
                default:
                    doughBase = "normal";
                    break;
            }
            pizzaBuilder.setDoughBase(doughBase);
        } catch (IOException e) {
            System.out.println("При выборе основы для пиццы возникла ошибка");
        }
        try {
            System.out.println("Добавьте игредиент: \n"
                    + Arrays.stream(IngredientType.values()).map(ingredientType -> ingredientType.getId() + " - " + ingredientType.getRuName())
                    .collect(Collectors.joining(", ")));
            System.out.println("Введите \"хватит\" для завершения выбора иншредиентов.");
            String answer;
            while (!(answer = reader.readLine()).equals("хватит")) {
                Ingredient ingredient = new Ingredient(
                        IngredientType.getById(Integer.parseInt(answer)),
                        "our supplier",
                        LocalDateTime.now(),
                        LocalDateTime.MAX);
                pizzaBuilder.addIngredients(ingredient);
            }
        } catch (IOException e) {
            System.out.println("При выборе ингредиентов возникла ошибка");
        }

        return pizzaBuilder.build();
    }

    public static Burger makeBurger() {
        BurgerBuilder burgerBuilder = new BurgerBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Здравствуйте!");
        System.out.println("Выберите размер булки бургера: 1 - маленький, 2 - средний, 3 - большой");
        String bun;
        try {
            String answer = reader.readLine();
            switch (answer) {
                case "1":
                    bun = "small";
                    break;
                case "2":
                    bun = "big";
                    break;
                default:
                    bun = "normal";
                    break;
            }
            burgerBuilder.setBun(bun);
        } catch (IOException e) {
            System.out.println("При выборе размера булкивозникла ошибка");
        }
        try {
            System.out.println("Добавьте ингредиент: \n"
                    + Arrays.stream(IngredientType.values()).map(ingredientType -> ingredientType.getId() + " - " + ingredientType.getRuName())
                    .collect(Collectors.joining(", ")));
            System.out.println("Введите \"хватит\" для завершения выбора иншредиентов.");
            String answer;
            while (!(answer = reader.readLine()).equals("хватит")) {
                Ingredient ingredient = new Ingredient(
                        IngredientType.getById(Integer.parseInt(answer)),
                        "our supplier",
                        LocalDateTime.now(),
                        LocalDateTime.MAX);
                burgerBuilder.addIngredients(ingredient);
            }
        } catch (IOException e) {
            System.out.println("При выборе ингредиентов возникла ошибка");
        }
        return burgerBuilder.build();
    }
}
