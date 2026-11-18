// Exercício 3 - Entidade simples de usuário
public class Usuario {

    private Long id;
    private String email;

    public Usuario(Long id, String email) {
        this.id = id;
        this.email = email;
    }

    public Long getId() { return id; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
