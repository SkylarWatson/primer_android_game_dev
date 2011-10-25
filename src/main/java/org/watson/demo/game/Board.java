package org.watson.demo.game;

import org.anddev.andengine.entity.sprite.Sprite;
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

    public float yOffset(Sprite sprite) {
        return width - (sprite.getHeight());
    }

    public float yOffset(TextureRegion textureRegion) {
        return height - textureRegion.getHeight();
    }

    public float xOffset(Sprite sprite) {
        return xOffset(sprite.getWidth());
    }

    public float xOffset(TextureRegion textureRegion) {
        return xOffset(textureRegion);
    }

    private float yOffset(float y) {
        return height - y;
    }

    private float xOffset(float x) {
        return width - x;
    }
}