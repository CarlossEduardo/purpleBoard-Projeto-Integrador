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
public class Produtos {
    int idProduto ;
    int codigo;
    String descricaoProduto;
    String categoriaProduto;

    public Produtos(int idProduto, int codigo, String descricaoProduto, String categoriaProduto) {
        this.idProduto = idProduto;
        this.codigo = codigo;
        this.descricaoProduto = descricaoProduto;
        this.categoriaProduto = categoriaProduto;
    }

    public Produtos() {
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public String getCategoriaProduto() {
        return categoriaProduto;
    }

    public void setCategoriaProduto(String categoriaProduto) {
        this.categoriaProduto = categoriaProduto;
    }
    
}
