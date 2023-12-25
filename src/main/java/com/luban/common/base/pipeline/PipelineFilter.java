package com.luban.common.base.pipeline;

/**
 * @author hp
 */
public interface PipelineFilter<CONTEXT extends PipelineContext> {

    void doFilter(CONTEXT context, PipelineFilterChain<CONTEXT> filterChain);
}
