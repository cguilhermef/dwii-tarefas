/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unilasalle.aulahoje.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 201310383
 */
public class TarefaDAO {
    private Connection connection;
    
    public void adiciona(Tarefa tarefa) 
            throws SQLException, ClassNotFoundException {
        this.connection = new ConnectionFactory().getConnection();
        String query = "" +
                "INSERT INTO tarefa " +
                "(descricao, finalizado, dataFinalizacao) " +
                "values (?,?,?)";
        PreparedStatement statement = this.connection.prepareStatement(query);
        statement.setString(1, tarefa.getDescricao());
        statement.setBoolean(2, tarefa.isFinalizado());
        statement.setString(3, tarefa.getDataFinalizacao());
        statement.execute();
        statement.close();
    }
    
    public List<Tarefa> lista()
        throws SQLException, ClassNotFoundException {
        this.connection = new ConnectionFactory().getConnection();
        String query = "SELECT * FROM tarefa";
        PreparedStatement statement = this.connection.prepareStatement(query);
        ResultSet result = statement.executeQuery();
        List<Tarefa> lista = new ArrayList<>();
        while(result.next()) {
            Tarefa tmp = new Tarefa();
            tmp.setId(result.getLong("id"));
            tmp.setDescricao(result.getString("descricao"));
            tmp.setFinalizado(result.getBoolean("finalizado"));
            tmp.setDataFinalizacao(result.getString("dataFinalizacao"));
            lista.add(tmp);
        }
        result.close();
        statement.close();
        return lista;
    }

    public void remove(Tarefa tarefa) 
        throws SQLException, ClassNotFoundException {
        this.connection = new ConnectionFactory().getConnection();
        String query = "" +
                "DELETE FROM tarefa WHERE id=" + tarefa.getId();
        PreparedStatement statement = connection.prepareStatement(query);
        statement.execute();
        statement.close();
    }
}
