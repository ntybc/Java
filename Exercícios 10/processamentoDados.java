import java.io.IOException;

public class processamentoDados {

    static class ProcessamentoDadosException extends Exception {
        public ProcessamentoDadosException(String mensagem, Throwable causa) {
            super(mensagem, causa);
        }
    }

    static class ServicoArquivo {
        public void processarArquivo(String caminho) throws ProcessamentoDadosException {
            try {
                if (caminho == null || caminho.trim().isEmpty()) {
                    throw new IOException("Caminho do arquivo nao pode ser nulo ou vazio.");
                }
                if (caminho.endsWith(".corrupto")) {
                    throw new IllegalArgumentException("Estrutura do arquivo invalida para conversao.");
                }
                System.out.println("Leitura e processamento do arquivo " + caminho + " concluídos.");
            } catch (IOException | IllegalArgumentException e) {
                throw new ProcessamentoDadosException("Falha na camada de negocio ao processar o arquivo.", e);
            }
        }
    }

    public static void main(String[] args) {
        ServicoArquivo servico = new ServicoArquivo();

        System.out.println("TESTE 1: ERRO DE LEITURA (IOEXCEPTION)");
        try {
            servico.processarArquivo("");
        } catch (ProcessamentoDadosException e) {
            System.out.println("Mensagem da Excecao: " + e.getMessage());
            if (e.getCause() != null) {
                System.out.println("Causa: " + e.getCause().getMessage());
                System.out.println("Classe da Causa: " + e.getCause().getClass().getName());
            }
        }

        System.out.println("\nTESTE 2: ERRO DE PARSING (ILLEGALARGUMENTEXCEPTION)");
        try {
            servico.processarArquivo("dados.corrupto");
        } catch (ProcessamentoDadosException e) {
            System.out.println("Mensagem da Excecao: " + e.getMessage());
            if (e.getCause() != null) {
                System.out.println("Causa: " + e.getCause().getMessage());
                System.out.println("Classe da Causa: " + e.getCause().getClass().getName());
            }
        }

        System.out.println("\nPrograma finalizado com sucesso.");
    }
}