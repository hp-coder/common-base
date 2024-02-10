package com.hp.common.base.valueobject.id;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.google.common.base.Preconditions;
import com.hp.common.base.exception.IgnoreValidationException;
import com.hp.common.base.valueobject.AbstractStringBasedSingleValueObject;
import com.hp.common.base.valueobject.Patterns;
import lombok.EqualsAndHashCode;

/**
 * @author hp
 */
@EqualsAndHashCode(callSuper = true)
public final class IdNumber extends AbstractStringBasedSingleValueObject {

    private IdNumber(String value) throws IgnoreValidationException {
        super(value);
    }

    @JsonCreator
    public static IdNumber of(String value){
        try {
            return new IdNumber(value);
        }catch (IgnoreValidationException ignore){
            return null;
        }
    }

    @Override
    public void validate(String value) throws IgnoreValidationException {
        super.validate(value);
        Preconditions.checkArgument(Patterns.ID_NUMBER_PATTER.asPredicate().test(value),"身份证格式错误");
    }
}
