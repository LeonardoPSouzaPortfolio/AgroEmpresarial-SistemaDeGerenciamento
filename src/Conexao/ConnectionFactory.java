package Conexao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Leonardo P Souza
 */
public class ConnectionFactory {
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/agroempresarial?zeroDateTimeBehavior=convertToNull", "root", "1463");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
