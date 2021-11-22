
package DTO;

public class VagasDTO {
    private String cod_vagas;
    private String nome_vaga;
    private String descricao;
    private String bolsa;
    private String semestre;
    private String curso;
    private String ano_conclusao;
    private String tipoVaga;
    private String codUsuario;
    
    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }
    
    public String getTipoVaga() {
        return tipoVaga;
    }

    public void setTipoVaga(String tipoVaga) {
        this.tipoVaga = tipoVaga;
    }
    
    public String getCod_vagas() {
        return cod_vagas;
    }

    public void setCod_vagas(String cod_vagas) {
        this.cod_vagas = cod_vagas;
    }

    public String getNome_vaga() {
        return nome_vaga;
    }

    public void setNome_vaga(String nome_vaga) {
        this.nome_vaga = nome_vaga;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getBolsa() {
        return bolsa;
    }

    public void setBolsa(String bolsa) {
        this.bolsa = bolsa;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getAno_conclusao() {
        return ano_conclusao;
    }

    public void setAno_conclusao(String ano_conclusao) {
        this.ano_conclusao = ano_conclusao;
    }
}
