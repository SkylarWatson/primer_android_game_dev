package org.watson.demo.resources;

import android.graphics.Typeface;
import org.anddev.andengine.opengl.font.Font;
import org.anddev.andengine.opengl.font.FontFactory;
import org.anddev.andengine.opengl.texture.Texture;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.texture.region.TextureRegionFactory;
import org.anddev.andengine.ui.activity.BaseGameActivity;

public class ResourceLoader {
    private BaseGameActivity context;

    public ResourceLoader(BaseGameActivity context) {
        this.context = context;
    }

    public TextureRegion loadResource(int width, int height, String path) {
        Texture texture = new Texture(width, height, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
        TextureRegion textureRegion = TextureRegionFactory.createFromAsset(texture, context, path, 0, 0);
        context.getEngine().getTextureManager().loadTexture(texture);
        return textureRegion;
    }

    public Font loadFontResource(int size, int color, Typeface typeface) {
        Texture texture = new Texture(256, 256, TextureOptions.BILINEAR);
        Font font = FontFactory.create(texture, typeface, size, true, color);
        context.getEngine().getFontManager().loadFont(font);
        context.getEngine().getTextureManager().loadTexture(texture);
        return font;
    }
}