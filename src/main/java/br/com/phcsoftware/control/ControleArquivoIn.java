package br.com.phcsoftware.control;

import br.com.phcsoftware.model.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ControleArquivoIn implements IControleArquivoIn {

    IOrdenacao ordenacao;

    public ControleArquivoIn() {
        this.ordenacao = new Ordenacao();
    }

    @Override
    public void internalizarArquivo(File arquivoSelecionado) throws Exception {
        try(BufferedReader br = new BufferedReader(new FileReader(arquivoSelecionado))) {

            String linhaLida = "";
            String arquivoLido = "";

            while ((linhaLida = br.readLine()) != null) {
                arquivoLido += linhaLida + "\n";
            }

            String[] vetor = arquivoLido.split("\n");

            ordenacao.selectionSort(vetor);
            ordenacao.insertionSort(vetor);
            ordenacao.bubbleSort(vetor);
        } catch (Exception e){
            throw new Exception("Nao foi possivel internalizar o arquivo: "+e.getMessage());
        }
    }

}
