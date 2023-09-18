package com.luban.common.base.context;

import com.luban.common.base.command.Command;

/**
 * @author hp
 */
public interface Context<ENTITY> {

    Command getCommand();

    ENTITY getEntity();

}
