package ru.xdx505;


import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class FibonacciIteratorTest {

    private FibonacciIterator fibonacciIterator;

    @Test
    public void testNextAndHasNext() {
        int size = 1000;

        fibonacciIterator = new FibonacciIterator();
        BigInteger[] fibonacci = setFibonacciSequence(size);

        int count = 0;
        while (fibonacciIterator.hasNext()) {
            if (count == size) return;
            Assert.assertEquals(fibonacci[count], fibonacciIterator.next());
            count++;
        }
    }

    @Test
    public void testRemoveMethod() {
        fibonacciIterator = new FibonacciIterator();
        for (int i = 0; i < 5; i++) {
            fibonacciIterator.next();
        }
        fibonacciIterator.remove();
        Assert.assertEquals(new BigInteger("8"), fibonacciIterator.next());
    }

    private BigInteger[] setFibonacciSequence(int n) {
        final BigInteger[] args = new BigInteger[n + 1];
        args[0] = BigInteger.ZERO;
        args[1] = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            args[i] = args[i - 1].add(args[i - 2]);
        }
        return args;
    }
}