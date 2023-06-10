package world;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Tile {

    public BufferedImage image = null;

    public Tile(String res) {
        try {
            image = ImageIO.read(getClass().getResourceAsStream(res));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
