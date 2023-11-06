package edu.hw3;

import edu.hw3.Task6.Market;
import edu.hw3.Task6.Stock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SuppressWarnings("checkstyle:MagicNumber")
public class Task6Test {

    Market market;

    @BeforeEach
    void initializeObjects() {
        market = new Market();
    }

    @Test
    void mostValuableStockTest() {
        Stock stock1 = new Stock("Stock1", 50d);
        Stock stock2 = new Stock("Stock2", 100d);
        Stock stock3 = new Stock("Stock3", 100.5);

        market.add(stock1);
        market.add(stock2);
        market.add(stock3);

        Stock mostValuableStock = market.mostValuableStock();

        assertThat(mostValuableStock).isEqualTo(stock3);
    }

    @Test
    void removeStickTest() {
        Stock stock1 = new Stock("stock1", 50d);
        Stock stock2 = new Stock("stock2", 100d);
        Stock stock3 = new Stock("stock3", 50.5);

        market.add(stock1);
        market.add(stock2);
        market.add(stock3);

        market.remove(stock3);

        Stock mostValuableStock = market.mostValuableStock();

        assertThat(mostValuableStock).isEqualTo(stock2);
    }
}
