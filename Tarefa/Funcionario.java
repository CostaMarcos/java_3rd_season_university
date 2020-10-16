package diagrama;
import java.util.ArrayList;

public class Funcionario extends Pessoa {
    private int matricula;
    private Funcionario supervisor = new Funcionario();
    private ArrayList<Dependente> listaDependente = new ArrayList<Dependente>();
    
    public int getMatricula() {
        return this.matricula;
    }

    public ArrayList getDependente() {
        return this.listaDependente;
    }

    public void setDependente(Dependente dependente) {
        this.listaDependente.add(dependente);
    }

    public void setFuncionario(Funcionario funcionario) {
        this.supervisor = funcionario;
    }

    public Funcionario getFuncionario() {
        return this.supervisor;
    }
}
