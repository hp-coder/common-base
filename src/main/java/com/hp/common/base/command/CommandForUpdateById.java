package com.hp.common.base.command;

/**
 * @author hp
 */
public interface CommandForUpdateById<ID> extends com.hp.common.base.command.CommandForUpdate {

    ID getId();
}
