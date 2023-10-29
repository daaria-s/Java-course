package edu.hw3.task6;

import java.util.PriorityQueue;

public class StockMarket {

    public StockMarket() {
    }

    PriorityQueue<Stock> stockQueue = new PriorityQueue<>(new StockComparator());

    public void add(Stock stock) {
        stockQueue.add(stock);
    }

    public void remove(Stock stock) {
        stockQueue.remove(stock);
    }

    public Stock mostValuableStock() {
        return stockQueue.peek();
    }

}
