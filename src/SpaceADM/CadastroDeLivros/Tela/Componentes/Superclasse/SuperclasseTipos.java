package SpaceADM.CadastroDeLivros.Tela.Componentes.Superclasse;

import javax.swing.*;
import java.awt.*;

public abstract class SuperclasseTipos {
	
    private static final Font FONT = new Font("Arial",Font.BOLD,13);
    private static final Color COR_PADRAO = new Color(128, 196, 255);

    public final JComboBox GENERO = this.addGenero();
    public final JLabel LABEL_GENERO = this.addLabelGenero();

    public String[] getGeneros() {
        return new String[] {""};
    }

    private JComboBox addGenero(){
        JComboBox<String> genero = new JComboBox(getGeneros());
        genero.setBackground(Color.DARK_GRAY);
        genero.setFont(FONT);
        genero.setForeground(COR_PADRAO);
        genero.setBounds(90, 375, 190, 30);

        return genero;

    }

    private JLabel addLabelGenero(){
        JLabel genero = new JLabel("Gênero: ",JLabel.CENTER);
        genero.setBounds(0,375,90,30);
        genero.setFont(FONT);
        return genero;
    }

}
