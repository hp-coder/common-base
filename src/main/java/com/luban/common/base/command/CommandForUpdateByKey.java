

package com.hp.common.base.command;

/**
 * @author hp
 */
public interface CommandForUpdateByKey<KEY> extends com.hp.common.base.command.Command {

    KEY getKey();
}
