package com.luban.common.base.valueobject;


/**
 * @author hp
 */
public interface SingleValueObject<TYPE> extends ValueObject {
    TYPE value();
}
