package diagrama;
import java.util.ArrayList;

public class Fabrica {

    private int cnpj;
    private String razaoSocial;

    private ArrayList<Departamento> listaDepartamento = new ArrayList<Departamento>();

    public ArrayList<Departamento> getListaDepartamento() {
        return this.listaDepartamento;
    }
    
    public void adicionarDepartamento(Departamento departamento ) {
        this.listaDepartamento.add(departamento);
    }

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
}
