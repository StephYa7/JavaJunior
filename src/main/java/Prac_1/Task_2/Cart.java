package Prac_1.Task_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

public class Cart<T extends Food> {
    private final ArrayList<T> foodstuffs;
    private final UMarket market;
    private final Class<T> clazz;

    public Cart(Class<T> clazz, UMarket market) {
        this.clazz = clazz;
        this.market = market;
        foodstuffs = new ArrayList<>();
    }

    public void cardBalancing() {
        Boolean[] items = new Boolean[3];
        items[0] = foodstuffs.stream().anyMatch(Food::getProteins);
        items[1] = foodstuffs.stream().anyMatch(Food::getFats);
        items[2] = foodstuffs.stream().anyMatch(Food::getCarbohydrates);

        Arrays.stream(items).allMatch(s -> s == true);

        if (Arrays.stream(items).allMatch(s -> s == true)) {
            System.out.println("Корзина уже сбалансирована по БЖУ.");
            return;
        }

        market.getThings(clazz).stream()
                .filter(thing -> !items[0] && thing.getProteins())
                .findFirst().ifPresent(thing -> {
                    items[0] = true;
                    foodstuffs.add(thing);
                });
        market.getThings(clazz).stream()
                .filter(thing -> !items[1] && thing.getFats())
                .findFirst().ifPresent(thing -> {
                    items[1] = true;
                    foodstuffs.add(thing);
                });
        market.getThings(clazz).stream()
                .filter(thing -> !items[2] && thing.getCarbohydrates())
                .findFirst().ifPresent(thing -> {
                    items[2] = true;
                    foodstuffs.add(thing);
                });

        if (Arrays.stream(items).allMatch(s -> s == true)) System.out.println("Корзина сбалансирована по БЖУ.");
        else System.out.println("Невозможно сбалансировать корзину по БЖУ.");
    }

    public Collection<T> getFoodstuffs() {
        return foodstuffs;
    }


    public void printFoodstuffs() {
        AtomicInteger index = new AtomicInteger(1);
        foodstuffs.forEach(food -> System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n", index.getAndIncrement(), food.getName(), food.getProteins() ? "Да" : "Нет", food.getFats() ? "Да" : "Нет", food.getCarbohydrates() ? "Да" : "Нет"));
    }
}