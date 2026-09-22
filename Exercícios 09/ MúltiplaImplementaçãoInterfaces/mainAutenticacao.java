public class mainAutenticacao {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("maria", "1234");
        Administrador admin = new Administrador("joao", "admin123", "superadmin");

        System.out.println("Login do usuário: " + usuario.getLogin());
        System.out.println("Usuário autenticado (senha certa): " + usuario.autenticar("1234"));
        System.out.println("Usuário autenticado (senha errada): " + usuario.autenticar("errada"));

        System.out.println("Admin autenticado: " + admin.autenticar("admin123"));
        System.out.println("Admin JSON: " + admin.exportarJSON());
    }
}