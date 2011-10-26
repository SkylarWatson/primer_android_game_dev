package org.watson.demo.resources;

import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;

public class ResourceRepository {
    private TiledTextureRegion sprite;

    public void setSprite(TiledTextureRegion sprite) {
        this.sprite = sprite;
    }

    public TiledTextureRegion getSprite() {
        return sprite;
    }
}