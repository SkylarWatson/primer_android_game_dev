package org.watson.demo.domain;

import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.watson.demo.modifiers.MoveEntityModifier;

public class WhiteBox {
    private Sprite sprite;

    public WhiteBox(float x, float y, TextureRegion textureRegion) {
        sprite = new Sprite(x, y, textureRegion);
    }

    public Sprite asSprite() {
        return sprite;
    }

    public void move(float to) {
        sprite.registerEntityModifier(new MoveEntityModifier(to));
    }
}