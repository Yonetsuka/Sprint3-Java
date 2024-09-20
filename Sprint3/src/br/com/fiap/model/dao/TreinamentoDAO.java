package br.com.fiap.model.dao;

import java.sql.Connection;
import br.com.fiap.model.dto.Treinamento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TreinamentoDAO implements IDAO{
    private Connection con;
    private Treinamento treinamento;

    public TreinamentoDAO(Connection con){
        this.con = con;
    }

    private Connection getCon(){
        return con;
    }

    public String inserir(Object object){
        treinamento = (Treinamento) object;
        String sql = "insert into treinamento(IDTREINAMENTO,titulo,status,idMedico) values(?,?,?,?)";
        try(PreparedStatement ps = getCon().prepareStatement(sql)){
            ps.setInt(1,treinamento.getIdTreinamento());
            ps.setString(2,treinamento.getTitulo());
            ps.setString(3,treinamento.getStatus());
            ps.setInt(4,treinamento.getIdMedico());
            if(ps.executeUpdate() > 0){
                return "Inserido com sucesso";
            }else{
                return "Erro ao inserir";
            }
        }catch(SQLException e){
            return "Erro: " + e.getMessage();
        }
    }

    public String alterar(Object object){
        treinamento = (Treinamento) object;
        String sql = "update treinamento set titulo = ?, status= ?, idMedico = ?  where idTreinamento = ?";
        try(PreparedStatement ps = getCon().prepareStatement(sql)){
            ps.setString(1,treinamento.getTitulo());
            ps.setString(2, treinamento.getStatus());
            ps.setInt(3,treinamento.getIdMedico());
            ps.setInt(4,treinamento.getIdTreinamento());
            if(ps.executeUpdate() > 0){
                return "Alterado com sucesso";
            }else{
                return "Erro ao alterar";
            }
        }catch(SQLException e){
            return "Erro: " + e.getMessage();
        }
    }

    public String excluir(Object object){
        treinamento = (Treinamento) object;
        String sql = "delete from treinamento where idTreinamento = ?";
        try(PreparedStatement ps = getCon().prepareStatement(sql)){
            ps.setInt(1,treinamento.getIdTreinamento());
            if(ps.executeUpdate() > 0){
                return "Excluido com sucesso";
            }else{
                return "Erro ao excluir";
            }
        }catch(SQLException e){
            return "Erro: " + e.getMessage();
        }
    }

    public String listarUm(Object object){
        treinamento = (Treinamento) object;
        String sql = "select * from treinamento where idTreinamento = ?";
        try(PreparedStatement ps = getCon().prepareStatement(sql)){
            ps.setInt(1,treinamento.getIdTreinamento());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return "Id do treinamento: " + treinamento.getIdTreinamento() + "\nTitulo: " + rs.getString("titulo") +
                        "\nStatus: " + rs.getString("status") + "\nId do médico: " + rs.getInt("idMedico");
            }else{
                return "Registro não encontrado";
            }
        }catch(SQLException e){
            return "Erro: " + e.getMessage();
        }
    }
}