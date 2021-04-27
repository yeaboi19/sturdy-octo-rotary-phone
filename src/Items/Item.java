package Items;

import java.io.Serializable;
import java.util.Objects;

public class Item implements Serializable {
    private String name;
    private double price;

    long serialVersionUID=12121213;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name+"--> price - "+price+"$";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (Double.compare(item.price, price) != 0) return false;
        return Objects.equals(name, item.name);
    }
}
