package com.training.sgorodecki.homework.homework9.homework9_2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class CalculatorUtilitiesTest {
    Set<Integer> s1;
    Set<Integer> s2;

    @Before
    public void setUp() {
        s1 = new HashSet<>();
        s1.add(1);
        s1.add(2);

        s2 = new HashSet<>();
        s2.add(2);
        s2.add(3);
    }

    @Test
    public void testUnion() {
        Set<Integer> expected = new HashSet<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        Assert.assertEquals(expected, CalculatorUtilities.union(s1, s2));
    }

    @Test
    public void testIntersection() {
        Set<Integer> expected = new HashSet<>();
        expected.add(2);
        Assert.assertEquals(expected, CalculatorUtilities.intersection(s1, s2));
    }

    @Test
    public void testMinus() {
        Set<Integer> expected = new HashSet<>();
        expected.add(1);
        Assert.assertEquals(expected, CalculatorUtilities.minus(s1, s2));
    }

    @Test
    public void testDifference() {
        Set<Integer> expected = new HashSet<>();
        expected.add(1);
        expected.add(3);
        Assert.assertEquals(expected, CalculatorUtilities.difference(s1, s2));
    }
}

