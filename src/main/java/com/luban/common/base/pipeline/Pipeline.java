package com.hp.common.base.pipeline;

/**
 * @author hp
 */
public interface Pipeline<FILTER extends com.hp.common.base.pipeline.PipelineFilter<CONTEXT>, CONTEXT extends com.hp.common.base.pipeline.PipelineContext> {

    com.hp.common.base.pipeline.PipelineFilterChain<CONTEXT> getFilterChain();

    com.hp.common.base.pipeline.PipelineFilterChain<CONTEXT> addFilter(FILTER filter);

    com.hp.common.base.pipeline.PipelineFilterChain<CONTEXT> addFilter(String description, FILTER filter);

}
