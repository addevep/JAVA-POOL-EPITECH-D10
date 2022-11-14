import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Stock {
    public Map<Class<? extends Food>, Integer> numberOf = new HashMap<>();
    List<Class<? extends Food>> products = Arrays.asList(
            AppleSmoothie.class, Coke.class,
            HamSandwich.class, Panini.class,
            FrenchBaguette.class, SoftBread.class,
            Cookie.class, CheeseCake.class
    );

    public Stock() {
        products.forEach((s) -> {
            numberOf.put(s, 100);
        });
    }

    public int getNumberOf(Class<? extends Food> food) {
        return numberOf.get(food);
    }

    public boolean add(Class<? extends Food> food) throws NoSuchFoodException {
        if (numberOf.containsKey(food)) {
            int temp = numberOf.get(food);
            temp++;
            numberOf.replace(food, temp);
            return true;
        }
        throw new NoSuchFoodException("No such food type: " + food + ".");
    }

    public boolean remove(Class<? extends Food> food) throws NoSuchFoodException {
        if (numberOf.containsKey(food)) {
            int temp = numberOf.get(food);
            if (temp > 0) {
                temp--;
                numberOf.replace(food, temp);
                return true;
            }
            return false;
        }
        throw new NoSuchFoodException("No such food type: " + food + ".");
    }
}
