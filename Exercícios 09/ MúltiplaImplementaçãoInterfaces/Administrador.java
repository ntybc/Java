public class Administrador implements Autenticavel, ExportavelJSON {
    private String login;
    private String senha;
    private String nivelAcesso;

    public Administrador(String login, String senha, String nivelAcesso) {
        this.login = login;
        this.senha = senha;
        this.nivelAcesso = nivelAcesso;
    }

    @Override
    public boolean autenticar(String senha) {
        return this.senha.equals(senha);
    }

    @Override
    public String exportarJSON() {
        return "{\"login\":\"" + login + "\",\"nivelAcesso\":\"" + nivelAcesso + "\"}";
    }
}