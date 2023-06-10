package entity;

import main.GPanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity{

    public int spriteNumberStill = 4, nbImgUp = 0, nbImgDown = 0, nbImgLeft = 0, nbImgRight = 0;
    public BufferedImage imageInstant;
    public Player(GPanel gp) {
        super(gp);
        this.x = 0;
        this.y = 0;
        getImage();
        update();
    }
    public void draw(Graphics2D g2) {
        g2.drawImage(imageInstant, x * gp.tiLeSize, y * gp.tiLeSize,gp.tiLeSize, gp.tiLeSize,  null);
    }

    public void getImage() {
        still = new BufferedImage[spriteNumberStill];
        for (int i = 0; i < spriteNumberStill; i++) {
            try {
                BufferedImage image = ImageIO.read(getClass().getResourceAsStream("/fly_anim_f"+ i +".png"));
                still[i] = image;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void update() {
        imageInstant = still[spriteNum];

        spriteCounter++;
        if(spriteCounter > 10) {
            if(spriteNum == spriteNumberStill-1) spriteNum = 0;
            else spriteNum++;
            spriteCounter = 0;
        }
    }
}
