package org.watson.demo.handlers;

import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.entity.sprite.Sprite;
import org.watson.demo.game.Board;
import org.watson.demo.math.Point;
import org.watson.demo.movement.jump.JumpAction;
import java.util.LinkedList;

public class JumpUpdateHandler implements IUpdateHandler {
    private IOnComplete onComplete;
    private Sprite sprite;
    private LinkedList<Point> points;
    private Board board;

    public void onUpdate(float secondsElapsed) {
        Point point = points.poll();
        if (points.size() != 0) {
            sprite.setPosition((float) point.getX(), (float) point.getY());
        } else {
            onComplete.onComplete();
        }
    }

    public void reset() {

    }

    public void init(Board board, Sprite sprite) {
        this.sprite = sprite;
        this.board = board;
        points = new JumpAction().getJumpMovements(board, sprite.getX(), sprite.getY());
    }

    public void setOnComplete(IOnComplete onComplete) {
        this.onComplete = onComplete;
    }
}