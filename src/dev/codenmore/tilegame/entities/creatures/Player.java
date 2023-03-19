package dev.codenmore.tilegame.entities.creatures;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Animation;
import dev.codenmore.tilegame.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature{

    private Animation animDown, animUp, animLeft, animRight, animTest;


    public Player(Handler handler, float x, float y) {
        super(handler, x, y, 70, 70);

        bounds.x = 15;
        bounds.y = 28;
        bounds.width =40;
        bounds.height = 40;

        animDown = new Animation(200, Assets.player_down);
        animUp = new Animation(200, Assets.player_up);
        animLeft = new Animation(200, Assets.player_left);
        animRight = new Animation(200, Assets.player_right);
        animTest = new Animation(200, Assets.player_test);


    }

    @Override
    public void tick() {
//        animation
        animDown.tick();
        animUp.tick();
        animLeft.tick();
        animRight.tick();
//        animTest.tick();

//        movement
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
        g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
//        g.setColor(Color.CYAN);
//
//
//        g.fillRect((int) (x + bounds.x  - handler.getGameCamera().getxOffset()),
//                (int) (y + bounds.y  - handler.getGameCamera().getyOffset()),
//                Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
    }

    private BufferedImage getCurrentAnimationFrame() {
        BufferedImage bi = null;

        if (xMove < 0) {
            bi = animLeft.getCurrentFrame();
        } else if(xMove > 0) {
            bi = animRight.getCurrentFrame();
        } else if (yMove < 0) {
            bi = animUp.getCurrentFrame();
        } else if(yMove > 0) {
            bi = animDown.getCurrentFrame();
        } else {
            bi = animTest.getCurrentFrame();
        }

        return bi;
    }
}
