package aula02.factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    // string de conexão com o banco de dados
    private static final String URL = "jdbc:mysql://localhost:3306/aula02?useTimezone=true&serverTimezone=UTC&useSSL=false";

    // usuário do banco de dados
    private static final String USER = "root";

    // senha do usuário do banco de dados
    private static final String PASSWORD = "root";

    // método para retornar a conexão aberta com o MySQL..
    public static Connection getConnection() throws Exception {
        // Class.forName("com.mysql.jdbc.Driver"); //necessário somente para versões abaixo do MySql Connector 6.0
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
