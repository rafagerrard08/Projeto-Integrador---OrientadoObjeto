/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Thiago Gilabel de Souza 
 */
package br.com.bmrt.conexaobd.entidade;


import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Venda {

    private int id_venda;
    private String vendedor;
    private int id_cliente;
    private int id_loja;
    private int id_produto;
    private double id_valor;
    private String forma_pagamento;
    private String status;
    private double desconto;
    private double valor_final;
    private String data_venda;

    public Venda(int id_venda, String vendedor, int id_cliente, int id_loja, int id_produto, double id_valor, String forma_pagamento,
            String status, double desconto, double valor_final, String data_venda) {
        this.id_venda = id_venda;
        this.vendedor = vendedor;
        this.id_cliente = id_cliente;
        this.id_valor = id_valor;
        this.id_loja = id_loja;
        this.id_produto = id_produto;
        this.forma_pagamento = forma_pagamento;
        this.status = status;
        this.desconto = desconto;
        this.valor_final = valor_final;
        this.data_venda = data_venda;
    }

    

    @Override
    public String toString() {
        return String.format("{\"id_venda\": %d\"vendedor\": %s, <br/> \"id_Cliente\": %d, <br/> \"id_valor\": %f, <br/> \"id_loja\": %d, <br/> \"id_produto\": %d, <br/> \"forma_pagamento\": %s, <br/> \"status\": %s, <br/> \"desconto\": %f, <br/> \"valor_final\":%f,<br/> \"data_venda\": %s}",
                id_venda, vendedor, id_cliente, id_valor, id_loja, id_produto, forma_pagamento, status, desconto, valor_final, data_venda);
    }

}
