package dev.codenmore.tilegame;

import dev.codenmore.tilegame.display.Display;

public class launcher {
    public static void main(String[] args) {
        Game game = new Game("Warcraft", 600, 600);
        game.start();
    }
}
