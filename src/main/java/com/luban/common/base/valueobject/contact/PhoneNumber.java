package com.hp.common.base.valueobject.contact;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.google.common.base.Preconditions;
import com.hp.common.base.exception.IgnoreValidationException;
import com.hp.common.base.valueobject.AbstractStringBasedSingleValueObject;
import com.hp.common.base.valueobject.Patterns;
import lombok.EqualsAndHashCode;

import java.util.Optional;

/**
 * @author hp
 */
@EqualsAndHashCode(callSuper = true)
public final class PhoneNumber extends AbstractStringBasedSingleValueObject {

    private PhoneNumber(String phoneNumber) throws IgnoreValidationException {
        super(phoneNumber);
    }

    @JsonCreator
    public static PhoneNumber of(String value) {
        try {
            return new PhoneNumber(value);
        } catch (IgnoreValidationException ignore) {
            return null;
        }
    }

    @JsonCreator
    public static PhoneNumber of(Long value) {
        return Optional.ofNullable(value)
                .map(String::valueOf)
                .map(PhoneNumber::of)
                .orElse(null);
    }

    @Override
    public void validate(String value) throws IgnoreValidationException {
        super.validate(value);
        Preconditions.checkArgument(Patterns.PHONE_PATTERN.asPredicate().test(value), "手机号码格式错误");
    }
}
