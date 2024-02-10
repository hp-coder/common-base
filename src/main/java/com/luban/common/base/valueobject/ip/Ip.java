package com.luban.common.base.valueobject.ip;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.google.common.base.Preconditions;
import com.luban.common.base.exception.IgnoreValidationException;
import com.luban.common.base.valueobject.AbstractStringBasedSingleValueObject;
import com.luban.common.base.valueobject.Patterns;
import lombok.EqualsAndHashCode;

/**
 * @author hp
 */
@EqualsAndHashCode(callSuper = true)
public final class Ip extends AbstractStringBasedSingleValueObject {

    private Ip(String value) throws IgnoreValidationException {
        super(value);
    }

    @JsonCreator
    public static Ip of(String value) {
        try {
            return new Ip(value);
        } catch (IgnoreValidationException ignore) {
            return null;
        }
    }

    @Override
    public void validate(String value) throws IgnoreValidationException {
        super.validate(value);
        Preconditions.checkArgument(Patterns.IP_PATTERN.asPredicate().test(value), "ip地址格式错误");
    }

}
