package Utilitarios.EnvioDeEmail;

import Interfaces.Package_Utilitarios.EnvioDeEmail;
import Utilitarios.Persistencia.Central_de_informacoes.Central.CentralDeInformacoes;
import Utilitarios.Persistencia.PersistenciaSingleton.Persistencia;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.util.Properties;

public abstract class EnviarEmail implements EnvioDeEmail {
    public final String TITULO_DAS_JANELAS="Recuperação de senha";
    public Persistencia persistencia = Persistencia.getUnicaInstancia();
    public CentralDeInformacoes central = persistencia.recuperar();

    public void envioDeEmail() {
        String senha="EstanteDigital.//0210@#";
        String emailRemetente = "estante.digital2@gmail.com";
        String emailDestino = this.getEmailDestino();
        String assunto = "Recuperação de senha";

        String mensagem = "Olá, "+
                this.getNome()+
                "\nSeu código de recuperação é:\n"+
                this.getCodigo();

        Properties props = new Properties();
        props.put("mail.smtp.user", emailRemetente);
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "25");
        props.put("mail.debug", "false");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.EnableSSL.enable","true");

        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication()
                    {
                        return new PasswordAuthentication(emailRemetente, senha);
                    }
                });

        session.setDebug(false);
        try{
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailRemetente));

            Address[] toUser = InternetAddress.parse(emailDestino);
            message.setRecipients(Message.RecipientType.TO,toUser);
            message.setSubject(assunto);
            message.setText(mensagem);
            Transport.send(message);

        }catch(Exception e){
            JOptionPane.showMessageDialog(this.getTelaDeReferencia(),"Algo deu errado",
                    TITULO_DAS_JANELAS,JOptionPane.INFORMATION_MESSAGE);

        }

    }

    public void showMessageDialog_INFORMATION(String mensagem){
        JOptionPane.showMessageDialog(this.getTelaDeReferencia(),
                mensagem,TITULO_DAS_JANELAS,JOptionPane.INFORMATION_MESSAGE);
    }

    public String showInputDialog_QUESTION(String mensagem){
        return JOptionPane.showInputDialog(this.getTelaDeReferencia(),
                mensagem,TITULO_DAS_JANELAS,JOptionPane.QUESTION_MESSAGE);
    }

}
