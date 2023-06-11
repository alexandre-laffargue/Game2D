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

    public Tile(String res, String code) {
        this.code = code;
        try {
            image = ImageIO.read(getClass().getResourceAsStream(res));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
