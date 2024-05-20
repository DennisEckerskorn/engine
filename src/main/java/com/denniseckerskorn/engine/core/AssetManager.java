package com.denniseckerskorn.engine.core;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.denniseckerskorn.engine.audio.Sound;

public abstract class AssetManager {
    private final Map<String, BufferedImage> sprites;
    private final Map<String, Sound> sounds;

    // private final Map<String, Animation> animation;

    public AssetManager() {
        sprites = new HashMap<>();
        sounds = new HashMap<>();
        loadAll();
    }

    public void loadSprite(String name, String path) {
        try {
            BufferedImage bufferedImage = ImageIO.read(getClass().getResourceAsStream(path));
            sprites.put(name, bufferedImage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
/*
    public void loadSound(String name, String path) {
        try {
            String fullPath = getClass().getResource(path).getPath();
           Sound sound = new Sound(path);
           sounds.put(name, sound);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
 */

    public BufferedImage getSprite(String name) {
        return sprites.get(name);
    }

    public Sound getSound(String name) {
        return sounds.get(name);
    }

    public abstract void loadAll();
}
