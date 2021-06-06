package br.com.bmrt.conexaobd.entidade;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Thiago Gilabel de Souza 
 */
@Getter
@Setter
public class Loja {

    private int id_loja;
    private String nome_loja;
    private String tipo_loja;
    private String endereco;
    private String telefone;
    private int id_cliente;

    /**
     *
     * @param id_loja
     * @param nome_loja
     * @param tipo_loja
     * @param endereco
     * @param telefone
     * @param id_cliente
     */
    public Loja(int id_loja, String nome_loja, String tipo_loja, String endereco, String telefone, int id_cliente) {
        this.id_loja = id_loja;
        this.nome_loja = nome_loja;
        this.tipo_loja = tipo_loja;
        this.endereco = endereco;
        this.telefone = telefone;
        this.id_cliente = id_cliente;
    }

    /**
     *
     * @return
     */
    public boolean validarID_LOJA() {
        return true;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return String.format("{\"id_loja\": %d, <br/> \"nome da loja\": %s, <br/> \"tipo\": %s, <br/> \"endereco\": %s, <br/> "
                + "\"telefone\": %s, <br/> \"cliente\": %d, <br/>}",
                id_loja, nome_loja, tipo_loja, endereco, telefone, id_cliente);
    }
}










