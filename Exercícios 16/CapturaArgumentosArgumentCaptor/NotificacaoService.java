// Exercício 4 - Código de produção que monta a mensagem e manda para o EmailSender
public class NotificacaoService {

    private final EmailSender emailSender;

    public NotificacaoService(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void notificarBoasVindas(String nome, String email) {
        String assunto = "Bem-vindo à Plataforma!";
        String corpo = "Olá, " + nome + "! Seu cadastro foi concluído com sucesso.";
        emailSender.enviar(email, assunto, corpo);
    }
}
