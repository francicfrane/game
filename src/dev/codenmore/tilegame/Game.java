package dev.codenmore.tilegame;

import dev.codenmore.tilegame.display.Display;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.gfx.ImageLoader;
import dev.codenmore.tilegame.gfx.SpriteSheet;
import dev.codenmore.tilegame.states.GameState;
import dev.codenmore.tilegame.states.State;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable {

    private Display display;
    public int width, height;
    public String title;
    private boolean running = false;
    private Thread thread;
    private BufferStrategy bs;
    private Graphics g;

//    States
    private State gameState;

    public Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
    }

    private void init() {
        display = new Display(title, width, height);
        Assets.init();

        gameState = new GameState();
        State.setState(gameState);
    }

    private void tick() {
        if (State.getState() != null) {
            State.getState().tick();
        }

    }

    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
//        clear screen
        g.clearRect(0, 0, width, height);

        g.fillRect(0,0, width, height);
        g.setColor(Color.BLACK);

//        drawing here!!

        if (State.getState() != null) {
            State.getState().render(g);
        }

//        g.drawImage(Assets.player, x ,0, null);


//        end drawing!!
        bs.show();
        g.dispose();

    }

    public void run() {
        init();

        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while(running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;
            if (delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }

            if (timer >= 1000000000) {
                System.out.println("ticks and frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }

        stop();
    }

    public synchronized void start() {
        if (running) {
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if (!running) {
        } else {
            running = false;
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
