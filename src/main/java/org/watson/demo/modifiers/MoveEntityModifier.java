package org.watson.demo.modifiers;

import org.anddev.andengine.entity.IEntity;
import org.anddev.andengine.entity.modifier.EntityModifier;
import org.anddev.andengine.entity.modifier.IEntityModifier;
import org.watson.demo.game.Board;

public class MoveEntityModifier extends EntityModifier {
    private float to;

    public MoveEntityModifier(float to) {
        this.to = to;
    }

    @Override
    public float onUpdate(float secondsElapsed, IEntity entity) {
        if(to >= entity.getX()) {
            entity.setPosition(entity.getX() + 0.5f, entity.getY());
        } else {
            entity.setPosition(entity.getInitialX(), entity.getInitialY());
        }
        return 0;
    }

    @Override
    public IEntityModifier clone() throws CloneNotSupportedException {
        return null;
    }

    @Override
    public float getSecondsElapsed() {
        return 0;
    }

    @Override
    public float getDuration() {
        return 0;
    }

    @Override
    public void reset() {
    }
}