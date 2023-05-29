package com.training.sgorodecki.homework.homework7;

import org.junit.Test;

public class ValidatorSystemTest {

    @Test
    public void testValidateInt() throws ValidationFailedException {
        ValidationSystem.validate(1);
        ValidationSystem.validate(5);
        ValidationSystem.validate(10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateD() throws IllegalArgumentException {
        ValidationSystem.validate(1.0);
        ValidationSystem.validate(5.0);
        ValidationSystem.validate(10.0);
    }

    @Test(expected = ValidationFailedException.class)
    public void testValidateIntFails() throws ValidationFailedException {
        ValidationSystem.validate(11);
    }

    @Test(expected = ValidationFailedException.class)
    public void testValidateIntFails2() throws ValidationFailedException {
        ValidationSystem.validate(0);
    }

    @Test
    public void testValidateString() throws ValidationFailedException {
        ValidationSystem.validate("Hello");
        ValidationSystem.validate("Hello world, abc");
    }

    @Test(expected = ValidationFailedException.class)
    public void testValidateStringFails() throws ValidationFailedException {
        ValidationSystem.validate("hello");
    }

    @Test(expected = ValidationFailedException.class)
    public void testValidateStringFails2() throws ValidationFailedException {
        ValidationSystem.validate("");
    }
}