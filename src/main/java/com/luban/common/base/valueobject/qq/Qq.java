package com.hp.common.base.valueobject.qq;

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
public final class Qq extends AbstractStringBasedSingleValueObject {

    private Qq(String value) throws IgnoreValidationException {
        super(value);
    }

    @JsonCreator
    public static Qq of(String value){
        try {
            return new Qq(value);
        }catch (IgnoreValidationException ignore){
            return null;
        }
    }

    @Override
    public void validate(String value) throws IgnoreValidationException {
        super.validate(value);
        Preconditions.checkArgument(Patterns.QQ_PATTERN.asPredicate().test(value), "QQ号码格式错误");
    }
}
