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
    public final int spriteDimX = 16, spriteDimY = 16;
    public Player(GPanel gp) {
        super(gp);
        setDefaultValues();
        getImage();
        update();
    }
    public void setDefaultValues() {
        x = 25 * gp.tiLeSize; // pixel on the map
        y = 27 * gp.tiLeSize; // pixel on the map
        xGraphic = gp.screenWidth/2 - spriteDimX/2; // pixel on the screen top left corner of the sprite
        yGraphic = gp.screenHeight/2 - spriteDimY/2; // pixel on the screen top left corner of the sprite
        speed = 5;
    }
    public void draw(Graphics2D g2) {
        g2.drawImage(imageInstant, xGraphic, yGraphic,gp.tiLeSize, gp.tiLeSize,  null);
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
        // déplace le joueur de la meme distance que la vitesse dans toutes les directions et en diagonales sans qu'il aille plus vite en diagonales
        if(gp.keyH.upPressed && !gp.keyH.leftPressed &&  !gp.keyH.rightPressed) {
            y -= speed;
        }
        if(gp.keyH.downPressed && !gp.keyH.leftPressed &&  !gp.keyH.rightPressed) {
            y += speed;
        }
        if(gp.keyH.leftPressed && !gp.keyH.upPressed &&  !gp.keyH.downPressed) {
            x -= speed;
        }
        if(gp.keyH.rightPressed && !gp.keyH.upPressed &&  !gp.keyH.downPressed) {
            x += speed;
        }
        if(gp.keyH.upPressed && gp.keyH.leftPressed) {
            y -= speed/Math.sqrt(2);
            x -= speed/Math.sqrt(2);
        }
        if(gp.keyH.upPressed && gp.keyH.rightPressed) {
            y -= speed/Math.sqrt(2);
            x += speed/Math.sqrt(2);
        }
        if(gp.keyH.downPressed && gp.keyH.leftPressed) {
            y += speed/Math.sqrt(2);
            x -= speed/Math.sqrt(2);
        }
        if(gp.keyH.downPressed && gp.keyH.rightPressed) {
            y += speed/Math.sqrt(2);
            x += speed/Math.sqrt(2);
        }



        spriteCounter++;
        if(spriteCounter > 10) {
            if(spriteNum == spriteNumberStill-1) spriteNum = 0;
            else spriteNum++;
            spriteCounter = 0;
        }
    }
}
