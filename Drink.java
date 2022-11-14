public abstract class Drink implements Food {

    protected float price;
    protected int calories;
    protected boolean aCan = false;

    public Drink(float price, int calories, boolean aCan) {
        this.price = price;
        this.calories = calories;
        this.aCan = aCan;
    }

    public boolean isACan() {
        return aCan;
    }
    @Override
    public float getPrice() {
        return price;
    }

    @Override
    public int getCalories() {
        return calories;
    }
}
