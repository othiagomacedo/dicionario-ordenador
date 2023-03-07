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
    public void internalizarArquivo(File arquivoSelecionado,TipoDicionario tipoDicionario) throws Exception {
        switch (tipoDicionario){
            case PORTUGUES:{
                Dicionario.setDicionarioPortuguesCru(leituraArquivoConverterParaVetor(arquivoSelecionado));
                break;
            }
            case ESTRANGEIRO:{
                Dicionario.setDicionarioEstrangeiroCru(leituraArquivoConverterParaVetor(arquivoSelecionado));
                break;
            }
        }
    }

    private String[] leituraArquivoConverterParaVetor(File arquivoIdentificado) throws Exception {
        try(BufferedReader reader = new BufferedReader(new FileReader(arquivoIdentificado))) {
            String linha = "";
            String listaAux = "";
            int cont = 0;
            while ((linha = reader.readLine()) != null) {
                if (linha.contains("/")) {
                    listaAux += linha.substring(0,linha.indexOf('/'));
                } else {
                    listaAux += linha;
                }
                listaAux += ";";
                cont+=1;
                if(cont%10000==0) System.out.println("contagem de linhas até agora: "+cont);
            }
            //arquivoSelecionado.delete();
            System.out.println("Contador de palavras: "+cont);
            String[] vetAux = listaAux.split(";");

            return vetAux;
        } catch (Exception e) {
            throw e;
        }
    }

}
