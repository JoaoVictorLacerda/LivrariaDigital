package SpaceUSER.Home.Ouvinte;

import Loja.Tela.Loja.TelaLoja;
import SpaceUSER.Home.Tela.TelaHomeUser;
import SpaceUSER.Login.Tela.TelaLoginCliente;
import SpaceUSER.TelaParaColecoes.Tela;
import Utilitarios.Persistencia.Central_de_informacoes.Central.CentralDeInformacoes;
import Utilitarios.Persistencia.PersistenciaSingleton.Persistencia;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OuvinteDosJButtons implements ActionListener {
    private TelaHomeUser tela;

    public OuvinteDosJButtons(TelaHomeUser tela){
        this.tela=tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        switch (button.getText()){
            case"Ir para a loja":
                this.tela.dispose();
                new TelaLoja(tela.getUser());
                break;
            case"Sair":
                this.tela.dispose();
                CentralDeInformacoes central = Persistencia.getUnicaInstancia().recuperar();
                central.getLogin().setEmailUsuario(null);
                central.salvar();
                new TelaLoginCliente();
                break;
            case"Livros comprados":
                this.tela.dispose();
                new Tela(this.tela.getUser(), "Minhas compras");
                break;
            case"Minha coleção":
                this.tela.dispose();
                new Tela(this.tela.getUser(), "Minha coleção");
                break;

        }
    }
}
