/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelinho;

import com.fasterxml.jackson.databind.ObjectMapper;
import static controlizinho.ConsultasDao.listaDeProdutos;
import java.io.File;
import java.io.FileWriter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import modelinho.TabelaConsulta3;

/**
 *
 * @author Carlos Eduardo
 */
public class GravarTxt {

    public static void GravaLogo() throws Exception {
        List<Produtos> lista = new LinkedList<>(); // Minha Lista 
        lista = listaDeProdutos();   // Populando a lista com valores vindos do banco de dados
        OrdenarPorSelectionSort(lista); // chamndo o metodo de ordenação

        try {
            ObjectMapper convesor = new ObjectMapper();

            File file = new File("produtosOrdenados.json");
            file.createNewFile();
            FileWriter escrever = new FileWriter(file);

            for (int i = 0; i < lista.size(); i++) {
                String resultadoEmJson = convesor.writeValueAsString(lista.get(i)) + "\r\n";
                escrever.write("" + resultadoEmJson);
            }

            escrever.close();
            
            
        } catch (Exception e) {
            System.out.println("Não Gravou");
        }

    }

    public static List<Produtos> OrdenarPorSelectionSort(List<Produtos> lista) {

        int codigoMaior = 0;
        int posicaoMaior = 0;
        int tamanho = lista.size();
        int ultimaPosicao = 0;
        Produtos produtoMaior = new Produtos();
        Produtos produtoUltimaPosicao = new Produtos();
        boolean mudou = false;

        for (int i = 0; i < lista.size(); i++) {

            codigoMaior = lista.get(0).getCodigo();
            mudou = false;

            for (int j = 0; j < tamanho; j++) { //descobrir quem é o maior valor
                if (codigoMaior <= lista.get(j).getCodigo()) {
                    codigoMaior = lista.get(j).getCodigo();
                    produtoMaior = lista.get(j);
                    posicaoMaior = j;
                    mudou = true;

                }
                if (j == tamanho - 1) {
                    produtoUltimaPosicao = lista.get(j);
                    ultimaPosicao = j;
                }

            }

            if (mudou) {
                // System.out.println(ultimaPosicao);// lista.remove(posicaoMaior);//lista.add(posicaoMaior, produtoUltimaPosicao);//lista.remove(ultimaPosicao);// lista.add(produtoMaior);
                lista.set(posicaoMaior, produtoUltimaPosicao);
                lista.set(ultimaPosicao, produtoMaior);

            }
            tamanho--;
        }

        return lista;
    }
}
