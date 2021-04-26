package SpaceUSER.Login.Ouvintes;

import SpaceUSER.Login.EsqueceuASenha.RecuperarSenhaCliente;
import SpaceUSER.Login.Tela.TelaLoginCliente;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class OuvinteClienteEsqueceuASenha implements MouseListener {

    private TelaLoginCliente tela;

    public OuvinteClienteEsqueceuASenha(TelaLoginCliente tela){
        this.tela=tela;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        JLabel label = (JLabel) e.getSource();
        new RecuperarSenhaCliente(tela,label);

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
