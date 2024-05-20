package com.denniseckerskorn.game.graphics;

import com.denniseckerskorn.engine.entities.Entity;
import com.denniseckerskorn.engine.graphics.swing.SwingRenderer;

import java.awt.*;

public class SnakeSwingRenderer extends SwingRenderer {

    public SnakeSwingRenderer(int width, int height) {
        super(width, height);
    }
    
    @Override
    public void drawEntity(Graphics2D g2, Entity e) {
        g2.setColor(Color.ORANGE);
        g2.fillRect((int) e.getX(), (int) e.getY(), (int) e.getWidth(), (int) e.getHeight());
    }

    @Override
    public void drawBackground(Graphics2D g2) {
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, getWidth(), getHeight());
    }
}
