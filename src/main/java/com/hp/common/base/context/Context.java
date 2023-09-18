package com.hp.common.base.context;

import com.hp.common.base.command.Command;

/**
 * @author hp
 */
public interface Context<ENTITY> {

    Command getCommand();

    ENTITY getEntity();

}
