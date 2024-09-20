package br.com.fiap.model.dto;

public class Treinamento{
    private int idTreinamento, idMedico;
    private String titulo;
    private String status;

    public int getIdTreinamento(){
        return idTreinamento;
    }
    public void setIdTreinamento(int idTreinamento){
        this.idTreinamento = idTreinamento;
    }

    public int getIdMedico(){
        return idMedico;
    }

    public void setIdMedico(int idMedico){
        this.idMedico = idMedico;
    }

    public String getTitulo(){
        return titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }
}