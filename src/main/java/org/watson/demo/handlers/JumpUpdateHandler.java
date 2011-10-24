package org.watson.demo.handlers;

import org.anddev.andengine.entity.sprite.Sprite;
import org.watson.demo.game.Board;
import org.watson.demo.math.Point;
import org.watson.demo.movement.jump.JumpAction;
import java.util.LinkedList;

public class JumpUpdateHandler extends UpdateHandler {
    private Sprite sprite;
    private LinkedList<Point> points;

    @Override
    public void onUpdate(float secondsElapsed) {
        Point point = points.poll();
        if (isJumping()) {
            sprite.setPosition((float) point.getX(), (float) point.getY());
        } else {
            onComplete.onComplete();
        }
    }

    public void init(Board board, Sprite sprite) {
        this.sprite = sprite;
        points = new JumpAction().getJumpMovements(board, sprite.getX(), sprite.getY());
    }

    private boolean isJumping() {
        return points.size() != 0;
    }
}