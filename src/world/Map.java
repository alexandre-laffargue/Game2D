package world;

import entity.Player;
import main.GPanel;

import java.awt.*;
import java.io.*;
import java.util.Arrays;

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

    public Map(int width, int height, GPanel gp) {
        this.gp = gp;
        this.width = width;
        this.height = height;
        tiles = new Tile[height][width];
        // rempli la carte aléatoirement avec les 3 types de tiles
        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                int rand = (int)(Math.random() * 3);
                TileEntity entity = TileEntity.values()[rand];
                String res = entity.getRes();
                tiles[j][i] = new Tile(res, entity.getCode());
            }
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
                String res = tEntity.getRes();
                tiles[j][i] = new Tile(res, tEntity.getCode());
            }
        }
    }

    public void draw(Graphics2D g2) {
        Player player = gp.players.get(0);
        int tmpI = player.x - player.xGraphic,tmpJ = player.y - player.yGraphic;
        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {

                int xWorld = i * gp.tiLeSize;
                int yWorld = j * gp.tiLeSize;
                if (xWorld > player.x - gp.screenWidth/2 - gp.tiLeSize && xWorld < player.x + gp.screenWidth/2 + gp.tiLeSize && yWorld > player.y - gp.screenHeight/2 - gp.tiLeSize && yWorld < player.y + gp.screenHeight/2 + gp.tiLeSize){
                    g2.drawImage(tiles[j][i].image,i * gp.tiLeSize - tmpI, j * gp.tiLeSize - tmpJ, gp.tiLeSize, gp.tiLeSize, null);
                }
                if (gp.keyH.vPressed) {
                    g2.setColor(Color.black);
                    g2.drawRect(i * gp.tiLeSize - tmpI, j * gp.tiLeSize - tmpJ, gp.tiLeSize, gp.tiLeSize);
                }
            }
        }
    }
}
