package org.watson.demo.domain;

import org.anddev.andengine.entity.sprite.AnimatedSprite;
import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;
import org.watson.demo.game.Board;
import org.watson.demo.modifiers.JumpEntityModifier;
import org.watson.demo.modifiers.MoveEntityModifier;

public class WhiteBox {
    private AnimatedSprite sprite;

    public WhiteBox(float x, float y, TiledTextureRegion textureRegion) {
        sprite = new AnimatedSprite(x, y, textureRegion);
        animateWalk();
    }

    public AnimatedSprite asSprite() {
        return sprite;
    }

    public void move(float to) {
        sprite.registerEntityModifier(new MoveEntityModifier(to));
    }

    public void jump(Board board) {
        sprite.stopAnimation();
        animateJump();
        JumpEntityModifier jumpEntityModifier = new JumpEntityModifier(board, sprite.getX(), sprite.getY());
        jumpEntityModifier.setDoneJumping(new JumpEntityModifier.DoneJumping() {
            @Override
            public void whenDone() {
                sprite.stopAnimation();
                animateWalk();
            }
        });

        sprite.registerEntityModifier(jumpEntityModifier);
    }

    private void animateWalk() {
        long[] huh = new long[4];
        for (int i = 0; i <= 3; ++i) {
            huh[i] = 85;
        }
        sprite.animate(huh, 46, 49, true);
    }

    private void animateJump() {
        long[] huh = new long[2];
        for (int i = 0; i <= 1; ++i) {
            huh[i] = 100;
        }
        sprite.animate(huh, 57, 58, true);
    }
}