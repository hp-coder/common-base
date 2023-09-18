package com.luban.common.base.context;

import com.luban.common.base.command.Command;

/**
 * @author hp
 */
public interface Context<ENTITY> {

    Command<ENTITY> getCommand();

    ENTITY getEntity();

}
