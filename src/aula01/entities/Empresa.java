package aula01.entities;

import java.io.Serializable;
import java.util.List;

public class Empresa implements Serializable {

    private static final long serialVersionUID = 3968156047250410390L;

    private Integer idEmpresa;
    private String razaoSocial;
    private String cnpj;
    private List<Funcionario> funcionarios;

    public Empresa() {
    }

    public Empresa(Integer idEmpresa, String razaoSocial, String cnpj) {
        this.idEmpresa = idEmpresa;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
    }

    public Empresa(Integer idEmpresa, String razaoSocial, String cnpj, List<Funcionario> funcionarios) {
        this.idEmpresa = idEmpresa;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.funcionarios = funcionarios;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    @Override
    public String toString() {
        return "Empresa [idEmpresa=" + idEmpresa + ", razaoSocial=" + razaoSocial + ", cnpj= "+ cnpj + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Empresa) {
            Empresa empresa = (Empresa) obj;
            return this.idEmpresa.equals(empresa.getIdEmpresa());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return idEmpresa.hashCode();
    }
}
