package aula02.repositories;

import aula02.contracts.IClienteRepository;
import aula02.entities.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository implements IClienteRepository {

    private Connection connection;

    public ClienteRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Cliente obj) throws Exception {
        String query = "insert into Cliente(nome, cpf, email) values (?,?,?)";
        PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
        statement.setString(1, obj.getNome());
        statement.setString(2, obj.getCpf());
        statement.setString(3, obj.getEmail());
        statement.execute();

        //capturar o id do cliente gerado pelo auto_increment
        ResultSet result = statement.getGeneratedKeys();
        if(result.next()) {
            obj.setIdCliente(result.getInt(1)); //1 -> posição do elemento obtido
        }

        statement.close();
    }

    @Override
    public void update(Cliente obj) throws Exception {
        String query = "update Cliente set nome=?, cpf=?, email=? where idcliente=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, obj.getNome());
        statement.setString(2, obj.getCpf());
        statement.setString(3, obj.getEmail());
        statement.setInt(4, obj.getIdCliente());
        statement.execute();

        statement.close();
    }

    @Override
    public void delete(Integer key) throws Exception {
        String query = "delete from Cliente where idcliente=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, key);
        statement.execute();

        statement.close();

    }

    @Override
    public List<Cliente> findAll() throws Exception {
        String query = "select * from Cliente";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet result = statement.executeQuery();

        List<Cliente> list = new ArrayList<>();

        while(result.next()) {
            Cliente cliente = new Cliente();
            cliente.setIdCliente(result.getInt("idcliente"));
            cliente.setNome(result.getString("nome"));
            cliente.setCpf(result.getString("cpf"));
            cliente.setEmail(result.getString("email"));

            list.add(cliente);

        }

        return list;
    }

    @Override
    public Cliente findById(Integer key) throws Exception {
        String query = "select * from Cliente where idcliente=?";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, key);

        ResultSet result = statement.executeQuery();

        Cliente cliente = null;

        if(result.next()) {
            cliente = new Cliente();
            cliente.setIdCliente(result.getInt("idcliente"));
            cliente.setNome(result.getString("nome"));
            cliente.setCpf(result.getString("cpf"));
            cliente.setEmail(result.getString("email"));
        }

        statement.close();

        return cliente;
    }

    @Override
    public Cliente findByEmail(String email) throws SQLException {
        String query = "select * from Cliente where email=?";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, email);

        ResultSet result = statement.executeQuery();

        Cliente cliente = null;

        if(result.next()) {
            cliente = new Cliente();
            cliente.setIdCliente(result.getInt("idcliente"));
            cliente.setNome(result.getString("nome"));
            cliente.setCpf(result.getString("cpf"));
            cliente.setEmail(result.getString("email"));
        }

        statement.close();

        return cliente;
    }
}
