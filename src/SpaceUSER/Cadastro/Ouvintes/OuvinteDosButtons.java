package SpaceUSER.Cadastro.Ouvintes;


import SpaceUSER.Cadastro.Tela.TelaCadastroCliente;
import SpaceUSER.Login.Tela.TelaLoginCliente;
import Utilitarios.Persistencia.Central_de_informacoes.Central.CentralDeInformacoes;
import Utilitarios.Persistencia.PersistenciaSingleton.Persistencia;
import Utilitarios.Persistencia.Central_de_informacoes.Usuario.Usuario;
import Utilitarios.Criptografia.CriptografiaDeSenha;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class OuvinteDosButtons implements ActionListener {
    //Comece lendo o código do final
    private static final Persistencia persistencia = Persistencia.getUnicaInstancia();
    private static final CentralDeInformacoes central = persistencia.recuperar();
    private final TelaCadastroCliente telaCadastroCliente;


    public OuvinteDosButtons(TelaCadastroCliente telaCadastroCliente){
        this.telaCadastroCliente=telaCadastroCliente;
    }

    private void fechaJanela(){
        telaCadastroCliente.dispose();
        new TelaLoginCliente();
    }



    public String[] verificaSeHaCamposEmBranco(){
        String[] info = {telaCadastroCliente.getNome(),
                telaCadastroCliente.getEmail(),
                telaCadastroCliente.getSenha(),
                "",
                telaCadastroCliente.getData(),
        (String)telaCadastroCliente.getGenero1().getSelectedItem(),
        (String)telaCadastroCliente.getGenero2().getSelectedItem(),
        (String)telaCadastroCliente.getGenero3().getSelectedItem(), ""};

        JRadioButton masculino = telaCadastroCliente.getRB_MASCULINO();
        JRadioButton feminino = telaCadastroCliente.getRB_FEMININO();

        if(masculino.isSelected()){
            info[3]="Masculino";
        }else if(feminino.isSelected()){
            info[3]="Feminino";
        }
        info[8]= info[0].equals("") || info[1].equals("") ||
                info[2].equals("")  || info[3].equals("") ||
                info[4].equals("")  || info[5].equals(".")||
                info[6].equals(".") || info[7].equals(".")?"1":"0";

        return info;
    }

    public void dataIsValida() throws Exception {
        String data =telaCadastroCliente.getData();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        formato.setLenient(false);
        try{
            Date hoje = new Date();
            Date dataObject = formato.parse(data);
            if(dataObject.after(hoje)){
                throw new Exception("Informe uma data válida");
            }

        }catch(Exception e){
            throw new Exception("Informe uma data válida");
        }

    }

    public String[] permitirCadastroSe() throws Exception {
        String[] info = this.verificaSeHaCamposEmBranco();

        if(!info[8].equals("1")){

            if(info[1].contains("@")) {
                ArrayList<Usuario> usuarios=central.getUsuario();
                for (Usuario user : usuarios) {
                    if (user.getEmail().equals(info[1])) {
                        throw new Exception("Esse email ja está cadastrado");
                    }
                }
                return info;

            }
            throw new Exception("Insira um email válido");
        }else{
            throw new Exception("Preencha todos os campos");
        }
    }

    public void cadastroDeClientes() throws Exception {
        String[] info= this.permitirCadastroSe();
        info[2]= CriptografiaDeSenha.criptografia(info[2]);

        this.dataIsValida();
        Usuario user = new Usuario(info[0], info[1], info[2],info[3],info[4], info[5], info[6], info[7]);
        central.addUser(user);
        central.salvar();
        this.showMessageDialog("Cadastro realizado com sucesso!");
        this.fechaJanela();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton botao =(JButton) e.getSource();
        try {
            if(botao.getText().equals("Enviar")){
                this.cadastroDeClientes();

            }else{
                this.fechaJanela();
            }
        } catch (Exception ex) {
            this.showMessageDialog(ex.getMessage());
        }
    }

    public void showMessageDialog(String msg){
        JOptionPane.showMessageDialog(telaCadastroCliente,msg);

    }
}
