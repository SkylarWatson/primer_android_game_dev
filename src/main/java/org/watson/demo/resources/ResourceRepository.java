package org.watson.demo.resources;

import org.anddev.andengine.audio.music.Music;
import org.anddev.andengine.audio.sound.Sound;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;

public class ResourceRepository {
    private TiledTextureRegion sprite;
    private TextureRegion backgroundTextureRegion;
    private Music backgroundMusic;
    private Sound jumpSound;

    public Music getBackgroundMusic() {
        return backgroundMusic;
    }

    public void setBackgroundMusic(Music backgroundMusic) {
        this.backgroundMusic = backgroundMusic;
    }

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

    public void setJumpSound(Sound jumpSound) {
        this.jumpSound = jumpSound;
    }

    public Sound getJumpSound() {
        return jumpSound;
    }
}