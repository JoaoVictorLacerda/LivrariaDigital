package Loja.OuvintesLoja.JTable;

import Loja.Tela.DetalhesLivro.TelaDetalhes;
import Loja.Tela.Loja.TelaLoja;
import Utilitarios.Persistencia.Central_de_informacoes.Central.CentralDeInformacoes;
import Utilitarios.Persistencia.Central_de_informacoes.Livro.Superclasse.Livro;
import Utilitarios.Persistencia.PersistenciaSingleton.Persistencia;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class OuvinteDosJTable implements MouseListener {

    private TelaLoja tela;
    public OuvinteDosJTable(TelaLoja tela) {
        this.tela=tela;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getClickCount() == 2){
            JTable cedula = (JTable) e.getSource();
            int i =cedula.getSelectedRow();
            Livro livro = tela.getLivros().get(i);
            this.tela.dispose();
            if(tela.getUser()!=null){
                CentralDeInformacoes central = Persistencia.getUnicaInstancia().recuperar();
                central.getLivros().remove(i);

                int numero = livro.getNumeroDeVisualizacoes();
                livro.setNumeroDeVisualizacoes(numero+1);
                central.addLivro(0,livro);
                central.salvar();
                new TelaDetalhes(livro, tela.getUser());
            }else{
                new TelaDetalhes(livro);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
