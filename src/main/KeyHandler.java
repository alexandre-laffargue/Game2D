package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
       int key = e.getKeyCode();
         if(key == KeyEvent.VK_W || key == KeyEvent.VK_Z) {
             upPressed = true;
         }
        if(key == KeyEvent.VK_A || key == KeyEvent.VK_Q) {
            leftPressed = true;
        }
        if(key == KeyEvent.VK_S) {
            downPressed = true;
        }
        if(key == KeyEvent.VK_D) {
            rightPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_W || key == KeyEvent.VK_Z) {
            upPressed = false;
        }
        if(key == KeyEvent.VK_A || key == KeyEvent.VK_Q) {
            leftPressed = false;
        }
        if(key == KeyEvent.VK_S) {
            downPressed = false;
        }
        if(key == KeyEvent.VK_D) {
            rightPressed = false;
        }
    }
}
