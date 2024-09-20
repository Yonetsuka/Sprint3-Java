package br.com.fiap.model.dto;

public class Equipamento{
    private int idEquipamento, idInstituto;
    private String descricao;

    public int getIdEquipamento(){
        return idEquipamento;
    }
    public void setIdEquipamento(int idEquipamento){
        this.idEquipamento = idEquipamento;
    }
    public String getDescricao(){
        return descricao;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    public int getIdInstituto(){
        return idInstituto;
    }
    public void setIdInstituto(int idInstituto){
        this.idInstituto = idInstituto;
    }
}