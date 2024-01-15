package com.luban.common.base.model;

import cn.hutool.http.HttpStatus;
import com.luban.common.base.enums.BaseEnum;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author hp
 */
public class Returns extends HashMap<String, Object> {
    protected static final String CODE_TAG = "code";
    protected static final String MSG_TAG = "message";
    protected static final String DATA_TAG = "data";
    protected static final String DEFAULT_SUCCESS_MSG = "操作成功";
    protected static final String DEFAULT_FAIL_MSG = "操作失败";

    public Returns() {
    }

    public Returns(BaseEnum<?, Integer> baseEnum) {
        super.put(CODE_TAG, baseEnum.getCode());
        super.put(MSG_TAG, baseEnum.getName());
    }

    public Returns code(int code) {
        return put(CODE_TAG, code);
    }

    public Returns data(Object data) {
        if (Objects.isNull(data)) {
            return this;
        }
        if (data instanceof Long || data.getClass().isAssignableFrom(Long.class)) {
            return put(DATA_TAG, String.valueOf(data));
        } else {
            return put(DATA_TAG, data);
        }
    }

    public Returns message(String message) {
        if (Objects.isNull(message)) {
            return this;
        }
        return put(MSG_TAG, message);
    }

    public boolean succeed() {
        return !failed();
    }

    public boolean failed() {
        return !Objects.equals(HttpStatus.HTTP_OK, this.get(CODE_TAG));
    }

    public static Returns of(BaseEnum<?, Integer> baseEnum) {
        return new Returns(baseEnum);
    }

    public static Returns success() {
        return new Returns()
                .code(HttpStatus.HTTP_OK)
                .message(DEFAULT_SUCCESS_MSG);
    }

    public static Returns fail() {
        return new Returns()
                .code(HttpStatus.HTTP_INTERNAL_ERROR)
                .message(DEFAULT_FAIL_MSG);
    }

    @Override
    public Returns put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
