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
public class Loja {
    int idLoja;
    String cnpj;
    String nomeLoja;

    public Loja() {
    }

    public Loja(int idLoja, String cnpj, String nomeLoja) {
        this.idLoja = idLoja;
        this.cnpj = cnpj;
        this.nomeLoja = nomeLoja;
    }

    public int getIdLoja() {
        return idLoja;
    }

    public void setIdLoja(int idLoja) {
        this.idLoja = idLoja;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeLoja() {
        return nomeLoja;
    }

    public void setNomeLoja(String nomeLoja) {
        this.nomeLoja = nomeLoja;
    }
    
    
}

