package dev.codenmore.tilegame.entities.creatures;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Assets;

import java.awt.*;

public class Player extends Creature{


    public Player(Handler handler, float x, float y) {
        super(handler, x, y, 70, 70);

        bounds.x = 15;
        bounds.y = 28;
        bounds.width =40;
        bounds.height = 40;
    }

    @Override
    public void tick() {
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
    }

    private void getInput() {
        xMove = 0;
        yMove = 0;

        if (handler.getKeyManager().up) {
            yMove = -speed;
        }

        if (handler.getKeyManager().down) {
            yMove = speed;
        }

        if (handler.getKeyManager().left) {
            xMove = -speed;
        }

        if (handler.getKeyManager().right) {
            xMove = speed;
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
//        g.setColor(Color.CYAN);
//
//
//        g.fillRect((int) (x + bounds.x  - handler.getGameCamera().getxOffset()),
//                (int) (y + bounds.y  - handler.getGameCamera().getyOffset()),
//                Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
    }
}
