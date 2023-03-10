package dev.codenmore.tilegame.states;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.entities.creatures.Player;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.tiles.Tile;
import dev.codenmore.tilegame.worlds.World;

import java.awt.*;

public class GameState extends State {

        private Player player;
        private World world;

        public GameState(Game game) {
                super(game);
                player = new Player(game,100, 100);
                world = new World("res/worlds/world_1.txt");
        }

        @Override
        public void tick() {
                world.tick();
                player.tick();
        }

        @Override
        public void render(Graphics g) {
                world.render(g);
                player.render(g);
//                Tile.tiles[0].render(g, 0, 0);
        }

//        test koment

}
