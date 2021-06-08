import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Produto {

    private int id_produto;
    private int id_loja;
    private String nome_loja;
    private String nome;
    private int qtd_produto;
    private double valor;
    private String categoria;
    private String cor;
    private String marca;
    private int id_categoria;
    
    public Produto( int id_loja, String nome, int qtd_produto, Double valor, int id_categoria, String cor, String marca) {
        this.id_loja = id_loja;
        this.nome = nome;
        this.qtd_produto = qtd_produto;
        this.valor = valor;
        this.id_categoria = id_categoria;
        this.cor = cor;
        this.marca = marca;
    }

    public boolean validarID_PRODUTO() {
        return true;
    }

    @Override
    public String toString() {
        return String.format("{\"id_produto\": %d, <br/> \"id_loja\": %d, <br/> \"nome\": %s, <br/> \"qtd_produto\": %d, <br/> \"valor\": %f, <br/> "
                + "\"categoria\": %s, <br/> \"cor\": %s, <br/> \"marca\": %s}",
                id_produto, id_loja, nome, qtd_produto, valor, categoria, cor, marca);
    }
}

