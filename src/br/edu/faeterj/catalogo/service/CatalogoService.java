package br.edu.faeterj.catalogo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.edu.faeterj.catalogo.dominio.Produto;

public class CatalogoService {

    // Declarado como List (interface) e instanciado como ArrayList
    private final List<Produto> produtos = new ArrayList<>();

    public void cadastrar(Produto p) {
        if (p == null) {
            throw new IllegalArgumentException("Não é permitido cadastrar produto nulo.");
        }
        if (produtos.contains(p)) {
            throw new IllegalStateException("Já existe produto cadastrado com o código: " + p.getCodigo());
        }
        produtos.add(p);
    }

    public Produto obterPorPosicao(int indice) {
        if (indice < 0 || indice >= produtos.size()) {
            throw new IndexOutOfBoundsException("Posição inválida: " + indice);
        }
        return produtos.get(indice);
    }

    public boolean excluirPorCodigo(String codigo) {
        // removeIf usa o equals da classe Produto (baseado no código)
        return produtos.removeIf(p -> p.getCodigo().equals(codigo));
    }

    public void ordenarPorPreco() {
        Collections.sort(produtos); // usa o compareTo da classe Produto
    }

    public List<Produto> listarTodos() {
        // Cópia defensiva
        return new ArrayList<>(produtos);
    }

    public int getTotalProdutos() {
        return produtos.size();
    }
}