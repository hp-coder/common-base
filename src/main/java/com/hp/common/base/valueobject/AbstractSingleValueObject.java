package com.hp.common.base.valueobject;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.Preconditions;
import com.hp.common.base.exception.IgnoreValidationException;

import java.util.Objects;

/**
 * 配合jackson方便一些
 * <p>
 * 最好不要提供getter, 但是为了日志妥协一下
 *
 * @author hp
 * @see JsonAutoDetect;
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.PROTECTED_AND_PUBLIC)
public abstract class AbstractSingleValueObject<TYPE> implements com.hp.common.base.valueobject.SingleValueObject<TYPE> {

    protected final TYPE value;

    @Override
    public TYPE value() {
        return value;
    }

    protected AbstractSingleValueObject(TYPE value) throws IgnoreValidationException {
        if (Objects.isNull(value)) {
            this.value = null;
        } else {
            this.validate(value);
            this.value = value;
        }
    }

    @Override
    public void validate(TYPE value) throws IllegalArgumentException, IgnoreValidationException {
        Preconditions.checkArgument(Objects.nonNull(value), "不接受Null值");
    }

    @JsonIgnore
    public boolean isNull() {
        return Objects.isNull(this.value);
    }

    @JsonIgnore
    public boolean notNull() {
        return !isNull();
    }

    @Override
    public String toString() {
        return this.value.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AbstractSingleValueObject<?> that = (AbstractSingleValueObject<?>) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
