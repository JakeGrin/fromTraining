package com.training.sgorodecki.homework.homework7;

public class ValidationSystem {

    public static void validate(Object object) {
        ValidatorFactory validatorFactory = new ValidatorFactory();
        validatorFactory.getValidator(getValidationType(object)).validate(object);
    }

    private static ValidationType getValidationType(Object object) {
        return ValidationType.valueOf(object.getClass().getSimpleName().toUpperCase());
    }
}
