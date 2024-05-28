package com.denniseckerskorn.game.core;

import com.denniseckerskorn.engine.core.Blackboard;
import com.denniseckerskorn.engine.core.EntityManager;
import com.denniseckerskorn.engine.core.Game;
import com.denniseckerskorn.engine.input.KeyboardManager;
import com.denniseckerskorn.engine.math.Vector2;
import com.denniseckerskorn.game.config.Settings;
import com.denniseckerskorn.game.entities.Snake;
import com.denniseckerskorn.game.entities.SnakeFragment;
import com.denniseckerskorn.game.utils.Direction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SnakeGame extends Game {
    private final int rows;
    private final int cols;
    private final SnakeEntityManager entityManager;
    private final Random random;
    private final Snake snake;
    private final List<Vector2> emptyCells;

    public SnakeGame(int width, int height, int rows, int cols, float fpsLimit, float updateLimit, int maxEntities) {
        super(width, height, fpsLimit, updateLimit, maxEntities);
        this.rows = rows;
        this.cols = cols;
        this.random = new Random();
        entityManager = (SnakeEntityManager) Blackboard.entityManager;
        snake = entityManager.createSnake(width / 2, height / 2, Direction.RIGHT,
                new KeyboardManager('w', 's', 'a', 'd', 'm', 'j'));
        emptyCells = new ArrayList<>(Settings.ROWS * Settings.COLS - 1);

        int capacity = Settings.ROWS * Settings.COLS - 1;

        for (int i = 0; i < capacity; i++) {
            emptyCells.add(new Vector2(-1, -1));
        }
    }

    private void spawnFood() {
        List<SnakeFragment> fragments = snake.getFragments();

    }

    @Override
    public EntityManager createEntityManager(int maxEntities) {
        return new SnakeEntityManager(Settings.MAX_ENTITIES);
    }

    @Override
    public void update(double deltaTime) {
        super.update(deltaTime);

    }

    @Override
    public void gameResized() {
        Blackboard.cellSize = getWidth() < getHeight() ? getWidth() / cols : getHeight() / rows;
    }
}
