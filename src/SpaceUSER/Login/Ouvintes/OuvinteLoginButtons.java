package SpaceUSER.Login.Ouvintes;

import Interfaces.Package_Space.Login;
import SpaceUSER.Home.Tela.TelaHomeUser;
import Utilitarios.Persistencia.Central_de_informacoes.Info_Login.LoginSingleton;
import Utilitarios.Criptografia.CriptografiaDeSenha;
import Utilitarios.Persistencia.Central_de_informacoes.Central.CentralDeInformacoes;
import Utilitarios.Persistencia.PersistenciaSingleton.Persistencia;
import Utilitarios.Persistencia.Central_de_informacoes.Usuario.Usuario;
import SpaceADM.login.Tela.TelaLoginADM;
import SpaceUSER.Login.Tela.TelaLoginCliente;
import SpaceUSER.Cadastro.Tela.TelaCadastroCliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OuvinteLoginButtons implements ActionListener, Login {
    private TelaLoginCliente telaLoginCliente;
    private CentralDeInformacoes central;
    public OuvinteLoginButtons(TelaLoginCliente telaLoginCliente){
        this.telaLoginCliente = telaLoginCliente;

    }
    @Override
    //
    public Usuario isLogin(){
        String email = telaLoginCliente.getEmail();

        String senha = telaLoginCliente.getSenha();

        Persistencia persistencia = Persistencia.getUnicaInstancia();
        central = persistencia.recuperar();

        for(Usuario user: central.getUsuario()){
            if(user.getEmail().equals(email) &&
                    CriptografiaDeSenha.descriptografia(user.getSenha()).equals(senha)){
                return user;

            }
        }
        return null;
    }
    public void login(){
        String mensagem;
        try{
            Usuario user = this.isLogin();
            String email = user.getEmail();
            LoginSingleton login = LoginSingleton.getUnicaInstancia();
            login.setEmailUsuario(user);
            central.addLogin(login);
            central.salvar();
            telaLoginCliente.dispose();
            new TelaHomeUser(user);

        }catch(Exception e){
            mensagem = "Email ou senha incorretos";
            JOptionPane.showMessageDialog(telaLoginCliente,mensagem);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton botao = (JButton) e.getSource();
        String nomeBtn = botao.getText();
        if(!nomeBtn.equals("Entrar")){
            telaLoginCliente.dispose();
        }
        if(nomeBtn.equals("Sou Livreiro")){
            new TelaLoginADM();
        }else if(nomeBtn.equals("Cadastre-se")){
            new TelaCadastroCliente();
        }else{
            this.login();
        }

    }
}