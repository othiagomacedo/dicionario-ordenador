package br.com.phcsoftware.processados;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Processado implements IProcessado{

    public Processado() {
    }

    @Override
    public void armazenaProcessado(String[] vetorOrganizado) throws Exception {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(".\\files\\organizado.txt"))){
            String arquivo = "";
            for(String palavra : vetorOrganizado){
                arquivo += palavra + "\n";
            }
            bw.write(arquivo);
        } catch (Exception e) {
            throw new Exception("Erro ao armazenar o vetor organizado: "+e.getMessage());
        }
    }

    @Override
    public String[] vetorOrganizadoArmazenado() throws Exception {
        try(BufferedReader br = new BufferedReader(new FileReader(".\\files\\organizado.txt"))){
            String arquivo = "";
            String linha = "";
            while((linha = br.readLine()) != null){
                arquivo += linha + "\n";
            }
            return arquivo.split("\n");
        } catch (Exception e) {
            throw new Exception("Erro ao obter o vetor organizado: "+e.getMessage());
        }
    }

}
