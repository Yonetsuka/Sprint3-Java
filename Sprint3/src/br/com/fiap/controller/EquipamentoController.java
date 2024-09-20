package br.com.fiap.controller;

import br.com.fiap.model.dao.ConnectionFactory;
import br.com.fiap.model.dao.EquipamentoDAO;
import br.com.fiap.model.dto.Equipamento;
import java.sql.Connection;
import java.sql.SQLException;

public class EquipamentoController{
    public String inserirEquipamento(int idEquipamento, String descricao, int idInstituto)throws ClassNotFoundException, SQLException{
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();
        Equipamento equipamento = new Equipamento();
        equipamento.setIdEquipamento(idEquipamento);
        equipamento.setDescricao(descricao);
        equipamento.setIdInstituto(idInstituto);
        EquipamentoDAO equipamentoDAO = new EquipamentoDAO(con);
        resultado = equipamentoDAO.inserir(equipamento);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String alterarEquipamento(int idEquipamento, String descricao, int idInstituto)throws ClassNotFoundException, SQLException{
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();
        Equipamento equipamento = new Equipamento();
        equipamento.setIdEquipamento(idEquipamento);
        equipamento.setDescricao(descricao);
        equipamento.setIdInstituto(idInstituto);
        EquipamentoDAO equipamentoDAO = new EquipamentoDAO(con);
        resultado = equipamentoDAO.alterar(equipamento);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String excluirEquipamento(int idEquipamento)throws ClassNotFoundException, SQLException{
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();
        Equipamento equipamento = new Equipamento();
        equipamento.setIdEquipamento(idEquipamento);
        EquipamentoDAO equipamentoDAO = new EquipamentoDAO(con);
        resultado = equipamentoDAO.excluir(equipamento);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String listarUmEquipamento(int idEquipamento)throws ClassNotFoundException, SQLException{
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();
        Equipamento equipamento = new Equipamento();
        equipamento.setIdEquipamento(idEquipamento);
        EquipamentoDAO equipamentoDAO = new EquipamentoDAO(con);
        resultado = equipamentoDAO.listarUm(equipamento);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }
}