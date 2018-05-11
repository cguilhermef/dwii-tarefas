/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unilasalle.aulahoje.controller;

import br.edu.unilasalle.aulahoje.model.TarefaDAO;
import br.edu.unilasalle.aulahoje.model.Tarefa;
import java.sql.SQLException;
import java.util.List;
import javax.management.RuntimeErrorException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author 201310383
 */
@Controller
public class TarefasController {

    @RequestMapping("adicionaTarefa")
    public String adiciona(Tarefa tarefa) {
        try {
            TarefaDAO dao = new TarefaDAO();
            dao.adiciona(tarefa);
            return "tarefa/adicionada";
        } catch (ClassNotFoundException | SQLException exception) {
            throw new RuntimeException(exception);
        }
    }
    
    @RequestMapping("novaTarefa")
    public String form() {        
        return "tarefa/formulario";
    }
    
    @RequestMapping("listaTarefa")
    public String lista(Model model) throws ClassCastException, SQLException {
        TarefaDAO dao = new TarefaDAO();        
        try {
            List<Tarefa> tarefas = dao.lista();
            model.addAttribute("tarefas", tarefas);
            return "tarefa/lista";
        } catch (ClassNotFoundException | SQLException exception) {
            throw new RuntimeException(exception);
        }
        
    }
    
    @RequestMapping("removeTarefa")
    public String remove(Tarefa tarefa) 
        throws SQLException, ClassNotFoundException
    { 
        TarefaDAO dao = new TarefaDAO();
        try {
            dao.remove(tarefa);
            return "redirect:listaTarefa";
        } catch (SQLException | ClassNotFoundException exception) {
            throw new RuntimeException(exception);
        }
    }
}
