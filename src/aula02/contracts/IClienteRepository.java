package aula02.contracts;

import aula02.entities.Cliente;

import java.sql.SQLException;

public interface IClienteRepository extends IBaseRepository<Cliente, Integer> {
    Cliente findByEmail(String email) throws SQLException;
}
