package main;

import dish.builders.OrderBuilder;
import dish.dessert.Cake;
import dish.drink.FruitFresh;
import dish.first_dish.Bouillon;
import dish.first_dish.Soup;
import dish.second_dish.Macaroni;
import dish.snack.CheeseSticks;
import dish.type.FirstDish;
import dish.type.Snack;

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
    }
}
