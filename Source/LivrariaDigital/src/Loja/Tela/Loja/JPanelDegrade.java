package Loja.Tela.Loja;

import javax.swing.*;
import java.awt.*;

public class JPanelDegrade extends JPanel {
    private int x1, y1, x2, y2;

    public JPanelDegrade(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }


    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        g2.setPaint(new GradientPaint(x1, y1, new Color(255,255,255, 0),
                x2, y2, new Color(138, 193, 248,250)));

        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.dispose();
    }
}
