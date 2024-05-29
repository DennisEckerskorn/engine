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

import java.nio.channels.SeekableByteChannel;
import java.util.*;

public class SnakeGame extends Game {
    private final int rows;
    private final int cols;
    private final SnakeEntityManager entityManager;
    private final Random random;
    private final Snake snake;

    private int emptyCellsCount;

    public SnakeGame(int width, int height, int rows, int cols, float fpsLimit, float updateLimit, int maxEntities) {
        super(width, height, fpsLimit, updateLimit, maxEntities);
        this.rows = rows;
        this.cols = cols;
        this.random = new Random();
        entityManager = (SnakeEntityManager) Blackboard.entityManager;
        snake = entityManager.createSnake(cols / 2, rows / 2, Direction.RIGHT,
                new KeyboardManager('w', 's', 'a', 'd', 'm', 'j'));
        spawnFood();
    }

    private void spawnFood() {
        int row = random.nextInt(Settings.ROWS);
        int col = random.nextInt(Settings.COLS);

        if (isEmptyCell(col, row)) {
            entityManager.spawnFood(col, row);
        }
    }

    private boolean isEmptyCell(int col, int row) {
        List<SnakeFragment> fragments = snake.getFragments();
        if (snake.getX() == col && snake.getY() == row) {
            return false;
        }
        for (SnakeFragment fragment : snake.getFragments()) {
            if (fragment.getX() == col && fragment.getY() == row) {
                return false;
            }
        }
        return true;
    }

    @Override
    public EntityManager createEntityManager(int maxEntities) {
        return new SnakeEntityManager(Settings.MAX_ENTITIES);
    }

    @Override
    public void update(double deltaTime) {
        super.update(deltaTime);
        System.out.println(snake.getNextDirection());

    }

    @Override
    public void gameResized() {
        Blackboard.cellSize = getWidth() < getHeight() ? getWidth() / cols : getHeight() / rows;
    }
}
