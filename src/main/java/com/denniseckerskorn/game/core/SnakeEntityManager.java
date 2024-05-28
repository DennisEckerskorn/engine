package com.denniseckerskorn.game.core;

import com.denniseckerskorn.engine.core.AssetManager;
import com.denniseckerskorn.engine.core.Blackboard;
import com.denniseckerskorn.engine.core.Collider;
import com.denniseckerskorn.engine.core.EntityManager;
import com.denniseckerskorn.engine.input.KeyboardManager;
import com.denniseckerskorn.game.ColliderMask;
import com.denniseckerskorn.game.config.Settings;
import com.denniseckerskorn.game.entities.Food;
import com.denniseckerskorn.game.entities.Snake;
import com.denniseckerskorn.game.utils.Direction;

import java.awt.image.BufferedImage;

public class SnakeEntityManager extends EntityManager {
    private Food food;

    public SnakeEntityManager(int maxEntities) {
        super(maxEntities);
        food = new Food(0, 0, Blackboard.cellSize, Blackboard.cellSize, 1, 0, Settings.FOOD_COLLIDER_OFFSET, ColliderMask.LAYER_FOOD, getAssetManager().getSprite("food"));
        // getAssetManager().getSound("shoot").play();
    }

    @Override
    public AssetManager createAssetManager() {
        return new SnakeAssetManager();
    }

    public Snake createSnake(float x, float y, Direction direction, KeyboardManager keyboardManager) {
        Snake snake = new Snake(x, y, Blackboard.cellSize, Blackboard.cellSize, Settings.SNAKE_HP, Settings.SNAKE_DAMAGE, Settings.SNAKE_COLLIDER_OFFSET,
                ColliderMask.LAYER_SNAKE, getAssetManager().getSprite("player"), direction.getDirection().getX(), direction.getDirection().getY(), Blackboard.cellSize, 0, keyboardManager);
        addEntity(snake);
        return snake;
    }

    public Food spawnFood(float x, float y) {
        food.setPosition(x, y);
        addEntity(food);
        return food;
    }
}
