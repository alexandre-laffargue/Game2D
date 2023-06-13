package entity.player;

import entity.Player;
import main.GPanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class EvilEye extends Player {
    final String path = "/players/evilEye/fly_anim_f";

    public EvilEye(GPanel gp) {
        super(gp);
        getImage();
        update();
    }
    public void setSpriteValues() {
        spriteDimX = 16;
        spriteDimY = 16;
        spriteNumberAnimation = 1; // 1 animation
        spriteNumber = new int[spriteNumberAnimation];
        spriteNumber[0] = 4; // [0] = down, [1] = up, [2] = left, [3] = right
        images = new BufferedImage[1][spriteNumber[0]];
    }

    public void getImage() {
        images[0] = new BufferedImage[spriteNumber[0]];
        for (int i = 0; i < spriteNumber[0]; i++) {
            try {
                BufferedImage image = ImageIO.read(getClass().getResourceAsStream(path + i +".png"));
                images[0][i] = image;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void mecanicImage(){
        spriteCounter++;
        if(spriteCounter > 10) {
            if(spriteNum == spriteNumber[0]-1) spriteNum = 0;
            else spriteNum++;
            spriteCounter = 0;
        }
    }

    public void drawlaser(Graphics2D g2) {
        g2.setStroke(new BasicStroke(5));
        g2.setColor(Color.RED);
        g2.drawLine(xGraphic + gp.tiLeSize/2, yGraphic + gp.tiLeSize/2, gp.mouseH.x, gp.mouseH.y);
        g2.setStroke(new BasicStroke(2));
        g2.setColor(Color.YELLOW);
        g2.drawLine(xGraphic + gp.tiLeSize/2, yGraphic + gp.tiLeSize/2, gp.mouseH.x, gp.mouseH.y);
        g2.setStroke(new BasicStroke(0.5F));
        g2.setColor(Color.WHITE);
        g2.drawLine(xGraphic + gp.tiLeSize/2, yGraphic + gp.tiLeSize/2, gp.mouseH.x, gp.mouseH.y);
    }

    public void update() {
        imageInstant = images[0][spriteNum];
        move();
        mecanicImage();
        setWalking();
    }
}
