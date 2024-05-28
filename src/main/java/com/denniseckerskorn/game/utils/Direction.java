package com.denniseckerskorn.game.utils;

import com.denniseckerskorn.engine.math.Vector2;

public enum Direction {
    LEFT(new Vector2(-1, 0)), RIGHT(new Vector2(1, 0)), UP(new Vector2(0, -1)), DOWN(new Vector2(0, 1));

    final Vector2 direction;
    Direction(Vector2 value) {
        this.direction = value;
    }

    public Vector2 getDirection() {
        return direction;
    }
}
