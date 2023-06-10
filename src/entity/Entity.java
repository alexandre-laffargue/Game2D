package entity;

import main.GPanel;

import java.awt.image.BufferedImage;

public class Entity {
    public int x, y;
    public int xGraphic, yGraphic;
    public int speed;
    final GPanel gp;
    public BufferedImage[] still, up, down, left, right;
    public int spriteCounter = 0;
    public int spriteNum = 0;

    public Entity(GPanel gp) {
        this.gp = gp;
    }
}
