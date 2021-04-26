package SpaceADM.login.Tela;

import java.awt.*;

import javax.swing.*;

import SpaceADM.login.Ouvintes.OuvinteDoEsqueceuASenha;
import SpaceADM.login.Ouvintes.OuvinteLoginButton;
import TelaPadrao.Tela.TelaPadrao;

public class TelaLoginADM extends TelaPadrao {

	private final JPanel JP_PAINEL =  new JPanel();
	private JTextField email;

	private JPasswordField senha;

	public TelaLoginADM() {
		super("Livreiro");
		this.addPainel();
		this.addImagemUser();
		this.addFormLabel();
		this.addInputs();
		this.addButtons();
		this.addBackground();
		this.setVisible(true);
	}

	public void addPainel() {
		this.JP_PAINEL.setBounds(200, 15, 300, 330);
		this.JP_PAINEL.setBackground(Color.DARK_GRAY);
		this.JP_PAINEL.setLayout(null);
		this.add(JP_PAINEL);
	}

	public void addImagemUser() {
		ImageIcon imagemUser = new ImageIcon(TelaLoginADM.class.getResource("/img_ADM/img/userADM.png"));
		JLabel boasVindas = new JLabel();
		boasVindas.setBounds(0, 2, 300, 100);
		boasVindas.setHorizontalAlignment(JLabel.CENTER);
		boasVindas.setIcon(imagemUser);
		this.JP_PAINEL.add(boasVindas);
	}

	public void addFormLabel() {
		JLabel login = new JLabel("Login do Livreiro",JLabel.CENTER);
		JLabel email = new JLabel("E-mail:",JLabel.RIGHT);
		JLabel senha = new JLabel("Senha:",JLabel.RIGHT);
		Font font = new Font("Arial",Font.BOLD,12);

		login.setBounds(0, 105, 300, 30);
		login.setFont(new Font("Arial",Font.BOLD,13));
		login.setForeground(Color.WHITE);
		this.JP_PAINEL.add(login);

		email.setBounds(0, 145, 80, 20);
		email.setFont(font);
		this.JP_PAINEL.add(email);

		senha.setBounds(0, 185, 80, 20);
		senha.setFont(font);
		this.JP_PAINEL.add(senha);


	}
	public void addInputs() {
		this.email = new JTextField();
		this.senha = new JPasswordField();

		Font font = new Font("Arial",Font.BOLD,12);

		JSeparator emailSeparador = new JSeparator();
		JSeparator senhaSeparador = new JSeparator();
		
		email.setBounds(90, 142, 175, 25);
		email.setFont(font);
		email.setForeground(new Color(128, 196, 255));
		email.setBorder(null);
		this.JP_PAINEL.add(email);
		
		senha.setBounds(90, 182, 175, 25);
		senha.setFont(font);
		senha.setForeground(new Color(128, 196, 255));
		senha.setBorder(null);
		this.JP_PAINEL.add(senha);
		
		emailSeparador.setBounds(90,167,170,10);
		emailSeparador.setOrientation(JSeparator.HORIZONTAL);
		emailSeparador.setBackground(Color.WHITE);
		this.JP_PAINEL.add(emailSeparador);
		
		senhaSeparador.setBounds(90,207,170,10);
		senhaSeparador.setOrientation(JSeparator.HORIZONTAL);
		senhaSeparador.setBackground(Color.WHITE);
		this.JP_PAINEL.add(senhaSeparador);


		
	}


	public void addButtons(){
		JButton entrar = new JButton("Entrar");
		OuvinteLoginButton ouvinte = new OuvinteLoginButton(this);
		Font font = new Font("Arial",Font.BOLD,12);


		entrar.addActionListener(ouvinte);
		entrar.setBounds(123, 220, 60, 25);
		entrar.setBackground(new Color(102, 102, 102));
		entrar.setFont(font);
		entrar.setBorder(null);
		this.JP_PAINEL.add(entrar);

		OuvinteDoEsqueceuASenha ouvinteDoEsqueceuASenha = new OuvinteDoEsqueceuASenha(this);
		JLabel esqueceu = new JLabel("Esqueceu a senha?",JLabel.CENTER);
		esqueceu.addMouseListener(ouvinteDoEsqueceuASenha);
		esqueceu.setBounds(0, 257, 300, 30);
		esqueceu.setFont(font);
		this.JP_PAINEL.add(esqueceu);


		JButton soucliente = new JButton("Sou Cliente");
		soucliente.setBounds(100, 300, 100, 25);
		soucliente.setBackground(new Color(102, 102, 102));
		soucliente.setFont(font);
		soucliente.setBorder(null);
		soucliente.addActionListener(ouvinte);



		this.JP_PAINEL.add(soucliente);

	}

	public String getEmail() {
		return email.getText();
	}

	public String getSenha() {
		return senha.getText();
	}
}
