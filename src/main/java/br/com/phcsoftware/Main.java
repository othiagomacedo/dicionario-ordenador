package br.com.phcsoftware;

import br.com.phcsoftware.control.ControleArquivoIn;
import br.com.phcsoftware.control.IControleArquivoIn;
import java.io.File;


public class Main {

    public static void main(String[] args) throws Exception {
        
                     IControleArquivoIn controleArquivoIn = new ControleArquivoIn();
                    String arquivoSelecionado = ".\\phcsoftware\\control\\arquivo.txt";
            
            controleArquivoIn.internalizarArquivo(arquivoSelecionado);
            
        
    }
}
