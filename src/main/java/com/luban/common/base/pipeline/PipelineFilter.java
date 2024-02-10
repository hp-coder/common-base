package com.hp.common.base.pipeline;

/**
 * @author hp
 */
public interface PipelineFilter<CONTEXT extends com.hp.common.base.pipeline.PipelineContext> {

    void doFilter(CONTEXT context, com.hp.common.base.pipeline.PipelineFilterChain<CONTEXT> filterChain);
}
