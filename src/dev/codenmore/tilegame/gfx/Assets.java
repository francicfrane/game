package dev.codenmore.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int width = 200, height = 200;

    public static BufferedImage player, dirt, grass, stone, tree;


    public static void init() {

        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/chars/test.png"));
        player = sheet.crop(0, 0, width, height);
        dirt = sheet.crop(width,0, width, height);
        grass = sheet.crop(width * 2,0, width, height);
        stone = sheet.crop(0,height, width, height);
        tree = sheet.crop(width,height, width, height);
    }
}
