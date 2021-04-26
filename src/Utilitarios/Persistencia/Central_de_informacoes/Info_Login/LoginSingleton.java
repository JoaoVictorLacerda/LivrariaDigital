package Utilitarios.Persistencia.Central_de_informacoes.Info_Login;

import Utilitarios.Persistencia.Central_de_informacoes.Usuario.Usuario;

public class LoginSingleton {
    private boolean livreiro;
    private Usuario emailUsuario=null;

    private static LoginSingleton login;
    private LoginSingleton() {

    }

    public static synchronized LoginSingleton getUnicaInstancia(){
        if(login == null){
            login=new LoginSingleton();
        }
        return login;

    }


    public boolean isLivreiro() {
        return livreiro;
    }

    public void setLivreiro(boolean livreiro) {
        this.livreiro = livreiro;
    }


    public Usuario getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(Usuario emailUsuario) {
        this.emailUsuario = emailUsuario;
    }
}
