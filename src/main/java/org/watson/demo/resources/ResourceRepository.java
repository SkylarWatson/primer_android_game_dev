package org.watson.demo.resources;

import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;

public class ResourceRepository {
    private TiledTextureRegion sprite;
    private TextureRegion backgroundTextureRegion;

    public void setSprite(TiledTextureRegion sprite) {
        this.sprite = sprite;
    }

    public TiledTextureRegion getSprite() {
        return sprite;
    }

    public void setBackgroundTextureRegion(TextureRegion backgroundTextureRegion) {
        this.backgroundTextureRegion = backgroundTextureRegion;
    }

    public TextureRegion getBackgroundTextureRegion() {
        return backgroundTextureRegion;
    }
}