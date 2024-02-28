package com.hp.common.base.valueobject.time;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.google.common.base.Preconditions;
import com.hp.common.base.exception.NullValueObjectException;
import com.hp.common.base.valueobject.AbstractStringBasedSingleValueObject;
import com.hp.common.base.valueobject.Patterns;
import lombok.EqualsAndHashCode;

/**
 * @author hp
 */
@EqualsAndHashCode(callSuper = false)
public final class Year extends AbstractStringBasedSingleValueObject {

    private Year(String value) throws NullValueObjectException {
        super(value);
    }

    @JsonCreator
    public static Year of(String value){
        try {
            return new Year(value);
        }catch (NullValueObjectException ignore){
            return null;
        }
    }

    @Override
    public void validate(String value) throws IllegalArgumentException {
        Preconditions.checkArgument(Patterns.YEAR_PATTERN.asPredicate().test(value), "年份格式错误");
    }
}
