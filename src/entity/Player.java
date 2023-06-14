package entity;

import main.GPanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity{
    // COORDINATES
    final double xSpawn = 25, ySpawn = 27;

    // SPRITES
    public BufferedImage[][] images; // [direction][spriteNum]
    public int[] spriteNumber; // [direction] 0 = down, 1 = up, 2 = left, 3 = right
    public int spriteNumberAnimation = 0; // number of animation


    // SPRITE ANIMATION
    public int spriteCounter = 0;
    public int spriteNum = 0;
    public BufferedImage imageInstant;
    public int directionInstant = 0;

    public int Animation = 0; // 0 = idle, 1 = walk, 2 = hit, 3 = die
    public int AnimationInstant = 0;


    public Player(GPanel gp) {
        super(gp);
        setSpriteValues();
        setDefaultValues();
        solidArea = new Rectangle();
        solidArea.x = 20 * gp.scale;
        solidArea.y = 32 * gp.scale;
        solidArea.width = 9 * gp.scale;
        solidArea.height = 9 * gp.scale;
    }
    public void setDefaultValues() {
        x = (int)(xSpawn * gp.tiLeSize); // pixel on the map
        y = (int)(ySpawn * gp.tiLeSize); // pixel on the map
        xGraphic = gp.screenWidth/2 - (spriteDimX * spritescale)/2; // pixel on the screen top left corner of the sprite
        yGraphic = gp.screenHeight/2 - (spriteDimY * spritescale)/2; // pixel on the screen top left corner of the sprite
        speed = 5;
    }
    public void setSpriteValues() {
    }
    public void draw(Graphics2D g2) {
        g2.drawImage(imageInstant, xGraphic, yGraphic,gp.tiLeSize * spritescale, gp.tiLeSize * spritescale,  null);
        //g2.fillRect(xGraphic + (spriteDimX * spritescale)/2 -5, yGraphic + (spriteDimY * spritescale)/2 -5, 10, 10);
        if (gp.hitbox) {
            g2.setColor(Color.RED);
            g2.drawRect(xGraphic, yGraphic, gp.tiLeSize * spritescale, gp.tiLeSize * spritescale);
            // draw solid area
            g2.setColor(Color.BLUE);
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
            g2.fillRect(xGraphic + solidArea.x,yGraphic + solidArea.y, solidArea.width, solidArea.height);
        }
    }


    public void drawlaser(Graphics2D g2) {
    }

    public void move() {
        if(gp.keyH.downPressed && !gp.keyH.leftPressed &&  !gp.keyH.rightPressed || gp.keyH.downPressed && gp.keyH.leftPressed &&  gp.keyH.rightPressed) {
            direction = 0;
            move = true;
        }
        else if(gp.keyH.upPressed && !gp.keyH.leftPressed &&  !gp.keyH.rightPressed || gp.keyH.upPressed && gp.keyH.leftPressed &&  gp.keyH.rightPressed) {
            direction = 1;
            move = true;
        }
        else if(gp.keyH.leftPressed && !gp.keyH.upPressed &&  !gp.keyH.downPressed || gp.keyH.leftPressed && gp.keyH.upPressed &&  gp.keyH.downPressed) {
            direction = 2;
            move = true;
        }
        else if(gp.keyH.rightPressed && !gp.keyH.upPressed &&  !gp.keyH.downPressed || gp.keyH.rightPressed && gp.keyH.upPressed &&  gp.keyH.downPressed) {
            direction = 3;
            move = true;
        }
        else if(gp.keyH.downPressed && gp.keyH.leftPressed) {
            direction = 4;
            move = true;
        }
        else if(gp.keyH.downPressed && gp.keyH.rightPressed) {
            direction = 5;
            move = true;
        }
        else if(gp.keyH.upPressed && gp.keyH.leftPressed) {
            direction = 6;
            move = true;
        }
        else if(gp.keyH.upPressed && gp.keyH.rightPressed) {
            direction = 7;
            move = true;
        }
        else {
            move = false;
        }
        // Check Tile Collision
        collisionOn = false;
        gp.cChecker.checkTile(this);

        // if collision is false, move the player
        if (!collisionOn && move) {

            switch (direction) {
                case 0:
                    y += speed;
                    break;
                case 1:
                    y -= speed;
                    break;
                case 2:
                    x -= speed;
                    break;
                case 3:
                    x += speed;
                    break;
                case 4:
                    y += speed/Math.sqrt(2);
                    x -= speed/Math.sqrt(2);
                    break;
                case 5:
                    y += speed/Math.sqrt(2);
                    x += speed/Math.sqrt(2);
                    break;
                case 6:
                    y -= speed/Math.sqrt(2);
                    x -= speed/Math.sqrt(2);
                    break;
                case 7:
                    y -= speed/Math.sqrt(2);
                    x += speed/Math.sqrt(2);
                    break;
            }
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
