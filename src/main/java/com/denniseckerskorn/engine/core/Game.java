package com.denniseckerskorn.engine.core;

import com.denniseckerskorn.engine.graphics.RenderAPI;
import com.denniseckerskorn.engine.graphics.swing.SwingRenderer;

public abstract class Game implements Runnable, Updateable {
    private final int width;
    private final int height;
    private float fpsLimit;
    private float updateLimit;
    private Thread thread;
    private boolean finished;
    private RenderAPI renderAPI;

    public Game(int width, int height, float fpsLimit, float updateLimit, int maxEntities) {
        this.width = width;
        this.height = height;
        this.fpsLimit = fpsLimit;
        this.updateLimit = updateLimit;
        this.finished = false;
        Blackboard.entityManager = createEntityManager(maxEntities);
    }

    public void setRenderAPI(RenderAPI renderAPI) {
        this.renderAPI = renderAPI;
    }

    public void setFpsLimit(float fpsLimit) {
        this.fpsLimit = fpsLimit;
    }

    public float getFpsLimit() {
        return fpsLimit;
    }

    public void setUpdateLimit(float updateLimit) {
        this.updateLimit = updateLimit;
    }

    public float getUpdateLimit() {
        return updateLimit;
    }

    public abstract EntityManager createEntityManager(int maxEntities);

    public void start() {
        thread = new Thread(this);
        thread.start();
    }

    //TODO: separa limiteUpdateporseconds
    @Override
    public void run() {
        final long NANOS_IN_SECONDS = 1_000_000_000;
        long currentFrame;
        long lastFrame = System.nanoTime();
        long lastUpdateFrame = lastFrame;
        double deltaTime;

        System.out.println("Iniciando hilo ...");
        while (!finished) {
            currentFrame = System.nanoTime();
            deltaTime = (double) (currentFrame - lastFrame) / NANOS_IN_SECONDS;

            if (updateLimit > 0) {
                double nanosBetweenUpdates = NANOS_IN_SECONDS / updateLimit;
                if (currentFrame - lastUpdateFrame >= nanosBetweenUpdates) {
                    updateGame(deltaTime);
                    lastUpdateFrame = currentFrame;
                }
            } else {
                updateGame(deltaTime);
            }

            if (fpsLimit > 0) {
                double nanosBetweenFrames = NANOS_IN_SECONDS / fpsLimit;
                if (currentFrame - lastFrame > nanosBetweenFrames) {
                    render();
                    lastFrame = currentFrame;
                }
            } else {
                render();
                lastFrame = currentFrame;
            }
        }
    }

    private void updateGame(double deltaTime) {
        processInput();
        update(deltaTime);
        postUpdate(deltaTime);
        lastUpdate(deltaTime);
        render();
    }

    private void render() {
        renderAPI.render();
    }

    @Override
    public void update(double deltaTime) {
        Blackboard.entityManager.update(deltaTime);
    }

    @Override
    public void lastUpdate(double deltaTime) {
        Blackboard.entityManager.lastUpdate(deltaTime);
    }

    @Override
    public void postUpdate(double deltaTime) {
        Blackboard.entityManager.postUpdate(deltaTime);
    }

    private void processInput() {
        Blackboard.entityManager.processInput();
    }
}
