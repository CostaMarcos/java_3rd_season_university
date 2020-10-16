package diagrama;

public class Trabalha {
  private int tempoServico;
  private Fabrica fabrica;
  private Funcionario funcionario;

    public int getTempoServico() {
        return tempoServico;
    }
    
    public void setTempoServico(int tempoServico) {
        this.tempoServico = tempoServico;
    }

    public Fabrica getFabrica() {
        return fabrica;
    }

    public void setFabrica(Fabrica fabrica) {
        this.fabrica = fabrica;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}
