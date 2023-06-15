package world;

import entity.Player;
import main.GPanel;

import java.awt.*;
import java.io.*;

public class Map {

    public int width;
    public int height;
    public Tile[][] tiles;
    final GPanel gp;
    final String EOL = "x";
    final String EOC = "y";

    public Map(String path, GPanel gp) {
        this.gp = gp;
        File file = new File(path);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            try {
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line);
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            String string = stringBuilder.toString();
            loadMap(string);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void loadMap(String string){
        String[] lines = string.split(EOL);
        height = lines.length;
        String[][] codes = new String[height][];
        for(int i = 0; i < height; i++){
            codes[i] = lines[i].split(EOC);
        }
        width = codes[0].length;
        tiles = new Tile[height][width];
        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                TileEntity tEntity = TileEntity.fromCode(codes[j][i]);
                tiles[j][i] = new Tile(tEntity);
            }
        }
    }

    public void draw(Graphics2D g2) {
        Player player = gp.players.get(gp.playerIndex);
        int offsetX = player.xMap - player.xGraphic - (player.spriteDimX * player.spritescale)/2;
        int offsetY = player.yMap - player.yGraphic - (player.spriteDimY * player.spritescale)/2;
        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                int xMap = i * gp.tiLeSize;
                int yMap = j * gp.tiLeSize;
                int xScreen = xMap - offsetX;
                int yScreen = yMap - offsetY;
                if (xMap > player.xMap - gp.screenWidth/2 - gp.tiLeSize &&
                        xMap < player.xMap + gp.screenWidth/2 + gp.tiLeSize &&
                        yMap > player.yMap - gp.screenHeight/2 - gp.tiLeSize &&
                        yMap < player.yMap + gp.screenHeight/2 + gp.tiLeSize){
                    g2.drawImage(tiles[j][i].image,xScreen, yScreen, gp.tiLeSize, gp.tiLeSize, null);
                }
                if (gp.hitbox) {
                    // draw line
                    g2.setColor(Color.black);
                    g2.drawRect(xScreen, yScreen, gp.tiLeSize, gp.tiLeSize);
                    // draw collision
                    if (tiles[j][i].collision) {
                        g2.setColor(Color.RED);
                        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
                        g2.fillRect(xScreen, yScreen, gp.tiLeSize, gp.tiLeSize);
                        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
                    }
                }
            }
        }
    }
}
