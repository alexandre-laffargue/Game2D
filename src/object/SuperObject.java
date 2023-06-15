package object;

import entity.Player;
import main.GPanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperObject {

    // SPRITES
    public BufferedImage[] images; // [spriteNum]
    public int spriteNumber;

    // SPRITE ANIMATION
    public int spriteCounter = 0;
    public int spriteNum = 0;
    public BufferedImage imageInstant;

    public String name;
    public boolean collision = false;
    public int xMap, yMap;

    public void draw(Graphics2D g2, GPanel gp) {
        Player player = gp.players.get(gp.playerIndex);
        int offsetX = player.xMap - player.xGraphic - (player.spriteDimX * player.spritescale)/2;
        int offsetY = player.yMap - player.yGraphic - (player.spriteDimY * player.spritescale)/2;
        int xScreen = xMap - offsetX;
        int yScreen = yMap - offsetY;
        if (xMap > player.xMap - gp.screenWidth/2 - gp.tiLeSize &&
                xMap < player.xMap + gp.screenWidth/2 + gp.tiLeSize &&
                yMap > player.yMap - gp.screenHeight/2 - gp.tiLeSize &&
                yMap < player.yMap + gp.screenHeight/2 + gp.tiLeSize) {
            g2.drawImage(imageInstant, xScreen, yScreen, gp.tiLeSize/2, gp.tiLeSize, null);
        }
    }

    public void mecanicImage() {
    }

    public void update() {

    }

}
