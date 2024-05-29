package com.denniseckerskorn.game.entities;

import com.denniseckerskorn.engine.entities.PlayableEntity;
import com.denniseckerskorn.engine.input.KeyboardManager;
import com.denniseckerskorn.engine.math.Vector2;
import com.denniseckerskorn.game.config.Settings;
import com.denniseckerskorn.game.utils.Direction;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Snake extends PlayableEntity {

    private final List<SnakeFragment> fragments;
    private final Direction nextDirection;
    private final Vector2 lastPosition;

    public Snake(float x, float y, float width, float height, float hp, float damage, float colliderOffset, int colliderMask, BufferedImage sprite, Direction direction, float linearVelocity, float acceleration, KeyboardManager keyboardManager) {
        super(x, y, width, height, hp, damage, colliderOffset, colliderMask, sprite, direction.getDirection().getX(), direction.getDirection().getY(), linearVelocity, acceleration, keyboardManager);
        fragments = new ArrayList<>(Settings.COLS * Settings.ROWS - 1);
        nextDirection = Direction.valueOf(direction.toString());
        lastPosition = new Vector2(x, y);
    }

    public List<SnakeFragment> getFragments() {
        return fragments;
    }

    @Override
    public void processInput() {
        KeyboardManager km = getKeyboardManager();
        if (km.isUp()) {

            nextDirection.getDirection().setPosition(Direction.UP.getDirection());
        } else if (km.isDown()) {

            nextDirection.getDirection().setPosition(Direction.DOWN.getDirection());
        }

        if (km.isLeft()) {

            nextDirection.getDirection().setPosition(Direction.LEFT.getDirection());
        } else if (km.isRight()) {

            nextDirection.getDirection().setPosition(Direction.RIGHT.getDirection());
        }
    }

    public Direction getNextDirection() {
        return nextDirection;
    }

    @Override
    public void update(double deltaTime) {
        lastPosition.setPosition(getPosition());
        super.update(deltaTime);
        int lastX = (int) lastPosition.getX();
        int lastY = (int) lastPosition.getY();
        int currentX = (int) getX();
        int currentY = (int) getY();

        if (lastX != currentX || lastY != currentY) {
            setDirection(nextDirection);
            switch (nextDirection) {
                case RIGHT:
                case LEFT:
                    setPosition(getX(), (int) getY());
                    break;
                case UP:
                case DOWN:
                    setPosition((int) getX(), getY());
                    break;
            }
        }

    }

    @Override
    public void lastUpdate(double deltaTime) {

    }

    @Override
    public void postUpdate(double deltaTime) {

    }
}
