package Interfaces.Package_SpaceADM;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public interface ComponentesAddNaTela {
    static final Font FONT = new Font("Arial",Font.BOLD,13);
    static final Color COR_PADRAO = new Color(128, 196, 255);

    public ArrayList<JComponent> getComponentes();
    public ArrayList<String> getInfo();
    public int getMaiorAltura();
    public String getTipo();
}
