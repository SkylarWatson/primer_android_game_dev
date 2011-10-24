package org.watson.demo.handlers;

import org.anddev.andengine.entity.sprite.Sprite;

public class MovementUpdateHandler extends UpdateHandler {
    private Sprite sprite;
    private float to;

    public MovementUpdateHandler(Sprite sprite, float to) {
        this.to = to;
        this.sprite = sprite;
    }

    @Override
    public void onUpdate(float v) {
        if (to >= sprite.getX() + sprite.getWidth()) {
            sprite.setPosition(sprite.getX() + 0.5f, sprite.getY());
        } else {
            onComplete.onComplete();
        }
    }
}