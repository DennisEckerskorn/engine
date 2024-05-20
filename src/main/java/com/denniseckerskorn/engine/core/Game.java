package com.denniseckerskorn.engine.core;

import com.denniseckerskorn.engine.graphics.RenderAPI;
import com.denniseckerskorn.engine.graphics.swing.SwingRenderer;

public abstract class Game implements Runnable, Updateable {
    private final int width;
    private final int height;
    private final float fpsLimit;
    private Thread thread;
    private boolean finished;
    private RenderAPI renderAPI;

    public Game(int width, int height, float fpsLimit, int maxEntities) {
        this.width = width;
        this.height = height;
        this.fpsLimit = fpsLimit;
        this.finished = false;
        Blackboard.entityManager = createEntityManager(maxEntities);
    }

    public void setRenderAPI(RenderAPI renderAPI) {
        this.renderAPI = renderAPI;
    }

    public abstract EntityManager createEntityManager(int maxEntities);

    public void start() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        final long NANOS_IN_SECONDS = 1_000_000_000;
        final double NANOS_BETWEEN_UPDATES = 1_000_000_000 / fpsLimit;
        long currentFrame;
        long lastFrame = System.nanoTime();
        double deltaTime;

        System.out.println("Iniciando hilo ...");
        while (!finished) {
            currentFrame = System.nanoTime();
            deltaTime = (double) (currentFrame - lastFrame) / NANOS_IN_SECONDS;
            if (currentFrame - lastFrame > NANOS_BETWEEN_UPDATES) {
                processInput();

                //Representa el tiempo transcurrido desde el último fotograma.
                //Actualizaciones lógicas del juego, como el movimiento de objetos,
                // la detección de colisiones, la lógica de la IA, etc.
                update(deltaTime);

                //Realizar cualquier acción adicional que necesita realizarse
                // después de la actualización principal del juego.
                // Por ejemplo, puedes realizar ajustes finales en el estado de los objetos,
                // generar eventos basados en el estado actual, etc.
                postUpdate(deltaTime);

                //Útil para realizar acciones que deben llevarse a cabo después
                // de que se hayan realizado todas las actualizaciones principales del juego
                // y justo antes de renderizar el siguiente fotograma.
                // Limpiar recursos, actualizar información de interfaz de usuario,
                // o realizar cualquier tarea final antes de renderizar.
                lastUpdate(deltaTime);

                render();
                lastFrame = currentFrame;
            }
        }
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
