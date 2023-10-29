package edu.hw3;

import edu.hw3.task6.Stock;
import edu.hw3.task6.StockMarket;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task6Test {

    @Test
    void stockMarketTest() {

        Stock stock1 = new Stock(1);
        Stock stock2 = new Stock(2);
        Stock stock3 = new Stock(3);

        StockMarket stockMarket = new StockMarket();

        stockMarket.add(stock1);
        assertEquals(stock1, stockMarket.mostValuableStock());

        stockMarket.add(stock2);
        assertEquals(stock2, stockMarket.mostValuableStock());

        stockMarket.add(stock1);
        assertEquals(stock2, stockMarket.mostValuableStock());

        stockMarket.add(stock3);
        assertEquals(stock3, stockMarket.mostValuableStock());

        stockMarket.remove(stock3);
        assertEquals(stock2, stockMarket.mostValuableStock());

        stockMarket.add(stock1);
        assertEquals(stock2, stockMarket.mostValuableStock());

    }
}
