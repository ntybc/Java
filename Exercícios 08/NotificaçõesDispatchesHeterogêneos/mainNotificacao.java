public class mainNotificacao {

    // recebe qualquer Notificacao, sem saber qual é a implementação concreta
    public static void processarEnvio(Notificacao notificacao, String texto) {
        notificacao.enviar(texto);
    }

    public static void main(String[] args) {
        processarEnvio(new EmailNotificacao("maria@email.com"), "Sua fatura vence amanhã.");
        processarEnvio(new SmsNotificacao("(21) 99999-0000"), "Seu código de verificação é 4821.");
        processarEnvio(new PushNotificacao("device-A1B2"), "Você tem uma nova mensagem.");
    }
}