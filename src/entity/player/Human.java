package entity.player;

import entity.Player;
import main.GPanel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Human extends Player {

    private String[] paths;

    public Human(GPanel gp) {
        super(gp);
        loadPath();
        getImage();
        update();
    }
    public void setSpriteValues() {
        spriteDimX = 48;
        spriteDimY = 48;
        spriteNumberAnimation = 13; // 13 animation (idle, walk, hit, die)
        spriteNumber = new int[spriteNumberAnimation];
        for (int i = 0; i < 8; i++) {
            spriteNumber[i] = 6;
        }
        for (int i = 8; i < 12; i++) {
            spriteNumber[i] = 4;
        }
        spriteNumber[12] = 3;

        images = new BufferedImage[spriteNumberAnimation][];
        spritescale = 3;
    }

    public void loadPath() {
        paths = new String[spriteNumberAnimation];
        paths[0] = "/players/human1/idle/down/d";
        paths[1] = "/players/human1/idle/up/u";
        paths[2] = "/players/human1/idle/left/l";
        paths[3] = "/players/human1/idle/right/r";
        paths[4] = "/players/human1/walk/down/d";
        paths[5] = "/players/human1/walk/up/u";
        paths[6] = "/players/human1/walk/left/l";
        paths[7] = "/players/human1/walk/right/r";
        paths[8] = "/players/human1/hit/down/d";
        paths[9] = "/players/human1/hit/up/u";
        paths[10] = "/players/human1/hit/left/l";
        paths[11] = "/players/human1/hit/right/r";
        paths[12] = "/players/human1/die/";
    }

    public void getImage() {
        for (int indexanimation = 0; indexanimation < spriteNumberAnimation; indexanimation++) {
            images[indexanimation] = new BufferedImage[spriteNumber[indexanimation]];
            for (int i = 0; i < spriteNumber[indexanimation]; i++) {
                try {
                    BufferedImage image = ImageIO.read(getClass().getResourceAsStream(paths[indexanimation] + (i+1) + ".png"));
                    images[indexanimation][i] = image;
                    //System.out.println(paths[indexanimation] + (i+1) + ".png");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void mecanicImage(){
        spriteCounter++;
        if(direction != directionInstant || Animation != AnimationInstant){
            spriteNum = 0;
            spriteCounter = 0;
            directionInstant = direction;
            AnimationInstant = Animation;
            imageInstant = images[direction + Animation * 4][spriteNum];
        }
        else {
            for (int i = 0; i < 4; i++) {
                if (direction == i) {
                    if (spriteCounter > 10 - Animation * 3) {
                        if (spriteNum == spriteNumber[i+Animation * 4] - 1) spriteNum = 0;
                        else spriteNum++;
                        spriteCounter = 0;
                    }
                    imageInstant = images[i+Animation * 4][spriteNum];
                }
            }
        }
    }

    public void update() {
        move();
        mecanicImage();
        setWalking();
    }

}
