package main;

import entity.Player;
import world.Map;

import javax.swing.*;
import java.awt.*;

public class GPanel extends JPanel implements Runnable{

    Map map;
    public int tiLeSize = 48;

    public KeyHandler  keyH = new KeyHandler();
    Player player = new Player(this);

    final int FPS = 60;
    public int drawFPS;
    Thread gameThread;
    public GPanel() {
        map = new Map(50, 50);
        //map = new world.Map("res/map.txt");
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)(g);

        paintMap(g2);
        player.draw(g2);
        player.update();


    }

    public void paintMap(Graphics2D g2){

        for (int j = 0; j < map.height; j++) {
            for (int i = 0; i < map.width; i++) {
                g2.drawImage(map.tiles[j][i].image, i * tiLeSize, j * tiLeSize, tiLeSize, tiLeSize, null);
            }
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
            if ( timer >= 1000000000 ) { System.out.println(drawFPS + " FPS"); drawFPS = 0; timer = 0; }
        }
    }

    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();
    }
    public void update() {

        //player.x+= 1;
    }
}
