package br.com.phcsoftware;

import br.com.phcsoftware.control.ControleArquivoIn;
import br.com.phcsoftware.control.ControleBusca;
import br.com.phcsoftware.control.IControleArquivoIn;
import br.com.phcsoftware.control.IControleBusca;

import java.io.File;


public class Main {

    public static void main(String[] args) throws Exception {
        IControleArquivoIn controleArquivoIn = new ControleArquivoIn();
        IControleBusca controleBusca = new ControleBusca();
        //controleBusca.buscaSequencial();

        File arquivo = new File(".\\src\\main\\java\\br\\com\\phcsoftware\\processados\\files\\arquivo.txt");
        controleArquivoIn.internalizarArquivo(arquivo);
    }
}
