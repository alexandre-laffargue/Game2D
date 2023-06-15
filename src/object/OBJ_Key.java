package object;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class OBJ_Key extends SuperObject{

    public OBJ_Key() {
        name = "Key";
        setValues();
        getImage();
    }

    public void setValues() {
        spriteNumber = 7;
    }

    public void getImage() {
        images = new BufferedImage[spriteNumber];
        for (int i = 0; i < spriteNumber; i++) {
            try {
                images[i] = ImageIO.read(getClass().getResourceAsStream("/objects/key/" + (i) + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void mecanicImage() {
        spriteCounter++;
        for (int i = 0; i < spriteNumber; i++) {
            if (spriteCounter > 14) {
                if (spriteNum == spriteNumber-1) spriteNum = 0;
                else spriteNum++;
                spriteCounter = 0;
            }
            imageInstant = images[spriteNum];
        }
    }


    public void update() {
        mecanicImage();
    }


}
