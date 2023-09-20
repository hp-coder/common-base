package com.luban.common.base.context;

import lombok.Data;

/**
 * @author hp
 */
@Data
public abstract class AbstractContext<AGG_ROOT, COMMAND> implements Context<AGG_ROOT, COMMAND> {

    protected COMMAND command;

    protected AGG_ROOT entity;

}
