package com.training.sgorodecki.homework.homework7;

public class IntegerValidator implements Validator<Integer> {

    @Override
    public void validate(Integer number) {
        if (!(number >= 1 && number <= 10)) {
            throw new ValidationFailedException("Validation is failed");
        }
    }
}
