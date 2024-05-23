package com.denniseckerskorn.engine.entities;

import com.denniseckerskorn.engine.core.Collider;
import com.denniseckerskorn.engine.input.KeyboardManager;
import com.denniseckerskorn.engine.math.Vector2;

import java.awt.image.BufferedImage;

public abstract class PlayableEntity extends DynamicEntity {
    private final KeyboardManager keyboardManager;

    public PlayableEntity(float x, float y, float width, float height, float hp, float damage,
                          float colliderXRight, float colliderXLeft, float colliderYUp, float colliderYDown, int colliderMask, BufferedImage sprite, float velocityX, float velocityY, float linearVelocity, float acceleration,
                          KeyboardManager keyboardManager) {
        super(x, y, width, height, hp, damage, colliderXRight, colliderXLeft, colliderYUp, colliderYDown, colliderMask, sprite, velocityX, velocityY, linearVelocity, acceleration);
        this.keyboardManager = keyboardManager;
    }


    public PlayableEntity(float x, float y, float width, float height, float hp, float damage, float colliderOffset, int colliderMask, BufferedImage sprite, float velocityX, float velocityY, float linearVelocity, float acceleration,
                          KeyboardManager keyboardManager) {
        super(x, y, width, height, hp, damage, colliderOffset, colliderOffset, colliderOffset, colliderOffset, colliderMask, sprite, velocityX, velocityY, linearVelocity, acceleration);
        this.keyboardManager = keyboardManager;
    }

    public PlayableEntity(float x, float y, float width, float height, float hp, float damage, float colliderOffsetX, float colliderOffsetY, int colliderMask, BufferedImage sprite, float velocityX, float velocityY, float linearVelocity, float acceleration,
                          KeyboardManager keyboardManager) {
        super(x, y, width, height, hp, damage, colliderOffsetX, colliderOffsetX, colliderOffsetY, colliderOffsetY, colliderMask, sprite, velocityX, velocityY, linearVelocity, acceleration);
        this.keyboardManager = keyboardManager;
    }

    public PlayableEntity(float x, float y, float width, float height, float hp, float damage, BufferedImage sprite, float velocityX, float velocityY, float linearVelocity, float acceleration, KeyboardManager keyboardManager) {
        super(x, y, width, height, hp, damage, sprite, velocityX, velocityY, linearVelocity, acceleration);
        this.keyboardManager = keyboardManager;
    }

    public PlayableEntity(float x, float y, float width, float height, float hp, float damage, float velocityX, float velocityY, float linearVelocity, float acceleration,
                          KeyboardManager keyboardManager) {
        super(x, y, width, height, hp, damage, null, velocityX, velocityY, linearVelocity, acceleration);
        this.keyboardManager = keyboardManager;
    }

    public abstract void processInput();
}
