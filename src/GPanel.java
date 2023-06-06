import javax.swing.*;
import java.awt.*;

public class GPanel extends JPanel {

    public GPanel() {
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)(g);
        g2.setColor(Color.GREEN);
        g2.fillRect(10, 20 , 50 , 200);

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        int playerX = panelWidth / 2;
        int playerY = panelHeight / 2;

        g.setColor(Color.RED);
        g.fillRect(playerX, playerY, 40, 40);

    }
}
