package com.luban.common.base.context;

/**
 * @author hp
 */
public interface Context<AGG_ROOT, COMMAND> {

    COMMAND getCommand();

    AGG_ROOT getEntity();

}
