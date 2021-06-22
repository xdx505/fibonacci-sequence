package ru.xdx505;

import java.math.BigInteger;
import java.util.Iterator;

public class IterableFibonacci<V extends Number> implements Iterable<V> {

    private final BigInteger maxValue;

    private BigInteger first = BigInteger.ZERO;
    private BigInteger second = BigInteger.ONE;
    private BigInteger count = BigInteger.ZERO;

    private Iterator<V> fibonacciIterator;

    public IterableFibonacci(long maxValue) {
        if (maxValue <= 0) throw new UnsupportedOperationException();
        this.maxValue = BigInteger.valueOf(maxValue);
    }

    public Iterator<V> iterator() {
        if (fibonacciIterator == null) {
            fibonacciIterator = new FibonacciIterator();
        }
        return fibonacciIterator;
    }

    private class FibonacciIterator implements Iterator<V> {

        public synchronized boolean hasNext() {
            return (maxValue.compareTo(count) > 0);
        }

        public synchronized V next() {
            if (hasNext()) {
                final BigInteger current = first;
                first = second;
                second = first.add(current);
                count = count.add(BigInteger.ONE);
                return (V) current;
            } else throw new UnsupportedOperationException();
        }

        public synchronized void remove() {
            if (count.compareTo(BigInteger.ZERO) > 0) {
                final BigInteger current = second;
                second = first;
                first = current.subtract(second);
                count = count.subtract(BigInteger.ONE);
            } else throw new UnsupportedOperationException();
        }
    }
}
