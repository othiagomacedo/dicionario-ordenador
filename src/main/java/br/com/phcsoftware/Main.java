package br.com.phcsoftware;

import br.com.phcsoftware.control.ControleArquivoIn;
import br.com.phcsoftware.control.IControleArquivoIn;
import java.io.File;


public class Main {

    public static void main(String[] args) throws Exception {
        IControleArquivoIn controleArquivoIn = new ControleArquivoIn();
        File arquivo = new File(".\\src\\main\\java\\br\\com\\phcsoftware\\processados\\files\\arquivoFrenchs.txt");
        controleArquivoIn.internalizarArquivo(arquivo);
    }
}
