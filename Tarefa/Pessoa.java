package diagrama;

public abstract class Pessoa {
    private String nome;
    
    public Pessoa(){
        super();
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
