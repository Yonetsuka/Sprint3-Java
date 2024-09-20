package br.com.fiap.model.dao;

import br.com.fiap.model.dto.Equipamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EquipamentoDAO{
    private Connection con;
    private Equipamento equipamento;

    public EquipamentoDAO(Connection con){
        this.con = con;
    }
    public Connection getCon(){
        return con;
    }

    public String inserir(Object object){
        equipamento = (Equipamento) object;
        String sql = "insert into equipamento(idequipamento,descricao,idinstituto) values(?,?,?)";
        try(PreparedStatement ps = getCon().prepareStatement(sql);){
            ps.setInt(1,equipamento.getIdEquipamento());
            ps.setString(2,equipamento.getDescricao());
            ps.setInt(3,equipamento.getIdInstituto());
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
        equipamento = (Equipamento) object;
        String sql = "update equipamento set descricao = ?,idinstituto = ?  where idequipamento = ?";
        try(PreparedStatement ps = getCon().prepareStatement(sql);){
            ps.setString(1,equipamento.getDescricao());
            ps.setInt(2,equipamento.getIdInstituto());
            ps.setInt(3,equipamento.getIdEquipamento());
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
        equipamento = (Equipamento) object;
        String sql = "delete from equipamento where idequipamento = ?";
        try(PreparedStatement ps = getCon().prepareStatement(sql);){
            ps.setInt(1,equipamento.getIdEquipamento());
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
        equipamento = (Equipamento) object;
        String sql = "select * from equipamento where idequipamento = ?";
        try(PreparedStatement ps = getCon().prepareStatement(sql);){
            ps.setInt(1,equipamento.getIdEquipamento());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return "Id do equipamento: " + equipamento.getIdEquipamento() + "\nDescrição: " + rs.getString("descricao") +
                        "\nId do instituto: " + rs.getInt("idinstituto");
            }else{
                return "Registro não encontrado";
            }
        }catch(SQLException e){
            return "Erro: " + e.getMessage();
        }
    }
}
