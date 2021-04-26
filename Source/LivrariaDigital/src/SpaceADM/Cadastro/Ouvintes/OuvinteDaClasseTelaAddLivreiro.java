package SpaceADM.Cadastro.Ouvintes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Utilitarios.Criptografia.CriptografiaDeSenha;
import Utilitarios.Persistencia.Central_de_informacoes.Central.CentralDeInformacoes;
import Utilitarios.Persistencia.Central_de_informacoes.Livreiro.Livreiro;
import Utilitarios.Persistencia.PersistenciaSingleton.Persistencia;
import SpaceADM.Cadastro.Tela.TelaAddLivreiro;
import SpaceADM.login.Tela.TelaLoginADM;

public class OuvinteDaClasseTelaAddLivreiro implements ActionListener{
	private TelaAddLivreiro livreiroInfo;

	public OuvinteDaClasseTelaAddLivreiro(TelaAddLivreiro livreiroInfo ) {
		this.livreiroInfo = livreiroInfo;
	}

	public String[] permitirCadastroSe(){
		String[] info = {livreiroInfo.getNome(),livreiroInfo.getEmail(),livreiroInfo.getSenha(),""};

		//info[3] trabalha como um valor booleando.
		//A ideia é recuperar todos os dados do Livreiro em um método simples.
		info[3]= info[0].equals("") || info[1].equals("") || info[2].equals("")?"1":"0";
		info[3]= info[0].split(" ").length<2?"2":info[3];
		return info;
	}
	public void cadastro(){
		String[] info = this.permitirCadastroSe();

		if(info[3].equals("1")){
			this.showMessageDialog("Não deixe campos em branco");
		}else if(info[3].equals("2")){
			this.showMessageDialog("Digite seu nome completo");

		}else if(info[1].contains("@")) {
			Persistencia p = Persistencia.getUnicaInstancia();

			try {
				info[2] = CriptografiaDeSenha.criptografia(info[2]);
				Livreiro livreiro = new Livreiro(info[0], info[1], info[2]);
				CentralDeInformacoes central = new CentralDeInformacoes();
				central.addLivreiro(livreiro);
				central.salvar();

				this.showMessageDialog("Dados Salvos com sucesso");
				livreiroInfo.dispose();
				TelaLoginADM telaLoginADM = new TelaLoginADM();
				telaLoginADM.setVisible(true);
			} catch (Exception e) {
				this.showMessageDialog("Houve um problema ao salvar os dados");
			}

		}else{
			this.showMessageDialog("Digite um email v�lido");
		}
	}



	public void  showMessageDialog(String msg){
		JOptionPane.showMessageDialog(livreiroInfo, msg);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.cadastro();
	}


}
