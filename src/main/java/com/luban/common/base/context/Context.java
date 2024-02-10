package com.hp.common.base.context;

/**
 * @author hp
 */
public interface Context<AGG_ROOT, COMMAND> {

    COMMAND getCommand();

    AGG_ROOT getEntity();

}
