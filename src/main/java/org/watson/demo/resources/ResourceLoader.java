package org.watson.demo.resources;

import org.anddev.andengine.opengl.texture.Texture;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.region.TextureRegionFactory;
import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;
import org.anddev.andengine.ui.activity.BaseGameActivity;

public class ResourceLoader {
    private BaseGameActivity context;

    public ResourceLoader(BaseGameActivity context) {
        this.context = context;
    }

    public TiledTextureRegion loadResource(int width, int height, String path, int columns, int rows) {
        Texture texture = new Texture(width, height, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
        TiledTextureRegion textureRegion = TextureRegionFactory.createTiledFromAsset(texture, context, path, 0, 0, columns, rows);
        context.getEngine().getTextureManager().loadTexture(texture);
        return textureRegion;
    }
}