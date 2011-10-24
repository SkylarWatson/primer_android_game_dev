package org.watson.demo.handlers;

import org.anddev.andengine.engine.handler.IUpdateHandler;

public abstract class UpdateHandler implements IUpdateHandler {
    protected IOnComplete onComplete;

    public void setOnComplete(IOnComplete onComplete) {
        this.onComplete = onComplete;
    }

    @Override
    public void reset() {}
}
