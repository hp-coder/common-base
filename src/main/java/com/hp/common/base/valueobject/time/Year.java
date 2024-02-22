package com.hp.common.base.valueobject.time;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.google.common.base.Preconditions;
import com.hp.common.base.exception.IgnoreValidationException;
import com.hp.common.base.valueobject.AbstractStringBasedSingleValueObject;
import com.hp.common.base.valueobject.Patterns;
import lombok.EqualsAndHashCode;

/**
 * @author hp
 */
@EqualsAndHashCode(callSuper = false)
public final class Year extends AbstractStringBasedSingleValueObject {

    private Year(String value) throws IgnoreValidationException {
        super(value);
    }

    @JsonCreator
    public static Year of(String value){
        try {
            return new Year(value);
        }catch (IgnoreValidationException ignore){
            return null;
        }
    }

    @Override
    public void validate(String value) throws IgnoreValidationException {
        super.validate(value);
        Preconditions.checkArgument(Patterns.YEAR_PATTERN.asPredicate().test(value), "年份格式错误");
    }
}
