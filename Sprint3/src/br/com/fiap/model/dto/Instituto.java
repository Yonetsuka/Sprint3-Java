package br.com.fiap.model.dto;

public class Instituto{
    private int idInstituto;
    private String nome, endereco;

    public int getIdInstituto(){
        return idInstituto;
    }
    public void setIdInstituto(int idInstituto){
        this.idInstituto = idInstituto;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getEndereco(){
        return endereco;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
}
