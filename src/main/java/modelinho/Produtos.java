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

    int codigo;
    String descricaoProduto;
    String categoriaProduto;

    public Produtos(int codigo, String descricaoProduto, String categoriaProduto) {

        this.codigo = codigo;
        this.descricaoProduto = descricaoProduto;
        this.categoriaProduto = categoriaProduto;
    }

    public Produtos() {
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
