package aula02.principal;

import aula02.contracts.IClienteRepository;
import aula02.entities.Cliente;
import aula02.factories.ConnectionFactory;
import aula02.repositories.ClienteRepository;

public class Main {
    public static void main(String[] args) {

        IClienteRepository clienteRepository;

        try {
            clienteRepository = new ClienteRepository(ConnectionFactory.getConnection());
            Cliente clienteIn = new Cliente(null, "Ana", "123.456.789-00", "ana@gmail.com");
            clienteRepository.create(clienteIn);

            System.out.println("Cliente cadastrado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro: " + e.getMessage());
        }

    }
}
