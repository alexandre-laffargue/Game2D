package world;

import java.io.*;
import java.util.Arrays;

public class Map {

    public int width;
    public int height;
    public Tile[][] tiles;
    final char EOL = 'x';

    public Map(String path) {
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

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        tiles = new Tile[height][width];
        // rempli la carte aléatoirement avec les 3 types de tiles
        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                int rand = (int)(Math.random() * 3);
                TileEntity entity = TileEntity.values()[rand];
                String res = entity.getRes();
                tiles[j][i] = new Tile(res);
            }
        }
    }

    private void loadMap(String string){
        String[] lines = string.split(String.valueOf(EOL));

        width = lines[0].length();
        height = lines.length;
        tiles = new Tile[height][width];
        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                TileEntity entity = TileEntity.fromCode(lines[j].charAt(i));
                String res = entity.getRes();
                tiles[j][i] = new Tile(res);
            }
        }
    }
}
