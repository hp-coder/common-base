package com.luban.common.base.valueobject.contact;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.google.common.base.Preconditions;
import com.luban.common.base.exception.NullValueObjectException;
import com.luban.common.base.valueobject.AbstractStringBasedSingleValueObject;
import com.luban.common.base.valueobject.Patterns;
import lombok.EqualsAndHashCode;

/**
 * @author hp
 */
@EqualsAndHashCode(callSuper = true)
public final class TelNumber extends AbstractStringBasedSingleValueObject {

    private TelNumber(String value) throws NullValueObjectException {
        super(value);
    }

    @JsonCreator
    public static TelNumber of(String value) {
        try {
            return new TelNumber(value);
        } catch (NullValueObjectException ignore) {
            return null;
        }
    }

    @Override
    public void validate(String value) throws IllegalArgumentException {
        Preconditions.checkArgument(Patterns.TEL_PATTERN.asPredicate().test(value), "电话号码格式错误");
    }
}
