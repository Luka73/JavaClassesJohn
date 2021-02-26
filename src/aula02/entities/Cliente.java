package aula02.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Cliente implements Serializable, Comparable<Cliente> {
    @Serial
    private static final long serialVersionUID = -2021417430024920957L;

    private Integer idCliente;
    private String nome;
    private String cpf;
    private String email;

    public Cliente() {
    }

    public Cliente(Integer idCliente, String nome, String cpf, String email) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(idCliente, cliente.idCliente)
                && Objects.equals(cpf, cliente.cpf)
                && Objects.equals(email, cliente.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCliente);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public int compareTo(Cliente o) {
        return this.idCliente.compareTo(o.getIdCliente());

        /*return Comparator.comparing(Cliente::getIdCliente)
                .thenComparing(Cliente::getNome)
                .compare(this, cliente);*/
    }
}
