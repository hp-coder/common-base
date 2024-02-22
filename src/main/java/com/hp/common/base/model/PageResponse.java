package com.hp.common.base.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author hp
 */
@Getter
@Setter
public class PageResponse<T> implements com.hp.common.base.model.Response {

    private Long total;
    private Integer pageSize;
    private Integer pageNumber;
    private List<T> list;

    protected PageResponse() {
    }

    protected PageResponse(List<T> list, Long total, Integer pageNumber, Integer pageSize) {
        this.list = list;
        this.total = total;
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
    }

    public static <T> PageResponse<T> of(List<T> list, Long total, com.hp.common.base.model.PageRequestWrapper<?> wrapper) {
        return new PageResponse<>(list, total, wrapper.getPage(), wrapper.getPageSize());
    }

    public static <T> PageResponse<T> of(List<T> list, Long total, Integer pageNumber, Integer pageSize) {
        return new PageResponse<>(list, total, pageNumber, pageSize);
    }
}
