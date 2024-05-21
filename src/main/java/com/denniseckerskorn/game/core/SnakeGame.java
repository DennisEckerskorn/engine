package com.denniseckerskorn.game.core;

import com.denniseckerskorn.engine.core.Blackboard;
import com.denniseckerskorn.engine.core.EntityManager;
import com.denniseckerskorn.engine.core.Game;
import com.denniseckerskorn.game.config.Settings;

public class SnakeGame extends Game {
    private final int rows;
    private final int cols;
    private final SnakeEntityManager entityManager;

    public SnakeGame(int width, int height,int rows, int cols, float fpsLimit, float updateLimit, int maxEntities) {
        super(width, height, fpsLimit, updateLimit, maxEntities);
        this.rows = rows;
        this.cols = cols;
        entityManager = (SnakeEntityManager) Blackboard.entityManager;

    }


    @Override
    public EntityManager createEntityManager(int maxEntities) {
        return new SnakeEntityManager(Settings.MAX_ENTITIES);
    }

    @Override
    public void update(double deltaTime) {
        super.update(deltaTime);

    }


}
