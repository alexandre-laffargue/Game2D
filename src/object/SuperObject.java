package object;

import entity.Player;
import main.GPanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperObject {

    // SPRITES
    public BufferedImage[] images; // [spriteNum]
    public int spriteNumber;
    public int width = 16, height = 16;
    public float spritescale = 1;

    // SPRITE ANIMATION
    public BufferedImage imageInstant;

    public String name;
    public int xMap, yMap;
    public boolean collision = true;
    public Rectangle soldidArea = new Rectangle(0,0,48,48);

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
            g2.drawImage(imageInstant, xScreen, yScreen, (int)(width * gp.scale * spritescale), (int)(height * gp.scale * spritescale), null);
            if (gp.hitbox) {
                g2.setColor(Color.MAGENTA);
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
                g2.fillRect(xScreen + soldidArea.x, yScreen + soldidArea.y, soldidArea.width, soldidArea.height);
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
            }
        }
    }

    public void mecanicImage() {
    }
    public void open() {
    }


    public boolean isopen() {
        return false;
    }
    public void take() {
    }

    public void update() {

    }

}
