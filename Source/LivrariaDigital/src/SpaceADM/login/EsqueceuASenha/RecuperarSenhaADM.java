package SpaceADM.login.EsqueceuASenha;
import Utilitarios.Criptografia.CriptografiaDeSenha;
import Utilitarios.EnvioDeEmail.EnviarEmail;
import Utilitarios.Persistencia.Central_de_informacoes.Livreiro.Livreiro;
import SpaceADM.login.Tela.TelaLoginADM;
import TelaPadrao.Tela.TelaPadrao;

import javax.swing.*;
import java.awt.*;

public class RecuperarSenhaADM extends EnviarEmail {

    private static TelaLoginADM telaLoginAdm;
    private static final long CODIGO = System.currentTimeMillis();

    private String email;
    private String nome;
    private Livreiro livreiro = central.getLivreiro();


    public void gerenciarEnvioDeEmail(){
        if(livreiro.getNumeroDeRecuperacao()==null ||
                !livreiro.getNumeroDeRecuperacao().equals(this.getCodigo()) ){
            this.envioDeEmail();
        }
    }

    public void addNumeroDeRecuperacao(String codigo) throws Exception {
        livreiro.setNumeroDeRecuperacao(codigo);
        central.addLivreiro(livreiro);
        central.salvar();

    }

    public void codigoCorreto() throws Exception {
        String senha =this.showInputDialog_QUESTION("Digite sua nova senha: ");


        senha = CriptografiaDeSenha.criptografia(senha);
        livreiro.setSenha(senha);
        central.addLivreiro(livreiro);
        central.salvar();


        this.showMessageDialog_INFORMATION("Senha alterada com sucesso");
    }

    public void codigoIncorreto(){
    	
        this.showMessageDialog_INFORMATION("Seu codigo está errado, tente novamente.");
    }

    public String pegaEmailEscondido(){

        this.email = livreiro.getEmail();
        this.nome =  livreiro.getNome();

        String resultado= email.substring(2,email.indexOf("@"));

        resultado = email.substring(0,2)+
                "*".repeat(resultado.length())+
                email.substring(email.indexOf("@"));


        return resultado;
    }

    public RecuperarSenhaADM(TelaLoginADM telaLoginAdm, JLabel label) throws Exception {
        RecuperarSenhaADM.telaLoginAdm = telaLoginAdm;
        String emailMETHOD = this.pegaEmailEscondido();

        this.gerenciarEnvioDeEmail();
        this.addNumeroDeRecuperacao(Long.toString(CODIGO));

        String resultado = this.showInputDialog_QUESTION(
                "<html>Enviamos um código de recuperação para: <br>"+
                emailMETHOD+
                "<br><br>Digite o código: <html>");
        
      //Saindo da tela de Load do jLabel
        label.setText("Esqueceu sua senha?");
        label.setForeground(Color.WHITE);
        label.setIcon(null);

        String codigoAsString = Long.toString(CODIGO);
        if(resultado.equals(codigoAsString)){
            this.codigoCorreto();
        }else{
            this.codigoIncorreto();
          
        }
      
      

    }

    @Override
    public String getEmailDestino() {
        return this.email;
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public String getCodigo() {
        return Long.toString(CODIGO);
    }

    @Override
    public TelaPadrao getTelaDeReferencia() {
        return telaLoginAdm;
    }

}