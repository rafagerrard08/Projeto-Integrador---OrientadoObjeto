import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CategoriaProduto {
    
    private String nome;
    private int idBanco;
    
    public CategoriaProduto( String nome ) {
        this.nome = nome;
    }
}