import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormasPgto {
    private int id;
    private String nome;
    
    public FormasPgto( int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
