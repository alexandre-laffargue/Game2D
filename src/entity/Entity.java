package entity;

import main.GPanel;

import java.awt.image.BufferedImage;

public class Entity {
    public final GPanel gp;
    public int x, y;
    public int xGraphic, yGraphic;

    // STATS
    public int speed;

    public Entity(GPanel gp) {
        this.gp = gp;
    }
}
