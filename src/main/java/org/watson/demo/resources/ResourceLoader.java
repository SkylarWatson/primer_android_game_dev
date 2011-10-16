package org.watson.demo.resources;

import android.graphics.Typeface;
import org.anddev.andengine.opengl.font.Font;
import org.anddev.andengine.opengl.font.FontFactory;
import org.anddev.andengine.opengl.texture.Texture;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.ui.activity.BaseGameActivity;

public class ResourceLoader {
    private BaseGameActivity context;

    public ResourceLoader(BaseGameActivity context) {
        this.context = context;
    }

    public Font loadFontResource(int size, int color, Typeface typeface) {
        Texture texture = new Texture(256, 256, TextureOptions.BILINEAR);
        Font font = FontFactory.create(texture, typeface, size, true, color);
        context.getEngine().getFontManager().loadFont(font);
        context.getEngine().getTextureManager().loadTexture(texture);
        return font;
    }
}