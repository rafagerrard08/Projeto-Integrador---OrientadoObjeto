import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Venda {
    
    private String nomeVendedor;
    private int id_cliente;
    private int id_loja;
    private int id_produto;
    private double valor;
    private double desconto;
    private int id_formaPagamento;
    private int idBanco;
    
    
    public Venda( String nomeVendedor, int id_cliente, int id_loja, int id_produto, double valor, double desconto,
            int id_formaPagamento ) {
        this.nomeVendedor = nomeVendedor;
        this.id_cliente = id_cliente;
        this.id_loja = id_loja;
        this.id_produto = id_produto;
        this.valor = valor;
        this.desconto = desconto;
        this.id_formaPagamento = id_formaPagamento;   
    }
}