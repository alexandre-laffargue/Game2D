package main;

import entity.Player;
import world.Map;
import world.Tile;
import world.TileEntity;

import javax.swing.*;
import java.awt.*;

public class GPanel extends JPanel implements Runnable{

    public Map map = new Map("res/maptest.txt", this);
    // SCREEN SETTINGS
    public final int tiLeSize = 48;
    public final int maxScreenCol = 32;
    public final int maxScreenRow = 18;
    public final int screenWidth = tiLeSize * maxScreenCol; // 1536 pixels
    public final int screenHeight = tiLeSize * maxScreenRow; // 864 pixels



    public KeyHandler  keyH = new KeyHandler();
    public MouseHandler mouseH = new MouseHandler();
    public Player player = new Player(this);

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
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)(g);

        map.draw(g2);
        player.draw(g2);
        if(keyH.vPressed) drawhitbox(g2);
        if(mouseH.leftPressed) drawlaser(g2);


    }

    public void drawhitbox(Graphics2D g2) {
        g2.setColor(Color.RED);
        g2.drawRect(player.xGraphic, player.yGraphic , tiLeSize, tiLeSize);
    }
    public void drawlaser(Graphics2D g2) {
        g2.setStroke(new BasicStroke(5));
        g2.setColor(Color.RED);
        g2.drawLine(player.xGraphic + tiLeSize/2, player.yGraphic + tiLeSize/2, mouseH.x, mouseH.y);
        g2.setStroke(new BasicStroke(2));
        g2.setColor(Color.YELLOW);
        g2.drawLine(player.xGraphic + tiLeSize/2, player.yGraphic + tiLeSize/2, mouseH.x, mouseH.y);
        g2.setStroke(new BasicStroke(0.5F));
        g2.setColor(Color.WHITE);
        g2.drawLine(player.xGraphic + tiLeSize/2, player.yGraphic + tiLeSize/2, mouseH.x, mouseH.y);
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
    public void update() {
        player.update();
        if(mouseH.leftPressed) {
            int mouseTileX = (player.x - player.xGraphic + mouseH.x)/tiLeSize;
            int mouseTileY = (player.y - player.yGraphic + mouseH.y)/tiLeSize;

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
    }
}
