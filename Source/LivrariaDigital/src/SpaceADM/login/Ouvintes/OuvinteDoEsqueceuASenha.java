package SpaceADM.login.Ouvintes;

import SpaceADM.login.EsqueceuASenha.RecuperarSenhaADM;
import SpaceADM.login.Tela.TelaLoginADM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class OuvinteDoEsqueceuASenha implements MouseListener {
    private TelaLoginADM telaLoginADM;

    public OuvinteDoEsqueceuASenha(TelaLoginADM telaLoginADM){
        this.telaLoginADM = telaLoginADM;
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        JLabel label = (JLabel) e.getSource();

        Thread thread = new Thread(() -> {
            try{
                new RecuperarSenhaADM(telaLoginADM,label);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(telaLoginADM,
                        "Houve algum problema","Recuperação de senha",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        thread.start();
        ImageIcon gif = new ImageIcon(OuvinteDoEsqueceuASenha.class.getResource("/img_ADM/load/Book.gif"));
        label.setText("");
        label.setIcon(gif);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JLabel label = (JLabel) e.getSource();
        label.setCursor(new Cursor(Cursor.HAND_CURSOR));
        label.setForeground(new Color(252, 83, 28));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JLabel label = (JLabel) e.getSource();
        label.setForeground(Color.WHITE);

    }
}
