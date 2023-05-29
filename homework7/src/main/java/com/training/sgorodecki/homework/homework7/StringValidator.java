package com.training.sgorodecki.homework.homework7;

public class StringValidator implements Validator<String> {

    private static final String VALIDATION_RULE_INPUT = "^+[A-Z].*";

    @Override
    public void validate(String string) {
        if (!string.matches(VALIDATION_RULE_INPUT)) {
            throw new ValidationFailedException("Validation is failed");
        }
    }
}