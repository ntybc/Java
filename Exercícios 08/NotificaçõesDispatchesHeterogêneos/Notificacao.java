public class Notificacao {
    private String destinatario;

    public Notificacao(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void enviar(String mensagem) {
        System.out.println("Enviando notificação para " + destinatario + ": " + mensagem);
    }
}