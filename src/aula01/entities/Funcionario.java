package aula01.entities;

import aula01.enums.TipoContratacao;

import java.io.Serializable;

public class Funcionario implements Serializable {

    private static final long serialVersionUID = 8731115070563803034L;

    private Integer idFuncionario;
    private String nome;
    private String matricula;
    private TipoContratacao tipoContratacao;
    private Empresa empresa;

    public Funcionario() {
    }

    public Funcionario(Integer idFuncionario, String nome, String matricula, TipoContratacao tipoContratacao) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.matricula = matricula;
        this.tipoContratacao = tipoContratacao;
    }

    public Funcionario(Integer idFuncionario, String nome, String matricula, TipoContratacao tipoContratacao, Empresa empresa) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.matricula = matricula;
        this.tipoContratacao = tipoContratacao;
        this.empresa = empresa;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public TipoContratacao getTipoContratacao() {
        return tipoContratacao;
    }

    public void setTipoContratacao(TipoContratacao tipoContratacao) {
        this.tipoContratacao = tipoContratacao;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "Funcionario [idFuncionario=" + idFuncionario + ", nome=" + nome + ", matricula=" + matricula
                + ", tipoContratacao=" + tipoContratacao + "]";
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Funcionario) {
            Funcionario funcionario = (Funcionario) obj;
            return this.idFuncionario.equals(funcionario.getIdFuncionario());
        }

        return false;
    }

    @Override
    public int hashCode() {
        return this.idFuncionario.hashCode();
    }
}
