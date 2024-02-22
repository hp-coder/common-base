package com.hp.common.base.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

/**
 * @author hp
 */
@Getter
@AllArgsConstructor
public enum ValidStatus implements com.hp.common.base.enums.BaseEnum<ValidStatus, Integer> {

    /***/
    VALID(1, "valid"),
    INVALID(0, "invalid");

    private final Integer code;
    private final String name;

    public static Optional<ValidStatus> of(Integer code) {
        return Optional.ofNullable(com.hp.common.base.enums.BaseEnum.parseByCode(ValidStatus.class, code));
    }

    public boolean invalid() {
        return !valid();
    }

    public boolean valid() {
        return ValidStatus.VALID.equals(this);
    }
}
