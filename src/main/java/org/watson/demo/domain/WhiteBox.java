package org.watson.demo.domain;

import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.opengl.texture.region.TextureRegion;

public class WhiteBox {
    private Sprite sprite;

    public WhiteBox(float x, float y, TextureRegion textureRegion) {
        sprite = new Sprite(x, y, textureRegion);
    }

    public Sprite asSprite() {
        return sprite;
    }

    public void move(final Scene scene, final float width) {
        scene.registerUpdateHandler(new IUpdateHandler() {
            @Override
            public void onUpdate(float pSecondsElapsed) {
                if(width >= sprite.getX() + sprite.getWidth()) {
                    sprite.setPosition(sprite.getX() + 0.5f, sprite.getY());
                } else {
                    scene.unregisterUpdateHandler(this);
                }
            }

            @Override
            public void reset() {
            }
        });
    }
}