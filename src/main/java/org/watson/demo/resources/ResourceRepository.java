package org.watson.demo.resources;

import org.anddev.andengine.opengl.texture.region.TextureRegion;

public class ResourceRepository {
    private TextureRegion sprite;

    public void setSprite(TextureRegion sprite) {
        this.sprite = sprite;
    }

    public TextureRegion getSprite() {
        return sprite;
    }
}