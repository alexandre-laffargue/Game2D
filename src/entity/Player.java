package entity;

import main.GPanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity{
    // COORDINATES
    final int xSpawn = 25, ySpawn = 27;

    // SPRITES
    public BufferedImage[][] images; // [direction][spriteNum]
    public int[] spriteNumber; // [direction] 0 = down, 1 = up, 2 = left, 3 = right
    public int spriteNumberAnimation = 0; // number of animation
    public int spriteDimX, spriteDimY, spritescale = 1;


    // SPRITE ANIMATION
    public int spriteCounter = 0;
    public int spriteNum = 0;
    public BufferedImage imageInstant;
    public int directionInstant = 0;
    public int direction = 0; // 0 = down, 1 = up, 2 = left, 3 = right
    public int Animation = 0; // 0 = idle, 1 = walk, 2 = hit, 3 = die
    public int AnimationInstant = 0;


    public Player(GPanel gp) {
        super(gp);
        setSpriteValues();
        setDefaultValues();
    }
    public void setDefaultValues() {
        x = xSpawn * gp.tiLeSize; // pixel on the map
        y = ySpawn * gp.tiLeSize; // pixel on the map
        System.out.println("spriteDimX = " + spriteDimX + " spriteDimY = " + spriteDimY);
        xGraphic = gp.screenWidth/2 - (spriteDimX * spritescale)/2; // pixel on the screen top left corner of the sprite
        yGraphic = gp.screenHeight/2 - (spriteDimY * spritescale)/2; // pixel on the screen top left corner of the sprite
        speed = 5;
    }
    public void setSpriteValues() {
    }
    public void draw(Graphics2D g2) {
        g2.drawImage(imageInstant, xGraphic, yGraphic,gp.tiLeSize * spritescale, gp.tiLeSize * spritescale,  null);
        if (gp.hitbox) {
            g2.setColor(Color.RED);
            g2.drawRect(xGraphic, yGraphic, gp.tiLeSize * spritescale, gp.tiLeSize * spritescale);
        }
    }


    public void drawlaser(Graphics2D g2) {
    }

    public void move() {
        if(gp.keyH.upPressed && !gp.keyH.leftPressed &&  !gp.keyH.rightPressed || gp.keyH.upPressed && gp.keyH.leftPressed &&  gp.keyH.rightPressed) {
            y -= speed;
            direction = 1;
        }
        else if(gp.keyH.downPressed && !gp.keyH.leftPressed &&  !gp.keyH.rightPressed || gp.keyH.downPressed && gp.keyH.leftPressed &&  gp.keyH.rightPressed) {
            y += speed;
            direction = 0;
        }
        else if(gp.keyH.leftPressed && !gp.keyH.upPressed &&  !gp.keyH.downPressed || gp.keyH.leftPressed && gp.keyH.upPressed &&  gp.keyH.downPressed) {
            x -= speed;
            direction = 2;
        }
        else if(gp.keyH.rightPressed && !gp.keyH.upPressed &&  !gp.keyH.downPressed || gp.keyH.rightPressed && gp.keyH.upPressed &&  gp.keyH.downPressed) {
            x += speed;
            direction = 3;
        }
        else if(gp.keyH.upPressed && gp.keyH.leftPressed) {
            y -= speed/Math.sqrt(2);
            x -= speed/Math.sqrt(2);
        }
        else if(gp.keyH.upPressed && gp.keyH.rightPressed) {
            y -= speed/Math.sqrt(2);
            x += speed/Math.sqrt(2);
        }
        else if(gp.keyH.downPressed && gp.keyH.leftPressed) {
            y += speed/Math.sqrt(2);
            x -= speed/Math.sqrt(2);
        }
        else if(gp.keyH.downPressed && gp.keyH.rightPressed) {
            y += speed/Math.sqrt(2);
            x += speed/Math.sqrt(2);
        }
    }
    public void mecanicImage(){
    }
    public void setWalking() {
        if (gp.keyH.upPressed || gp.keyH.downPressed || gp.keyH.leftPressed || gp.keyH.rightPressed) {
            Animation = 1;
        } else {
            Animation = 0;
        }
    }

    public void update() {
    }
}
