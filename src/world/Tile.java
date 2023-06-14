package world;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Tile {

    public BufferedImage image = null;
    public final String code;
    public boolean isTree = false;
    public boolean collision = false;
    public boolean isWater = false;
    public boolean isDoor = false;
    public boolean isBreakable = false;
    public boolean isBroken = false;

    public Tile(TileEntity tEntity) {
        this.code = tEntity.getCode();
        this.collision = tEntity.isCollision();
        try {
            image = ImageIO.read(getClass().getResourceAsStream(tEntity.getRes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Tile(String res, String code) {
        this.code = code;
        try {
            image = ImageIO.read(getClass().getResourceAsStream(res));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
