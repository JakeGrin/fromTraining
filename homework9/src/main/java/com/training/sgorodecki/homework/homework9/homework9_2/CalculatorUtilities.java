package com.training.sgorodecki.homework.homework9.homework9_2;

import java.util.HashSet;
import java.util.Set;

public final class CalculatorUtilities {

    private CalculatorUtilities() {
        throw new AssertionError();
    }

    public static Set<Integer> union(Set<Integer> ab, Set<Integer> bc) {
        ab.addAll(bc);
        return ab;
    }

    public static Set<Integer> intersection(Set<Integer> ab, Set<Integer> bc) {
        ab.retainAll(bc);
        return ab;
    }

    public static Set<Integer> minus(Set<Integer> ab, Set<Integer> bc) {
        ab.removeAll(bc);
        return ab;
    }

    public static Set<Integer> difference(Set<Integer> ab, Set<Integer> bc) {
        Set<Integer> abc = new HashSet<>(ab);
        abc.addAll(bc);

        Set<Integer> b = new HashSet<>(ab);
        b.retainAll(bc);

        abc.removeAll(b);
        return abc;
    }

}
