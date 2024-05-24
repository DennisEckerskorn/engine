package com.denniseckerskorn.game.core;

import com.denniseckerskorn.engine.core.AssetManager;
import com.denniseckerskorn.engine.core.EntityManager;
import com.denniseckerskorn.engine.input.KeyboardManager;
import com.denniseckerskorn.game.entities.Snake;

import java.awt.image.BufferedImage;

public class SnakeEntityManager extends EntityManager {
    public SnakeEntityManager(int maxEntities) {
        super(maxEntities);
        // getAssetManager().getSound("shoot").play();
    }

    @Override
    public AssetManager createAssetManager() {
        return new SnakeAssetManager();
    }

    public Snake createSnake(float x, float y, float width, float height,  float velocityX, float velocityY, float linearVelocity, float acceleration, KeyboardManager keyboardManager) {

    }
}
