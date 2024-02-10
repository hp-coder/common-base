package com.luban.common.base.valueobject.areacode;

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
public class AreaCode extends AbstractStringBasedSingleValueObject {

    protected AreaCode(String areaCode) throws IgnoreValidationException {
        super(areaCode);
    }

    @JsonCreator
    public static AreaCode of(String value) {
        try {
            return new AreaCode(value);
        } catch (IgnoreValidationException ignore) {
            return null;
        }
    }

    @Override
    public void validate(String value) throws IgnoreValidationException {
        super.validate(value);
        Preconditions.checkArgument(Patterns.AREA_CODE_PATTERN.asPredicate().test(value), "地区编码格式错误");
    }

}
