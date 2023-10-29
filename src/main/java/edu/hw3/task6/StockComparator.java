package edu.hw3.task6;

import java.util.Comparator;

public class StockComparator implements Comparator<Stock> {

    @Override
    public int compare(Stock s1, Stock s2) {
        return -Integer.compare(s1.value, s2.value);
    }
}
