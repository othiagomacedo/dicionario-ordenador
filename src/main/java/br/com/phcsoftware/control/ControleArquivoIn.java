package br.com.phcsoftware.control;

import br.com.phcsoftware.model.*;

import java.io.BufferedReader;
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
    public void internalizarArquivo(String arquivoSelecionado) throws Exception {
        String nomeArquivo = ".\\phcsoftware\\control\\arquivo.txt";
        
        // Ler o arquivo de texto
        List<String> palavras = new ArrayList<String>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(".\\phcsoftware\\control\\arquivo.txt"));
             String linha = null;
             while ((linha = reader.readLine()) != null) {
            // processar a linha lida
            System.out.println(linha);
            }
        } catch (Exception e) {
        }
        
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
        }
        
    }

}
