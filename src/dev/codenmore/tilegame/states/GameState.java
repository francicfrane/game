package dev.codenmore.tilegame.states;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.entities.creatures.Player;
import dev.codenmore.tilegame.worlds.World;

import java.awt.*;

public class GameState extends State {

        private Player player;
        private World world;

        public GameState(Game game) {
                super(game);
                player = new Player(game,100, 100);
                world = new World(game, "res/worlds/world_1.txt");

//                game.getGameCamera().move(0, 0);
        }

        @Override
        public void tick() {
                world.tick();
                player.tick();
//                game.getGameCamera().move(1, 1);
        }

        @Override
        public void render(Graphics g) {
                world.render(g);
                player.render(g);
        }

//        test koment

}
