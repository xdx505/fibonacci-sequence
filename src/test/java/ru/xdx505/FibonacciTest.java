package ru.xdx505;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FibonacciTest {

    private final int seqSize = 10;
    private final IterableFibonacci<Number> iterableFibonacci = new IterableFibonacci<>(seqSize);
    private final List<BigInteger> valueList = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        for (int i = 0; i < seqSize; i++) {
            valueList.add((BigInteger) iterableFibonacci.iterator().next());
        }
    }

    @Test
    public void testArrayEquals_should_return_true() {
        final List<BigInteger> mockedValueList = Stream.of(
                new BigInteger("0"), new BigInteger("1"), new BigInteger("1"), new BigInteger("2"), new BigInteger("3"),
                new BigInteger("5"), new BigInteger("8"), new BigInteger("13"), new BigInteger("21"), new BigInteger("34")
        ).sorted().collect(Collectors.toList());

        Assert.assertEquals(mockedValueList, valueList);
    }

    @Test
    public void testArraySize_should_return_true() {
        Assert.assertEquals(valueList.size(), seqSize);
    }

    @Test
    public void testArrayMaxValue_should_return_false() {
        Assert.assertFalse(iterableFibonacci.iterator().hasNext());
    }

    @Test
    public void testEmptyArray_should_return_false() {
        Assert.assertFalse(new IterableFibonacci<>(0).iterator().hasNext());
    }

    @Test
    public void testNotCorrectValueArray_should_return_false() {
        try {
            new IterableFibonacci<>(-1);
        } catch (UnsupportedOperationException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void testPreLastElement_should_be_equal() {
        iterableFibonacci.iterator().remove();
        Assert.assertEquals(iterableFibonacci.iterator().next(), new BigInteger("34"));
    }
}
