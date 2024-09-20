package br.com.fiap.controller;

import br.com.fiap.model.dao.ConnectionFactory;
import br.com.fiap.model.dao.TreinamentoDAO;
import br.com.fiap.model.dto.Treinamento;
import java.sql.Connection;
import java.sql.SQLException;

public class TreinamentoController{
    public String inserirTreinamento(int idTreinamento, String titulo, String status, int idMedico)
            throws ClassNotFoundException, SQLException{
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();
        Treinamento treinamento = new Treinamento();
        treinamento.setIdTreinamento(idTreinamento);
        treinamento.setTitulo(titulo);
        treinamento.setStatus(status);
        treinamento.setIdMedico(idMedico);
        TreinamentoDAO treinamentoDAO = new TreinamentoDAO(con);
        resultado = treinamentoDAO.inserir(treinamento);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String alterarTreinamento(int idTreinamento, String titulo, String status, int idMedico)
            throws ClassNotFoundException, SQLException{
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();
        Treinamento treinamento = new Treinamento();
        treinamento.setIdTreinamento(idTreinamento);
        treinamento.setTitulo(titulo);
        treinamento.setStatus(status);
        treinamento.setIdMedico(idMedico);
        TreinamentoDAO treinamentoDAO = new TreinamentoDAO(con);
        resultado = treinamentoDAO.alterar(treinamento);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String excluirTreinamento(int idTreinamento)throws ClassNotFoundException, SQLException{
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();
        Treinamento treinamento = new Treinamento();
        treinamento.setIdTreinamento(idTreinamento);
        TreinamentoDAO treinamentoDAO = new TreinamentoDAO(con);
        resultado = treinamentoDAO.excluir(treinamento);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String listarUmTreinamento(int idTreinamento)throws ClassNotFoundException, SQLException{
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();
        Treinamento treinamento = new Treinamento();
        treinamento.setIdTreinamento(idTreinamento);
        TreinamentoDAO treinamentoDAO = new TreinamentoDAO(con);
        resultado = treinamentoDAO.listarUm(treinamento);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }
}