package com.hp.common.base.valueobject;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import com.hp.common.base.exception.IgnoreValidationException;
import lombok.EqualsAndHashCode;

/**
 * @author hp
 */
@EqualsAndHashCode(callSuper = true)
public abstract class AbstractStringBasedSingleValueObject extends com.hp.common.base.valueobject.AbstractSingleValueObject<String> {
    protected AbstractStringBasedSingleValueObject(String value) throws IgnoreValidationException {
        super(value);
    }

    @Override
    public void validate(String value) throws IgnoreValidationException {
        Assert.isTrue(StrUtil.isNotEmpty(value), IgnoreValidationException::new);
    }

    @Override
    public String toString() {
        return this.value;
    }

    @Override
    public boolean isNull() {
        return StrUtil.isEmpty(this.value);
    }
}
