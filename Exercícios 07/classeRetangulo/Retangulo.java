package classeRetangulo;

public class Retangulo {
    private double largura;
    private double altura;

    // Construtor usa os próprios setters para validar desde a criação
    public Retangulo(double largura, double altura) {
        this.setLargura(largura);
        this.setAltura(altura);
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        if (largura <= 0) {
            System.out.println("Aviso: largura inválida (" + largura + "). Aplicando valor padrão 1.0.");
            this.largura = 1.0;
            return;
        }
        this.largura = largura;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        if (altura <= 0) {
            System.out.println("Aviso: altura inválida (" + altura + "). Aplicando valor padrão 1.0.");
            this.altura = 1.0;
            return;
        }
        this.altura = altura;
    }

    public double calcularArea() {
        return largura * altura;
    }

    public double calcularPerimetro() {
        return 2 * (largura + altura);
    }
}