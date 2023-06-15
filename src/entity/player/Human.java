package entity.player;

import entity.Player;
import main.GPanel;

import javax.imageio.ImageIO;
import java.awt.*;
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
    public void drawlaser(Graphics2D g2) {
        int x1 = xGraphic + (spriteDimX * spritescale)/2, y1 = yGraphic + (spriteDimY * spritescale)/2;

        int x2 = xGraphic + (spriteDimX * spritescale)/2, y2 = yGraphic + (spriteDimY * spritescale)/2;

        switch (directionInstant) {
            case 0:
                x1 += -4;
                y1 += 23;
                x2 += 6;
                y2 += 23;
                break;
            case 1:
                x1 += -4;
                y1 += -4;
                x2 += 6;
                y2 += -4;
                break;
            case 2:
                x1 += -16;
                y1 += 23;
                x2 += -6;
                y2 += 23;
                break;
            case 3:
                x1 += 16;
                y1 += 23;
                x2 += 6;
                y2 += 23;
                break;

        }
        g2.setStroke(new BasicStroke(5));
        g2.setColor(Color.RED);
        g2.drawLine(x1, y1, gp.mouseH.x, gp.mouseH.y);
        g2.drawLine(x2, y2, gp.mouseH.x, gp.mouseH.y);
        g2.setStroke(new BasicStroke(2));
        g2.setColor(Color.YELLOW);
        g2.drawLine(x1, y1, gp.mouseH.x, gp.mouseH.y);
        g2.drawLine(x2, y2, gp.mouseH.x, gp.mouseH.y);
        g2.setStroke(new BasicStroke(0.5F));
        g2.setColor(Color.WHITE);
        g2.drawLine(x1, y1, gp.mouseH.x, gp.mouseH.y);
        g2.drawLine(x2, y2, gp.mouseH.x, gp.mouseH.y);
    }

}
