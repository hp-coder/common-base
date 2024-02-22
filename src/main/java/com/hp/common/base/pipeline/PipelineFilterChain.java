package com.hp.common.base.pipeline;

/**
 * @author hp
 */
public interface PipelineFilterChain<CONTEXT extends com.hp.common.base.pipeline.PipelineContext> {

    void filter(CONTEXT context);

    void filterNext(CONTEXT context);
}
