package SpaceUSER.Home.Ouvinte;

import Loja.Tela.Loja.TelaLoja;
import SpaceUSER.Home.Tela.TelaHomeUser;
import SpaceUSER.Login.Tela.TelaLoginCliente;
import SpaceUSER.TelaParaColecoes.Tela;
import Utilitarios.Criptografia.CriptografiaDeSenha;
import Utilitarios.Persistencia.Central_de_informacoes.Central.CentralDeInformacoes;
import Utilitarios.Persistencia.Central_de_informacoes.Usuario.Usuario;
import Utilitarios.Persistencia.PersistenciaSingleton.Persistencia;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OuvinteDosJButtons implements ActionListener {
    private TelaHomeUser tela;
    private CentralDeInformacoes central = Persistencia.getUnicaInstancia().recuperar();
    public OuvinteDosJButtons(TelaHomeUser tela){
        this.tela=tela;
    }
    
    public boolean apagarConta() {
    	String mensagem="";
    	try {
    		String senha1 = JOptionPane.showInputDialog(tela, "Digite sua senha: ");
    		String confirmacaoDeSenha =CriptografiaDeSenha.descriptografia(tela.getUser().getSenha());
    		
    		
    		if(senha1.equals(confirmacaoDeSenha)) {
    			int result = JOptionPane.showConfirmDialog(tela,
    					"Essa ação não poderá ser desfeita \n"+"Tem certeza que deseja continuar?",
    					"Apagar User",
    					JOptionPane.YES_NO_OPTION);
    			if(result==0) {
    				for(Usuario u : central.getUsuario()) {
    					if(u.getEmail().equals(tela.getUser().getEmail())) {
    						central.getUsuario().remove(u);
    						central.getLogin().setEmailUsuario(null);
    						central.salvar();
    						break;
    					}
    				}
    				mensagem="Feito!";
    				tela.dispose();
    				new TelaLoginCliente();
    				
    			}
    			
    		}
    		
    	}catch(Exception e) {
    		mensagem="Operação Cancelada";
    		
    	}finally {
    		JOptionPane.showMessageDialog(null, mensagem);
    	}
    	
    	
    	
    	return false;
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
            case"Apagar Conta":
            	this.apagarConta();
            	

        }
    }
}
