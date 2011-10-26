package org.watson.demo.modifiers;

import org.anddev.andengine.entity.modifier.EntityModifier;
import org.anddev.andengine.entity.modifier.IEntityModifier;
import org.anddev.andengine.entity.IEntity;
import org.watson.demo.game.Board;
import org.watson.demo.math.Point;
import org.watson.demo.movement.jump.JumpCurveCalulator;

import java.util.LinkedList;

public class JumpEntityModifier extends EntityModifier {
    private LinkedList<Point> points;
    private DoneJumping doneJumping;

    public JumpEntityModifier(Board board, float startX, float startY) {
        points = new JumpCurveCalulator().getJumpMovements(board, startX, startY);
    }

    @Override
    public IEntityModifier clone() {
        return null;
    }

    public void reset() {

    }

    public float getSecondsElapsed() {
        return 0;
    }

    public float getDuration() {
        return 0;
    }

    public float onUpdate(float v, IEntity entity) {
        Point point = points.poll();
        if (isJumping()) {
            entity.setPosition((float) point.getX(), (float) point.getY());
        } else {
            entity.unregisterEntityModifier(this);
            if(doneJumping != null) doneJumping.whenDone();
        }
        return 0;
    }

    public void setDoneJumping(DoneJumping doneJumping) {
        this.doneJumping = doneJumping;
    }

    private boolean isJumping() {
        return points.size() != 0;
    }

    public interface DoneJumping {
        public void whenDone();
    }
}