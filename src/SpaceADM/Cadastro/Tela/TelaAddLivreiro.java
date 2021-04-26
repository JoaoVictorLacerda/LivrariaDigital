package SpaceADM.Cadastro.Tela;

import java.awt.*;

import javax.swing.*;

import SpaceADM.Cadastro.Ouvintes.OuvinteDaClasseTelaAddLivreiro;
import TelaPadrao.Tela.TelaPadrao;

public class TelaAddLivreiro extends TelaPadrao{

	private final JPanel JP_PAINEL =  new JPanel();
	private JTextField nome;
	private JTextField email;
	private JTextField senha;

	public TelaAddLivreiro() {
		super("Adicionar Livreiro");
		this.addPainel();
		this.addImagemUser();
		this.addFormLabel();
		this.addInputs();
		this.addImgLivraria();
		this.addButton();
		this.setVisible(true);
	}

	public void addPainel() {
		this.JP_PAINEL.setBounds(0, 0, 370, 400);
		this.JP_PAINEL.setBackground(Color.DARK_GRAY);
		this.JP_PAINEL.setLayout(null);
		this.add(JP_PAINEL);
	}

	public void addImagemUser() {
		ImageIcon imagemUser = new ImageIcon(TelaAddLivreiro.class.getResource("/img_ADM/img/userADM.png"));
		JLabel boasVindas = new JLabel();

		boasVindas.setBounds(0, 10, 370, 110);
		boasVindas.setHorizontalAlignment(JLabel.CENTER);
		boasVindas.setIcon(imagemUser);

		this.JP_PAINEL.add(boasVindas);
	}

	public void addFormLabel() {
		JLabel boasVindas = new JLabel("Cadastro do Livreiro",JLabel.CENTER);
		JLabel nome = new JLabel("Nome:",JLabel.RIGHT);
		JLabel email = new JLabel("Email:",JLabel.RIGHT);
		JLabel senha = new JLabel("Senha:",JLabel.RIGHT);
		Font font = new Font("Arial",Font.BOLD,15);

		boasVindas.setBounds(0, 120, 370, 25);
		boasVindas.setFont(new Font("Arial",Font.BOLD,13));
		boasVindas.setForeground(Color.WHITE);
		this.JP_PAINEL.add(boasVindas);


		nome.setBounds(0, 150, 100, 30);
		nome.setFont(font);
		this.JP_PAINEL.add(nome);



		email.setBounds(0, 200, 100, 30);
		email.setFont(font);
		this.JP_PAINEL.add(email);


		senha.setBounds(0, 250, 100, 30);
		senha.setFont(font);
		this.JP_PAINEL.add(senha);


	}

	public void addInputs() {
		this.nome = new JTextField();

		this.email = new JTextField();

		this.senha = new JTextField();

		JSeparator nomeSeparador = new JSeparator();
		JSeparator emaileSeparador = new JSeparator();
		JSeparator senhaSeparador = new JSeparator();


		Font font = new Font("Arial",Font.BOLD,12);

		this.nome.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		this.nome.setBounds(120, 153, 200, 25);
		this.nome.setForeground(new Color(128, 196, 255));
		this.nome.setBorder(null);
		this.nome.setFont(font);
		this.JP_PAINEL.add(nome);

		this.email.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		this.email.setBounds(120, 203, 200, 25);
		this.email.setForeground(new Color(128, 196, 255));
		this.email.setBorder(null);
		this.email.setFont(font);
		this.JP_PAINEL.add(email);

		this.senha.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		this.senha.setBounds(120, 253, 200, 25);
		this.senha.setForeground(new Color(128, 196, 255));
		this.senha.setBorder(null);
		this.senha.setFont(font);
		this.JP_PAINEL.add(senha);

		nomeSeparador.setBounds(115,177,200,100);
		nomeSeparador.setOrientation(JSeparator.HORIZONTAL);
		nomeSeparador.setBackground(Color.WHITE);
		this.JP_PAINEL.add(nomeSeparador);

		emaileSeparador.setBounds(115,227,200,100);
		emaileSeparador.setOrientation(JSeparator.HORIZONTAL);
		emaileSeparador.setBackground(Color.WHITE);
		this.JP_PAINEL.add(emaileSeparador);

		senhaSeparador.setBounds(115,277,200,100);
		senhaSeparador.setOrientation(JSeparator.HORIZONTAL);
		senhaSeparador.setBackground(Color.WHITE);
		this.JP_PAINEL.add(senhaSeparador);
	}

	public void addButton(){
		JButton botao = new JButton("Enviar");
		Font font = new Font("Arial",Font.BOLD,12);
		OuvinteDaClasseTelaAddLivreiro ouvinte = new OuvinteDaClasseTelaAddLivreiro(this);

		botao.addActionListener(ouvinte);
		botao.setBounds(50, 315, 270, 30);
		botao.setIcon(new ImageIcon(TelaAddLivreiro.class.getResource("/img_ADM/img/botao.png")));
		botao.setFont(font);
		botao.setForeground(Color.BLACK);

		this.JP_PAINEL.add(botao);


	}
	public void addImgLivraria() {
		ImageIcon imagem = new  ImageIcon(TelaAddLivreiro.class.getResource("/img_ADM/img/tela1.png"));
		JLabel lbImg = new JLabel();
		
		lbImg.setBounds(370, 0, 330, 400);
		lbImg.setIcon(imagem);
		this.add(lbImg);
	}

	public String getNome() {
		return nome.getText();
	}

	public String getEmail() {
		return email.getText();
	}

	public String getSenha() {
		return senha.getText();
	}


}
