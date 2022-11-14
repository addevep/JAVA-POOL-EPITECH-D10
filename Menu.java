public abstract class Menu<T1 extends Food, T2 extends Food> implements Food {
    T1 drink;
    T2 meal;

    public Menu(T1 drink, T2 meal) {
        this.drink = drink;
        this.meal = meal;
    }

    public T1 getDrink() {
        return drink;
    }

    public T2 getMeal() {
        return meal;
    }

    @Override
    public float getPrice() {
        return (float) ((drink.getPrice() + meal.getPrice()) * 0.9);
    }

    @Override
    public int getCalories() {
        return 0;
    }
}
