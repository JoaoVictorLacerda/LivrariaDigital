package SpaceUSER.Login.EsqueceuASenha;

import Utilitarios.Criptografia.CriptografiaDeSenha;
import Utilitarios.EnvioDeEmail.EnviarEmail;
import Utilitarios.Persistencia.Central_de_informacoes.Usuario.Usuario;
import SpaceUSER.Login.Tela.TelaLoginCliente;
import TelaPadrao.Tela.TelaPadrao;

import javax.swing.*;
import java.awt.*;

public class RecuperarSenhaCliente extends EnviarEmail {
    private TelaLoginCliente telaClientes;
    private JLabel label;
    private String email;
    private String nome;
    private long codigo = System.currentTimeMillis();;
    private Usuario user;


    public RecuperarSenhaCliente(TelaLoginCliente telaClientes, JLabel label){
        this.telaClientes=telaClientes;
        this.label=label;
        label.setForeground(Color.WHITE);
        this.verificaSeExisteEmail();
    }


    public void pedeOCodigo(){

        try {
            label.setIcon(null);
            label.setForeground(Color.WHITE);
            label.setText("Esqueceu a senha?");

            String codigo= this.showInputDialog_QUESTION("Digite o código: ");
            if(codigo.equals(this.getCodigo())){
                this.codigoCorreto();
            }else{
                this.codigoIncorreto();
            }
        } catch (Exception e) {
            this.showMessageDialog_INFORMATION("Houve um erro");
        }
    }
    public void codigoCorreto() throws Exception {
        String novaSenha = this.showInputDialog_QUESTION("Digite sua nova senha: ");
        if(novaSenha==null){
            throw new Exception("Digite algo");
        }
        novaSenha = CriptografiaDeSenha.criptografia(novaSenha);
        user.setSenha(novaSenha);
        central.addUser(user);
        central.salvar();
        this.showMessageDialog_INFORMATION("Senha alterada com sucesso!");

    }
    public void codigoIncorreto(){
        this.showMessageDialog_INFORMATION("Seu código está errado");
    }

    public void gerenciarEnvioDeEmail(){
        String numeroDeRecuperacao = user.getNumeroDeRecuperacao();


        if(numeroDeRecuperacao==null){
            user.setNumeroDeRecuperacao(this.getCodigo());
            central.addUser(user);
            central.salvar();
            this.envioDeEmail();
            this.pedeOCodigo();
        }else{
            String botoes[] ={"Sim","Não"};
            int index = JOptionPane.showOptionDialog(telaClientes,
                    "<html>Já enviamos uma mensagem para este email <br>" +
                    "Desenja reenviar outro código? <html>",
                    TITULO_DAS_JANELAS,
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    botoes,
                    botoes[0]);

            if(index==0){
                this.envioDeEmail();
                user.setNumeroDeRecuperacao(this.getCodigo());
                central.addUser(user);
                central.salvar();
                this.pedeOCodigo();
            }else if(index==1){
                this.codigo=Long.parseLong(user.getNumeroDeRecuperacao());
                this.pedeOCodigo();
            }
        }
    }
    public void iniciaThread(){
        Thread thread = new Thread(() -> {
            this.gerenciarEnvioDeEmail();
        });
        ImageIcon gif = new ImageIcon(RecuperarSenhaCliente.class.getResource("/img_ADM/load/Book.gif"));
        this.label.setText("");
        this.label.setIcon(gif);
        thread.start();

    }
    public void verificaSeExisteEmail(){
        String emailDigitado = this.showInputDialog_QUESTION(
                "<html>Digite seu email<br> para recuperação de senha: <html>");
        if(emailDigitado!=null){
            for(Usuario user: central.getUsuario()){
                if(user.getEmail().equals(emailDigitado)){
                    this.nome= user.getNome();
                    this.email=emailDigitado;
                    this.user=user;
                    break;
                }
            }

        }
        if(user!=null){
            this.iniciaThread();
        }else{
            this.showMessageDialog_INFORMATION("Não existe uma conta com esse email");
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
        return Long.toString(codigo);
    }

    @Override
    public TelaPadrao getTelaDeReferencia() {
        return this.telaClientes;
    }
}
