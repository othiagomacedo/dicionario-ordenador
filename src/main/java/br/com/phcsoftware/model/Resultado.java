package br.com.phcsoftware.model;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Resultado {

    private Resultado(){}

    public static void salvarTXT(String[] vetorDePalavras, String nomeTipoOrdenador) throws Exception {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(".\\src\\main\\java\\br\\com\\phcsoftware\\processados\\files\\arquivoOrdenadoBy_"+nomeTipoOrdenador+"French.txt"))){
            String listaPalavras = "";
            for(String palavra:vetorDePalavras){
                listaPalavras += palavra + "\n";
            }
            bw.write(listaPalavras);
        } catch (Exception e){
            throw new Exception("Nao foi possivel realizar o salvar do arquivo TXT: "+e.getMessage());
        }
    }
}
