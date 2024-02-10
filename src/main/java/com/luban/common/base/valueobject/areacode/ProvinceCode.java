package com.hp.common.base.valueobject.areacode;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.google.common.base.Preconditions;
import com.hp.common.base.exception.IgnoreValidationException;
import com.hp.common.base.valueobject.Patterns;
import lombok.EqualsAndHashCode;

/**
 * @author hp
 */
@EqualsAndHashCode(callSuper = true)
public final class ProvinceCode extends com.hp.common.base.valueobject.areacode.AreaCode {
    private ProvinceCode(String areaCode) throws IgnoreValidationException {
        super(areaCode);
    }

    @JsonCreator
    public static ProvinceCode of(String value) {
        try {
            return new ProvinceCode(value);
        } catch (IgnoreValidationException e) {
            return null;
        }
    }

    @Override
    public void validate(String value) throws IgnoreValidationException {
        super.validate(value);
        Preconditions.checkArgument(Patterns.PROVINCE_CODE_PATTER.asPredicate().test(value), "省级地区编码格式错误");
    }
}
