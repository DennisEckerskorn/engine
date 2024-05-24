package com.denniseckerskorn.game.entities;

import com.denniseckerskorn.engine.entities.PlayableEntity;
import com.denniseckerskorn.engine.input.KeyboardManager;

import java.awt.image.BufferedImage;

public class Snake extends PlayableEntity {


    public Snake(float x, float y, float width, float height, float hp, float damage, float colliderOffset, int colliderMask, BufferedImage sprite, float velocityX, float velocityY, float linearVelocity, float acceleration, KeyboardManager keyboardManager) {
        super(x, y, width, height, hp, damage, colliderOffset, colliderMask, sprite, velocityX, velocityY, linearVelocity, acceleration, keyboardManager);
    }

    @Override
    public void processInput() {
        if()
    }

    @Override
    public void lastUpdate(double deltaTime) {

    }

    @Override
    public void postUpdate(double deltaTime) {

    }
}
