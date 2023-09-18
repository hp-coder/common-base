package com.hp.common.base.context;

import com.hp.common.base.command.Command;
import lombok.Data;

/**
 * @author hp
 */
@Data
public abstract class AbstractContext<ENTITY> implements Context<ENTITY> {

    protected Command command;

    protected ENTITY entity;

}
