package com.hp.common.base.valueobject.contact;

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
public final class EmailAddress extends AbstractStringBasedSingleValueObject {

    private EmailAddress(String value) throws IgnoreValidationException {
        super(value);
    }

    @JsonCreator
    public static EmailAddress of(String value) {
        try {
            return new EmailAddress(value);
        } catch (IgnoreValidationException ignore) {
            return null;
        }
    }

    @Override
    public void validate(String value) throws IgnoreValidationException {
        super.validate(value);
        Preconditions.checkArgument(Patterns.EMAIL_PATTERN.asPredicate().test(value), "电子邮箱格式错误");
    }
}
