/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postgressql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author nafees
 */
public class JdbcConnection {

    private String url = "jdbc:postgresql://localhost/test";
    private String user = "postgres";
    private String password = "admin";

    public Connection connection() throws ClassNotFoundException {
        Class.forName("org. postgresql. Driver");
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("connection successfull");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return conn;
    }

    public void dataInsert(String line[]) throws SQLException, Exception {
        try {
            JdbcConnection conn = new JdbcConnection();
            Connection connection = conn.connection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into BioData values(?,?,?)");
            String name = line[0];
            String age = line[1];
            String qua = line[2];
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, age);
            preparedStatement.setString(3, qua);
            preparedStatement.execute();
            System.out.println("done");

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
