package com.luban.common.base.context;

import com.luban.common.base.command.Command;
import lombok.Data;

/**
 * @author hp
 */
@Data
public abstract class AbstractContext<ENTITY> implements Context<ENTITY> {

    protected Command<ENTITY> command;

    protected ENTITY entity;

}
