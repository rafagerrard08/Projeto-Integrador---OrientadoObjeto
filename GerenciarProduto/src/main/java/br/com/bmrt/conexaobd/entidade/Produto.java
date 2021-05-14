package br.com.bmrt.conexaobd.entidade;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author rafaelFerraz
 */
@Getter
@Setter
public class Produto {

    private int id_produto;
    private int id_loja;
    private String nome;
    private int qtd_produto;
    private double valor;
    private String categoria;
    private String cor;
    private String marca;

    /**
     *
     * @param id_produto
     * @param id_loja
     * @param nome
     * @param qtd_produto
     * @param valor
     * @param categoria
     * @param cor
     * @param marca
     */
    public Produto(int id_produto, int id_loja, String nome, int qtd_produto, Double valor, String categoria, String cor, String marca) {
        this.id_produto = id_produto;
        this.id_loja = id_loja;
        this.nome = nome;
        this.qtd_produto = qtd_produto;
        this.valor = valor;
        this.categoria = categoria;
        this.cor = cor;
        this.marca = marca;
    }

    /**
     *
     * @return
     */
    public boolean validarID_PRODUTO() {
        return true;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return String.format("{\"id_produto\": %d, <br/> \"id_loja\": %d, <br/> \"nome\": %s, <br/> \"qtd_produto\": %d, <br/> \"valor\": %f, <br/> "
                + "\"categoria\": %s, <br/> \"cor\": %s, <br/> \"marca\": %s}",
                id_produto, id_loja, nome, qtd_produto, valor, categoria, cor, marca);
    }
}










