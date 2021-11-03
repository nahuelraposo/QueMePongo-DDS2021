package models.notificador;

import models.notificador.services.JavaMailService;

  public class MailSender implements Notificador {
    JavaMailService javaMail;

    public MailSender(JavaMailService javaMail) {
      this.javaMail = javaMail;
    }

    public void notificar(String mailDestino, String mensaje) {
        this.enviarMail(mailDestino,"bla bla", mensaje);
    }

    private void enviarMail(String destinatario, String asunto, String cuerpo) {
      javaMail.sendEmail(destinatario, asunto, cuerpo);
    }

  }

