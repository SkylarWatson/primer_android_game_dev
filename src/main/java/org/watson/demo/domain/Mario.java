package org.watson.demo.domain;

import org.anddev.andengine.entity.sprite.AnimatedSprite;
import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;
import org.watson.demo.FrameDurations;
import org.watson.demo.game.Board;
import org.watson.demo.modifiers.JumpEntityModifier;
import org.watson.demo.modifiers.MoveEntityModifier;

public class Mario {
    private static final float GROUND_CUSHION = 8.5f;
    private AnimatedSprite sprite;
    private FrameDurations frameDurations;
    private boolean isJumping;

    public Mario(float x, float y, TiledTextureRegion textureRegion) {
        sprite = new AnimatedSprite(x, y - GROUND_CUSHION, textureRegion);
        frameDurations = new FrameDurations();
        animateWalk();
    }

    public AnimatedSprite asSprite() {
        return sprite;
    }

    public void move(float to) {
        sprite.registerEntityModifier(new MoveEntityModifier(to));
    }

    private void animateWalk() {
        sprite.animate(frameDurations.getDurations(4, 85), 46, 49, true);
    }

    private void animateJump() {
        sprite.animate(frameDurations.getDurations(2, 100), 57, 58, true);
    }

    public void jump(Board board) {
        if(!isJumping) {
            isJumping = true;
            sprite.stopAnimation();
            animateJump();
            JumpEntityModifier jumpEntityModifier = new JumpEntityModifier(board, sprite.getX(), sprite.getY());
            jumpEntityModifier.setDoneJumping(new JumpEntityModifier.DoneJumping() {
                @Override
                public void whenDone() {
                    isJumping = false;
                    sprite.stopAnimation();
                    animateWalk();
                }
            });

            sprite.registerEntityModifier(jumpEntityModifier);
        }
    }
}