package com.luban.common.base.command;

/**
 * @author hp
 */
public interface CommandForUpdateById<ID, ENTITY> extends CommandForUpdate<ENTITY> {

    ID getId();
}
