package com.denniseckerskorn;

import com.denniseckerskorn.game.config.Settings;
import com.denniseckerskorn.game.core.SnakeGame;
import com.denniseckerskorn.game.graphics.SnakeSwingRenderer;

import javax.swing.*;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        //Snake
        SnakeGame snakeGame = new SnakeGame(Settings.WIDTH, Settings.HEIGHT, Settings.ROWS, Settings.COLS, Settings.TARGET_FPS, Settings.TARGET_UPDATE, Settings.MAX_ENTITIES);
        SnakeSwingRenderer snakeSwingRenderer = new SnakeSwingRenderer(Settings.WIDTH, Settings.HEIGHT);
        snakeGame.setRenderAPI(snakeSwingRenderer);
        JFrame frame = new JFrame();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Snake");
        frame.add(snakeSwingRenderer);
        frame.pack();
        frame.setVisible(true);
        snakeGame.start();
    }
}