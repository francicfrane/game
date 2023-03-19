package dev.codenmore.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int width = 200, height = 200;

    public static BufferedImage dirt, grass, stone, tree;
    public static BufferedImage[] player_down = new BufferedImage[4], player_up = new BufferedImage[4], player_left = new BufferedImage[4], player_right = new BufferedImage[4];
    public static BufferedImage[][] playerAnimations = {player_down, player_right, player_left, player_up};
    public static BufferedImage[] player_test;

    public static void init() {
        int tempWidth = 400;
        int tempHeight = 521;

        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/chars/test.png"));

        SpriteSheet playerSheet = new SpriteSheet(ImageLoader.loadImage("/chars/sheet.png"));

        player_test = new BufferedImage[1];
        player_test[0] = playerSheet.crop(tempWidth, 0, tempWidth, tempHeight);

        for (int i = 0; i < playerAnimations.length; i++) {
            for (int j = 0; j < playerAnimations[i].length; j++) {
                System.out.println("now i = " + i);
                playerAnimations[i][j] = playerSheet.crop(tempWidth * j, i * tempHeight, tempWidth, tempHeight);
            }
        }

        dirt = sheet.crop(width,0, width, height);
        grass = sheet.crop(width * 2,0, width, height);
        stone = sheet.crop(0,height, width, height);
        tree = sheet.crop(width,height, width, height);
    }
}
