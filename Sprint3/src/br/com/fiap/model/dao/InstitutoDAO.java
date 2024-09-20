package br.com.fiap.model.dao;

import br.com.fiap.model.dto.Instituto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InstitutoDAO implements IDAO{
    private Connection con;
    private Instituto instituto;

    public InstitutoDAO(Connection con){
        this.con = con;
    }

    public Connection getCon(){
        return con;
    }

    public String inserir(Object object){
        instituto = (Instituto) object;
        String sql = "insert into instituto(idinstituto,nome,endereco) values(?,?,?)";
        try(PreparedStatement ps = getCon().prepareStatement(sql);){
            ps.setInt(1,instituto.getIdInstituto());
            ps.setString(2,instituto.getNome());
            ps.setString(3,instituto.getEndereco());
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
        instituto = (Instituto) object;
        String sql = "update instituto set nome = ?,endereco = ?  where idinstituto = ?";
        try(PreparedStatement ps = getCon().prepareStatement(sql);){
            ps.setString(1,instituto.getNome());
            ps.setString(2,instituto.getEndereco());
            ps.setInt(3,instituto.getIdInstituto());
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
        instituto = (Instituto) object;
        String sql = "delete from instituto where idinstituto = ?";
        try(PreparedStatement ps = getCon().prepareStatement(sql);){
            ps.setInt(1,instituto.getIdInstituto());
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
        instituto = (Instituto) object;
        String sql = "select * from instituto where idinstituto = ?";
        try(PreparedStatement ps = getCon().prepareStatement(sql);){
            ps.setInt(1,instituto.getIdInstituto());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return "Id do instituto: " + instituto.getIdInstituto() + "\nNome: " + rs.getString("nome") +
                        "\nEndereço: " + rs.getString("endereco");
            }else{
                return "Registro não encontrado";
            }
        }catch(SQLException e){
            return "Erro: " + e.getMessage();
        }
    }
}