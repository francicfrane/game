package dev.codenmore.tilegame.states;

import dev.codenmore.tilegame.gfx.Assets;

import java.awt.*;

public class MenuState extends State {

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, 0, 0 , null);
    }
}
