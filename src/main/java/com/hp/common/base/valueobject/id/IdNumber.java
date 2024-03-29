package com.hp.common.base.valueobject.id;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.google.common.base.Preconditions;
import com.hp.common.base.exception.NullValueObjectException;
import com.hp.common.base.valueobject.AbstractStringBasedSingleValueObject;
import com.hp.common.base.valueobject.Patterns;

/**
 * @author hp
 */
public final class IdNumber extends AbstractStringBasedSingleValueObject {

    private IdNumber(String value) throws NullValueObjectException {
        super(value);
    }

    @JsonCreator
    public static IdNumber of(String value){
        try {
            return new IdNumber(value);
        }catch (NullValueObjectException ignore){
            return null;
        }
    }

    @Override
    public void validate(String value) throws IllegalArgumentException {
        Preconditions.checkArgument(Patterns.ID_NUMBER_PATTER.asPredicate().test(value),"身份证格式错误");
    }
}
