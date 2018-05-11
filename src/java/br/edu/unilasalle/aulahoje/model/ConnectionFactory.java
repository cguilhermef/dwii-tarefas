/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unilasalle.aulahoje.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 201310383
 */
public class ConnectionFactory {
  
  public Connection getConnection() throws ClassNotFoundException {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      return DriverManager.getConnection(
              "jdbc:mysql://127.0.0.1/aulahoje",
              "root",
              "");
    } catch (SQLException exception) {
      throw new RuntimeException(exception);
    }
  }
}
