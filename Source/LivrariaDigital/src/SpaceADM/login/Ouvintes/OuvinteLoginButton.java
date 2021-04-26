package SpaceADM.login.Ouvintes;


import Interfaces.Package_Space.Login;
import SpaceADM.Home.Tela.TelaHomeADM;
import SpaceADM.login.Tela.TelaLoginADM;
import SpaceUSER.Login.Tela.TelaLoginCliente;
import Utilitarios.Persistencia.Central_de_informacoes.Central.CentralDeInformacoes;
import Utilitarios.Persistencia.Central_de_informacoes.Info_Login.LoginSingleton;
import Utilitarios.Persistencia.Central_de_informacoes.Livreiro.Livreiro;
import Utilitarios.Persistencia.PersistenciaSingleton.Persistencia;
import Utilitarios.Criptografia.CriptografiaDeSenha;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OuvinteLoginButton implements ActionListener, Login {
    private TelaLoginADM telaLoginADM;
    private CentralDeInformacoes central;

    public OuvinteLoginButton(TelaLoginADM telaLoginADM){
        this.telaLoginADM = telaLoginADM;
    }

    public Object isLogin(){
        try {
            Persistencia persistencia = Persistencia.getUnicaInstancia();
            this.central= persistencia.recuperar();
            Livreiro dadosLivreiro = central.getLivreiro();
            String email = dadosLivreiro.getEmail();
            String senha = CriptografiaDeSenha.descriptografia(dadosLivreiro.getSenha());

            return telaLoginADM.getSenha().equals(senha)&&
                    telaLoginADM.getEmail().equals(email);

        } catch (Exception e) {
            return null;
        }
    }

    public void login(){
        boolean condicao = (boolean) this.isLogin();
        if(condicao){
            LoginSingleton loginSingleton = LoginSingleton.getUnicaInstancia();
            loginSingleton.setLivreiro(true);
            central.addLogin(loginSingleton);
            central.salvar();
            telaLoginADM.dispose();
            new TelaHomeADM();
        }else{
            JOptionPane.showMessageDialog(telaLoginADM,"Email ou senha incorreto(s)");
        }



    }


    @Override
    public void actionPerformed(ActionEvent e){
        JButton botao = (JButton) e.getSource();
        String nome = botao.getText();
        if(nome.equals("Entrar")){
            this.login();
        }else{
            telaLoginADM.dispose();
            new TelaLoginCliente();
        }

    }
}