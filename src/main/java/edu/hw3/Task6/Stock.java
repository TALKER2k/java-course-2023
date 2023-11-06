package edu.hw3.Task6;

import java.util.Objects;
import org.jetbrains.annotations.NotNull;

public record Stock(String name, Double price) implements Comparable<Stock> {
    @Override
    public int compareTo(@NotNull Stock o) {
        return Double.compare(o.price, this.price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Stock stock = (Stock) o;
        return Objects.equals(name, stock.name) && Objects.equals(price, stock.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
