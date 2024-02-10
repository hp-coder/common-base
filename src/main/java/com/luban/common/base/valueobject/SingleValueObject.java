package com.luban.common.base.valueobject;


import com.luban.common.base.exception.IgnoreValidationException;

/**
 * @author hp
 */
public interface SingleValueObject<TYPE> extends ValueObject {
    TYPE value();

    void validate(TYPE value) throws IllegalArgumentException, IgnoreValidationException;
}
