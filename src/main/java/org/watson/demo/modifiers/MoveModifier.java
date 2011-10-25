package org.watson.demo.modifiers;

import org.anddev.andengine.entity.IEntity;
import org.anddev.andengine.entity.modifier.EntityModifier;
import org.anddev.andengine.entity.modifier.IEntityModifier;

public class MoveModifier extends EntityModifier {
    private float to;

    public MoveModifier(float to) {
        this.to = to;
    }

    @Override
    public float onUpdate(float secondsElapsed, IEntity entity) {
        if(entity.getX() <= to) entity.setPosition(entity.getX() + 0.5f, entity.getY());
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