import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Loja {
    private int id;
    private String nome;
    
    public Loja( int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
