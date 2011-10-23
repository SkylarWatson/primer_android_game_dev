package org.watson.demo.game;

import org.anddev.andengine.opengl.texture.region.TextureRegion;

public class Board {
    private float width;
    private float height;

    public Board(float width, float height) {
        this.width = width;
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public float yOffset(TextureRegion textureRegion) {
        return height - textureRegion.getHeight();
    }

    public float xOffset(TextureRegion textureRegion) {
        return width - textureRegion.getHeight();
    }
}