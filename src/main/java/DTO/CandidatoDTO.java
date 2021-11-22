/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author carla
 */
public class CandidatoDTO {
    private String nome;
    private String contato;
    private String codigo_vagas;
    private int cod_candidato;
    
    
    public String getCodigo_vagas() {
        return codigo_vagas;
    }

    public void setCodigo_vagas(String codigo_vagas) {
        this.codigo_vagas = codigo_vagas;
    }

    public int getCod_candidato() {
        return cod_candidato;
    }

    public void setCod_candidato(int cod_candidato) {
        this.cod_candidato = cod_candidato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }
}
