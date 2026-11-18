// Exercício 4 - Interface de envio de e-mail (no teste vira mock, nenhum e-mail é enviado)
public interface EmailSender {
    void enviar(String destinatario, String assunto, String corpo);
}
