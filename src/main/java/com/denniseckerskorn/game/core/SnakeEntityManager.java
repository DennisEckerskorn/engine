package com.denniseckerskorn.game.core;

import com.denniseckerskorn.engine.core.AssetManager;
import com.denniseckerskorn.engine.core.EntityManager;

public class SnakeEntityManager extends EntityManager {
    public SnakeEntityManager(int maxEntities) {
        super(maxEntities);
        // getAssetManager().getSound("shoot").play();
    }

    @Override
    public AssetManager createAssetManager() {
        return new SnakeAssetManager();
    }
}
