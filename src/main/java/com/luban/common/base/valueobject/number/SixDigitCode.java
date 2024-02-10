package com.luban.common.base.valueobject.number;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.google.common.base.Preconditions;
import com.luban.common.base.exception.IgnoreValidationException;
import com.luban.common.base.valueobject.AbstractStringBasedSingleValueObject;
import com.luban.common.base.valueobject.Patterns;
import lombok.EqualsAndHashCode;

/**
 * @author hp
 */
@EqualsAndHashCode(callSuper = false)
public final class SixDigitCode extends AbstractStringBasedSingleValueObject {

    private SixDigitCode(String value) throws IgnoreValidationException {
        super(value);
    }

    @JsonCreator
    public static SixDigitCode of(String value){
        try {
            return new SixDigitCode(value);
        }catch (IgnoreValidationException ignore){
            return null;
        }
    }

    @Override
    public void validate(String value) throws IgnoreValidationException {
        super.validate(value);
        Preconditions.checkArgument(Patterns.SIX_DIGIT_CODE_PATTERN.asPredicate().test(value), "验证码格式错误");
    }
}
