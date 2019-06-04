/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelinho;

/**
 *
 * @author Aluno
 */
public class Localidade {
    int idLocalidade;
    String cidade;
    String estado;
    String regiao;

    public Localidade() {
    }

    public Localidade(int idLocalidade, String cidade, String estado, String regiao) {
        this.idLocalidade = idLocalidade;
        this.cidade = cidade;
        this.estado = estado;
        this.regiao = regiao;
    }

    public int getIdLocalidade() {
        return idLocalidade;
    }

    public void setIdLocalidade(int idLocalidade) {
        this.idLocalidade = idLocalidade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }
    
}
