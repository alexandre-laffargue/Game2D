package object;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class OBJ_Chest extends SuperObject{

    public boolean open = false;
    public boolean empty = false;

    public OBJ_Chest() {
        name = "Chest";
        setValues();
        getImage();
    }

    public void setValues() {
        spriteNumber = 3;
    }

    public void getImage() {
        images = new BufferedImage[spriteNumber];
        for (int i = 0; i < spriteNumber; i++) {
            try {
                images[i] = ImageIO.read(getClass().getResourceAsStream("/objects/chest/" + (i) + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void mecanicImage() {
        if(!open) imageInstant = images[0];
        else if(empty) imageInstant = images[2];
        else imageInstant = images[1];
    }

    public void open() {
        open = true;
        System.out.println("Chest open");
    }
    public boolean isopen() {
        System.out.println("Chest taken");
        return open;
    }

    public void take() {
        empty = true;
    }

    public void update() {
        mecanicImage();
    }
}
