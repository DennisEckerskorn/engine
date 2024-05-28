package com.denniseckerskorn.game.entities;

import com.denniseckerskorn.engine.entities.Entity;

import java.awt.image.BufferedImage;

public class Food extends Entity {
    public Food(float x, float y, float width, float height, float hp, float damage, float colliderOffset, int colliderMask, BufferedImage sprite) {
        super(x, y, width, height, hp, damage, colliderOffset, colliderMask, sprite);
    }

    @Override
    public void update(double deltaTime) {
        
    }

    @Override
    public void lastUpdate(double deltaTime) {

    }

    @Override
    public void postUpdate(double deltaTime) {

    }
}
