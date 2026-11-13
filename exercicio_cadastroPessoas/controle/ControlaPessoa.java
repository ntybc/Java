package controle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import dominio.Pessoa;

public class ControlaPessoa {

    private ArrayList<Pessoa> pessoas;
    private final String ARQUIVO = "pessoas.txt";

    public ControlaPessoa() {
        this.pessoas = new ArrayList<>();
        carregarDoArquivo(); // Carrega os dados ao iniciar o programa
    }

    public void adicionarPessoa(int id, String nome, int idade, double altura) {
        // Verifica se o ID já existe
        if (buscarPessoaPorId(id) != null) {
            System.out.println("Erro: Já existe uma pessoa com o ID " + id);
            return;
        }

        Pessoa pessoa = new Pessoa(id, nome, idade, altura);
        pessoas.add(pessoa);
        salvarNoArquivo();
        System.out.println("Pessoa adicionada com sucesso!");
    }

    public void listarPessoas() {
        if (pessoas.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada.");
        } else {
            System.out.println("\n=== Lista de Pessoas ===");
            for (Pessoa pessoa : pessoas) {
                pessoa.listarPessoa();
            }
        }
    }

    public void alterarPessoa(int id, Scanner scanner) {
        Pessoa pessoa = buscarPessoaPorId(id);

        if (pessoa != null) {
            System.out.print("Novo nome: ");
            String novoNome = scanner.nextLine();

            System.out.print("Nova idade: ");
            int novaIdade = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Nova altura: ");
            double novaAltura = scanner.nextDouble();
            scanner.nextLine();

            pessoa.setNome(novoNome);
            pessoa.setIdade(novaIdade);
            pessoa.setAltura(novaAltura);

            salvarNoArquivo();
            System.out.println("Pessoa alterada com sucesso!");
        } else {
            System.out.println("Pessoa com ID " + id + " não encontrada.");
        }
    }

    public void excluirPessoa(int id) {
        Pessoa pessoa = buscarPessoaPorId(id);

        if (pessoa != null) {
            pessoas.remove(pessoa);
            salvarNoArquivo();
            System.out.println("Pessoa excluída com sucesso!");
        } else {
            System.out.println("Pessoa com ID " + id + " não encontrada.");
        }
    }

    private Pessoa buscarPessoaPorId(int id) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getId() == id) {
                return pessoa;
            }
        }
        return null;
    }


    private void salvarNoArquivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO))) {
            for (Pessoa pessoa : pessoas) {
                writer.write(pessoa.toCSV());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar no arquivo: " + e.getMessage());
        }
    }

    private void carregarDoArquivo() {
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length == 4) {
                    int id = Integer.parseInt(dados[0]);
                    String nome = dados[1];
                    int idade = Integer.parseInt(dados[2]);
                    double altura = Double.parseDouble(dados[3]);

                    pessoas.add(new Pessoa(id, nome, idade, altura));
                }
            }
        } catch (IOException e) {
            // Arquivo ainda não existe (primeira execução) - não precisa fazer nada
            System.out.println("Arquivo não encontrado. Será criado ao salvar a primeira pessoa.");
        } catch (NumberFormatException e) {
            System.out.println("Erro ao ler dados do arquivo: formato inválido.");
        }
    }

    //Menu principal

    public static void main(String[] args) {
        ControlaPessoa controle = new ControlaPessoa();
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        do {
            try {
                System.out.println("\n===== Cadastro de Pessoas =====");
                System.out.println("1. Adicionar Pessoa");
                System.out.println("2. Listar Pessoas");
                System.out.println("3. Alterar Pessoa");
                System.out.println("4. Excluir Pessoa");
                System.out.println("0. Sair");
                System.out.print("Escolha uma opção: ");

                opcao = scanner.nextInt();
                scanner.nextLine(); // limpa o buffer

                switch (opcao) {
                    case 1:
                        System.out.print("ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();

                        System.out.print("Idade: ");
                        int idade = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Altura (ex: 1.75): ");
                        double altura = scanner.nextDouble();
                        scanner.nextLine();

                        controle.adicionarPessoa(id, nome, idade, altura);
                        break;

                    case 2:
                        controle.listarPessoas();
                        break;

                    case 3:
                        System.out.print("ID da pessoa a alterar: ");
                        int idAlterar = scanner.nextInt();
                        scanner.nextLine();
                        controle.alterarPessoa(idAlterar, scanner);
                        break;

                    case 4:
                        System.out.print("ID da pessoa a excluir: ");
                        int idExcluir = scanner.nextInt();
                        scanner.nextLine();
                        controle.excluirPessoa(idExcluir);
                        break;

                    case 0:
                        System.out.println("Encerrando o programa...");
                        break;

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }

            } catch (Exception e) {
                System.out.println("Erro de entrada: digite os dados corretamente.");
                scanner.nextLine(); // limpa o buffer em caso de erro
            }

        } while (opcao != 0);

        scanner.close();
    }
}