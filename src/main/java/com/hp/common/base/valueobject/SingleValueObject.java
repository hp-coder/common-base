package com.hp.common.base.valueobject;


import com.hp.common.base.exception.IgnoreValidationException;

/**
 * @author hp
 */
public interface SingleValueObject<TYPE> extends com.hp.common.base.valueobject.ValueObject {
    TYPE value();

    void validate(TYPE value) throws IllegalArgumentException, IgnoreValidationException;
}
