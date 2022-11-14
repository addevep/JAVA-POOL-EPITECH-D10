import java.util.ArrayList;
import java.util.List;

public class CustomerOrder {

    Stock stock;
    List<Food> orderList = new ArrayList<>();

    CustomerOrder(Stock stock) {
    this.stock = stock;
    }
    public boolean addItem(Food food) throws NoSuchFoodException {
        if (stock.getNumberOf(food.getClass()) > 0) {
            orderList.add(food);
            stock.remove(food.getClass());
            return true;
        }
        return false;
    }

    public boolean removeItem(Food food) throws NoSuchFoodException {
        if (orderList.contains(food)) {
            orderList.remove(food);
            stock.add(food.getClass());
            return true;
        }
        return false;
    }

    public float getPrice() {
        float price = 0;
        for (Food s: orderList) {
            price += s.getPrice();
        }
        return price;
    }

    public <T1 extends Food, T2 extends Food> boolean addMenu(Menu<T1, T2> menu) throws NoSuchFoodException {
        if (stock.remove(menu.getDrink().getClass()) && stock.remove(menu.getMeal().getClass())) {
            orderList.add(menu);
            return true;
        }
        return false;
    }

    public <T1 extends Food, T2 extends Food> boolean removeMenu(Menu<T1, T2> menu) throws NoSuchFoodException {
        if (stock.add(menu.getDrink().getClass()) && stock.add(menu.getMeal().getClass())) {
            orderList.remove(menu);
            return true;
        }
        return false;
    }

    public void printOrder() {
        System.out.println("Your order is composed of:");
        for (Food key: orderList) {
            if (key instanceof Menu<?,?>) {
                System.out.println("- " + key.getClass().getName() + " menu " + "(" + key.getPrice() + " euros)");
                System.out.println("-> drink: " + ((Menu<?, ?>) key).drink.getClass().getName());
                System.out.println("-> meal: " + ((Menu<?, ?>) key).meal.getClass().getName());
            }
        }
        for (Food key: orderList) {
            if (!(key instanceof Menu<?,?>)) {
                System.out.println("- " + key.getClass().getName() + " (" + key.getPrice() + " euros)");
            }
        }
        System.out.println("For a total of " + getPrice() + " euros.");
    }

}
