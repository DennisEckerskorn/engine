package com.denniseckerskorn.game.core;

import com.denniseckerskorn.engine.core.AssetManager;
import com.denniseckerskorn.engine.core.Blackboard;
import com.denniseckerskorn.engine.core.EntityManager;
import com.denniseckerskorn.engine.input.KeyboardManager;
import com.denniseckerskorn.game.ColliderMask;
import com.denniseckerskorn.game.config.Settings;
import com.denniseckerskorn.game.entities.Snake;
import com.denniseckerskorn.game.utils.Direction;
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

    public Snake createSnake(float x, float y, float width, float height, Direction direction, KeyboardManager keyboardManager) {
        Snake snake = new Snake(x, y, width, height, Settings.SNAKE_HP, Settings.SNAKE_DAMAGE, Settings.SNAKE_COLLIDER_OFFSET,
                ColliderMask.LAYER_SNAKE, getAssetManager().getSprite("player"), direction.getDirection().getX(), direction.getDirection().getY(), Blackboard.cellSize, 0, keyboardManager);
        addEntity(snake);
        return snake;
    }
}
