public class AfternoonTea<T1 extends Drink, T2 extends Dessert> extends Menu<T1,T2>{
    public AfternoonTea(T1 drink, T2 dessert) {
        super(drink, dessert);
    }
}
