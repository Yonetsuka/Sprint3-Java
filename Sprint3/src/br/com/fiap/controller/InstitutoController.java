package br.com.fiap.controller;

import br.com.fiap.model.dao.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;
import br.com.fiap.model.dao.InstitutoDAO;
import br.com.fiap.model.dto.Instituto;

public class InstitutoController{
    public String inserirInstituto(int idInstituto, String nome, String endereco)throws ClassNotFoundException, SQLException{
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();
        Instituto instituto = new Instituto();
        instituto.setIdInstituto(idInstituto);
        instituto.setNome(nome);
        instituto.setEndereco(endereco);
        InstitutoDAO institutoDAO = new InstitutoDAO(con);
        resultado = institutoDAO.inserir(instituto);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String alterarInstituto(int idInstituto, String nome, String endereco)throws ClassNotFoundException, SQLException{
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();
        Instituto instituto = new Instituto();
        instituto.setIdInstituto(idInstituto);
        instituto.setNome(nome);
        instituto.setEndereco(endereco);
        InstitutoDAO institutoDAO = new InstitutoDAO(con);
        resultado = institutoDAO.alterar(instituto);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String excluirInstituto(int idInstituto)throws ClassNotFoundException, SQLException{
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();
        Instituto instituto = new Instituto();
        instituto.setIdInstituto(idInstituto);
        InstitutoDAO institutoDAO = new InstitutoDAO(con);
        resultado = institutoDAO.excluir(instituto);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String listarUmInstituto(int idInstituto)throws ClassNotFoundException, SQLException{
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();
        Instituto instituto = new Instituto();
        instituto.setIdInstituto(idInstituto);
        InstitutoDAO institutoDAO = new InstitutoDAO(con);
        resultado = institutoDAO.listarUm(instituto);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }
}
