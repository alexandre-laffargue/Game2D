package main;

import entity.Player;
import entity.player.EvilEye;
import entity.player.Human;
import item.Item;
import object.OBJ_Chest;
import object.SuperObject;
import world.Map;
import world.Tile;
import world.TileEntity;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GPanel extends JPanel implements Runnable{

    public Map map = new Map("res/maptest.txt", this);
    // SCREEN SETTINGS
    public final int tileSizeOriginal = 16;
    public final int scale = 3;
    public final int tiLeSize = tileSizeOriginal * scale;
    public final int maxScreenCol = 32;
    public final int maxScreenRow = 18;
    public final int screenWidth = tiLeSize * maxScreenCol; // 1536 pixels
    public final int screenHeight = tiLeSize * maxScreenRow; // 864 pixels


    // MECANICS
    public KeyHandler  keyH = new KeyHandler();
    public MouseHandler mouseH = new MouseHandler();
    public CollisionChecker cChecker = new CollisionChecker(this);
    public ArrayList<SuperObject> objects = new ArrayList<SuperObject>();
    public ArrayList<Item> items = new ArrayList<Item>();
    public EvilEye evilEye = new EvilEye(this);
    public Human human = new Human(this);
    public ArrayList<Player> players = new ArrayList<Player>();
    public int playerIndex = 0;

    public AssetSetter aSetter = new AssetSetter(this);

    // VIEW

    public boolean hitbox = false;

    // GAME THREAD
    final int FPS = 60;
    public int drawFPS;
    Thread gameThread;
    public GPanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.addKeyListener(keyH);
        this.addMouseListener(mouseH);
        this.addMouseMotionListener(mouseH);
        this.setFocusable(true);
        setPlayers();
        setupGame();
    }

    public void setupGame() {
        aSetter.setObject();
        aSetter.setItems();
    }

    void setPlayers() {
        players.add(human);
        players.add(evilEye);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)(g);
        // TILE
        map.draw(g2);

        // OBJECT
        for (SuperObject object : objects) {
            object.draw(g2, this);
        }
        // ITEM
        for (Item item : items) {
            item.draw(g2, this);
        }

        // PLAYER
        players.get(playerIndex).draw(g2);

        // OPTION
        setHitBox(g2);

        //
        if(mouseH.leftPressed) players.get(playerIndex).drawlaser(g2);
        if(mouseH.leftPressed) laserTile(players.get(playerIndex), g2);

    }
    public void setHitBox(Graphics2D g2) {
        if(keyH.vPressed) {
            hitbox = !hitbox;
            keyH.vPressed = false;
        }
    }


    @Override
    public void run() {
        double drawInterval = 1000000000/FPS, delta = 0;
        long lastTime = System.nanoTime(), currentTime, timer = 0;
        drawFPS = 0;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta > 1) {
                repaint(); update();
                delta--; drawFPS++;
            }
            if ( timer >= 1000000000 ) {
                //System.out.println(drawFPS + " FPS");
                drawFPS = 0; timer = 0; }
        }
    }

    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();
    }
    public void laserTile(Player player, Graphics2D g2){
        int mouseTileX = (player.xMap - screenWidth/2 + mouseH.x)/tiLeSize;
        int mouseTileY = (player.yMap - screenHeight/2 + mouseH.y)/tiLeSize;
        g2.drawRect(mouseTileX*tiLeSize -(player.xMap + /*gp.tiLeSize/2*/ - player.xGraphic - (player.spriteDimX * player.spritescale)/2), mouseTileY*tiLeSize - (player.yMap + /*gp.tiLeSize/2*/ - player.yGraphic - (player.spriteDimY * player.spritescale)/2) , 5, 5);


        switch (map.tiles[mouseTileY][mouseTileX].code) {
            case "YT":
                map.tiles[mouseTileY][mouseTileX] = new Tile(TileEntity.fromCode("DT").getRes(), "DT");
                break;
            case "RT":
                map.tiles[mouseTileY][mouseTileX] = new Tile(TileEntity.fromCode("DT").getRes(),"DT");
                break;
            case "BT":
                map.tiles[mouseTileY][mouseTileX] = new Tile(TileEntity.fromCode("DT").getRes(),"DT");
                break;
            case "G0":
                map.tiles[mouseTileY][mouseTileX] = new Tile(TileEntity.fromCode("P7").getRes(),"P7");
                break;
        }
    }
    public void update() {
        Player player = players.get(playerIndex);
        player.update();
        for (SuperObject object : objects) {
            object.update();
        }
        for (Item item : items) {
            item.update();
        }
        openChest();

    }

    public void openChest() {
        if (keyH.ePressed) {
            if (!objects.get(2).isopen()) {
                objects.get(2).open();
            }
            else objects.get(2).take();
            keyH.ePressed = false;

        }
    }
}
