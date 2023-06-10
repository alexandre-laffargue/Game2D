package main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Game2D");

        window.setSize( 1024, 768 );
        GPanel gp = new GPanel();
        window.add(gp);

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gp.startGameThread();
    }
}