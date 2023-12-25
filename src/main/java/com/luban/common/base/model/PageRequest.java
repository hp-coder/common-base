package com.luban.common.base.model;

/**
 * @author hp
 */
public interface PageRequest extends Request {

    Integer getPage();

    Integer getSize();

    static <T extends PageRequest> PageRequestWrapper<T> createWrapper(PageRequest request) {
        return (PageRequestWrapper<T>) new PageRequestWrapper<>(request.getPage(), request.getSize(), request);
    }
}
