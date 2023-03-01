package br.com.phcsoftware.control;

import br.com.phcsoftware.model.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ControleArquivoIn implements IControleArquivoIn {

    IOrdenacao ordenacao;

    public ControleArquivoIn() {
        this.ordenacao = new Ordenacao();
    }

    @Override
    public void internalizarArquivo(File arquivoSelecionado) throws Exception {
        // Ler o arquivo de texto
        try(BufferedReader reader = new BufferedReader(new FileReader(arquivoSelecionado))) {
             String linha = "";
             String listaAux = "";
             int cont = 0;
             while ((linha = reader.readLine()) != null) {
                listaAux += linha + ";";
                cont+=1;
                //if(cont%10000==0) System.out.println("contagem de linhas até agora: "+cont);
             }
             //arquivoSelecionado.delete();
            System.out.println("Contador de palavras: "+cont);
             String[] vetAux = listaAux.split(";");

             //ordenacao.bubbleSort(vetAux);
             //ordenacao.insertionSort(vetAux);
             ordenacao.selectionSort(vetAux);
        } catch (Exception e) {
            throw e;
        }

        /*
        // Comparador de palavras pelo seu tamanho
        Comparator<String> comparador = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        };
        
        // Ordenar a lista de palavras pelo seu tamanho
        Collections.sort(palavras, comparador);
        
        // Imprimir as palavras ordenadas
        for (String palavra : palavras) {
            System.out.println(palavra);
        }*/
        
    }

}
