package org.watson.demo.domain;

import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.opengl.texture.region.TextureRegion;

public class WhiteBox {
    private TextureRegion textureRegion;
    private Sprite sprite;
    private float x;
    private float y;

    public WhiteBox(float x, float y, TextureRegion textureRegion) {
        this.textureRegion = textureRegion;
        sprite = new Sprite(x, y, textureRegion);

    }

    public Sprite asSprite() {
        return sprite;
    }

    public void move(float width) {
        for(float i = 0; i <= width; i = i + 0.1f) {
            sprite.setPosition(0, i);
        }
    }
}