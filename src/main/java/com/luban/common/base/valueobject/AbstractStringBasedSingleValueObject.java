package com.luban.common.base.valueobject;

import cn.hutool.core.util.StrUtil;
import com.luban.common.base.exception.NullValueObjectException;
import lombok.EqualsAndHashCode;

/**
 * @author hp
 */
@EqualsAndHashCode(callSuper = true)
public abstract class AbstractStringBasedSingleValueObject extends AbstractSingleValueObject<String> {
    protected AbstractStringBasedSingleValueObject(String value) throws NullValueObjectException {
        super(value);
        if (StrUtil.isEmpty(value)) {
            throw new NullValueObjectException();
        }
    }
}
