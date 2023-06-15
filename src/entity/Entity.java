package entity;

import main.GPanel;

import java.awt.*;

public class Entity {
    public final GPanel gp;
    public int xMap, yMap;
    public Rectangle solidArea;
    public boolean collisionOn = false;
    public boolean move = false;

    // GRAPHICS
    public int xGraphic, yGraphic;

    public int spriteDimX, spriteDimY, spritescale = 1;
    public int direction = 0; // 0 = down, 1 = up, 2 = left, 3 = right, 4 = downleft, 5 = downright, 6 = upleft, 7 = upright

    // STATS
    public int speed;

    public Entity(GPanel gp) {
        this.gp = gp;
    }
}
