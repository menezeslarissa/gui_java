/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Aluno
 */
public class ControlaConexao {
     public static Connection getConnection() throws SQLException {
        return (Connection) DriverManager.getConnection("jdbc:mysql://localhost/helpdesk", "root", "root");
    }

    public static void closeConexao(Connection connection) throws SQLException {

        if (connection != null) {
            connection.close();

        }
    }
}
