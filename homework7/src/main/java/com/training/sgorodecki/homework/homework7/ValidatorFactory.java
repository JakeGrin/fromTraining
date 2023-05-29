package com.training.sgorodecki.homework.homework7;

import java.util.EnumMap;

public class ValidatorFactory {

    private final EnumMap<ValidationType, Validator> enumMap;

    public ValidatorFactory() {
        enumMap = new EnumMap<>(ValidationType.class);
        enumMap.put(ValidationType.STRING, getStringValidator());
        enumMap.put(ValidationType.INTEGER, getIntegerValidator());
    }

    private StringValidator getStringValidator() {
        return new StringValidator();
    }

    private IntegerValidator getIntegerValidator() {
        return new IntegerValidator();
    }

    public Validator getValidator(ValidationType validationType){
        return enumMap.get(validationType);
    }
}