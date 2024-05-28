package com.denniseckerskorn.game.entities;

import com.denniseckerskorn.engine.entities.DynamicEntity;

import java.awt.image.BufferedImage;

public class SnakeFragment extends DynamicEntity {

    public SnakeFragment(float x, float y, float width, float height, float hp, float damage, float colliderOffset, int colliderMask, BufferedImage sprite, float velocityX, float velocityY, float linearVelocity, float acceleration) {
        super(x, y, width, height, hp, damage, colliderOffset, colliderMask, sprite, velocityX, velocityY, linearVelocity, acceleration);
    }

    @Override
    public void lastUpdate(double deltaTime) {

    }

    @Override
    public void postUpdate(double deltaTime) {

    }
}
