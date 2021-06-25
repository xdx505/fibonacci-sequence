package ru.xdx505;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

public class FibonacciIterator implements Iterator<BigInteger> {

    private final AtomicReference<Pair> pair = new AtomicReference<>(new Pair(BigInteger.ZERO, BigInteger.ONE));

    public BigInteger next() {
        while (true) {
            final Pair current = pair.get();
            if (pair.compareAndSet(current, new Pair(current)))
            return current.first;
        }
    }

    private class Pair {
        private final BigInteger first;
        private final BigInteger second;

        public Pair(BigInteger first, BigInteger second) {
            this.first = first;
            this.second = second;
        }

        public Pair(Pair oldPair) {
            this.first = oldPair.second;
            this.second = oldPair.first.add(oldPair.second);
        }
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public void remove() {
        next();
    }
}
