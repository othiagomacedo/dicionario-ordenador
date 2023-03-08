package br.com.phcsoftware;

import br.com.phcsoftware.control.ControleArquivoIn;
import br.com.phcsoftware.control.IControleArquivoIn;
import br.com.phcsoftware.model.Busca;
import br.com.phcsoftware.model.IOrdenacao;
import br.com.phcsoftware.model.Ordenacao;
import br.com.phcsoftware.model.TipoDicionario;

import java.io.File;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws Exception {
        IControleArquivoIn controleArquivoIn = new ControleArquivoIn();
        //controleBusca.buscaSequencial();

        File arquivoEstrangeiro = new File(".\\src\\main\\java\\br\\com\\phcsoftware\\processados\\files\\arquivoFrenchs.txt");
        File arquivoBrasileiro = new File(".\\src\\main\\java\\br\\com\\phcsoftware\\processados\\files\\arquivo.txt");

        controleArquivoIn.internalizarArquivo(arquivoBrasileiro, TipoDicionario.PORTUGUES);
        controleArquivoIn.internalizarArquivo(arquivoEstrangeiro, TipoDicionario.ESTRANGEIRO);

        console();
        //controleArquivoIn.internalizarArquivo(arquivo);
    }

    private static void console() throws Exception {
        try {
            int selecionado = 0;
            int tpDicio = 0;
            String palavraBuscada = "";

            IOrdenacao ord = new Ordenacao();
            TipoDicionario tpDicionario = null;

            Scanner sc = new Scanner(System.in);
            while (true){

                System.out.println("Selecione:\n(1) Ordenar\n(2) Buscar");
                selecionado = Integer.parseInt(sc.nextLine());

                if (selecionado==1){
                    System.out.println("Selecione metodo de ordenacao:\n");
                    System.out.println("(1) Selection Sort\n(2) Bubble Sort\n(3) Insertion Sort\n(4) Merge Sort\n(5) Quick Sort");
                    selecionado = Integer.parseInt(sc.nextLine());

                    System.out.println("Em qual dicionario?\n(1) Portugues\n(2) Estrangeiro");
                    tpDicio = Integer.parseInt(sc.nextLine());

                    if (tpDicio == 1){
                        tpDicionario = TipoDicionario.PORTUGUES;
                    } else {
                        tpDicionario = TipoDicionario.ESTRANGEIRO;
                    }

                    switch (selecionado){
                        case 1: ord.selectionSort(tpDicionario); break;
                        case 2: ord.bubbleSort(tpDicionario); break;
                        case 3: ord.insertionSort(tpDicionario); break;
                        case 4: ord.mergeSort(tpDicionario); break;
                        case 5: ord.quickSort(tpDicionario); break;
                    }

                } else {

                    System.out.println("Em qual dicionario?\n(1) Portugues\n(2) Estrangeiro");
                    tpDicio = Integer.parseInt(sc.nextLine());

                    if (tpDicio == 1){
                        tpDicionario = TipoDicionario.PORTUGUES;
                    } else {
                        tpDicionario = TipoDicionario.ESTRANGEIRO;
                    }


                    System.out.println("Selecione o metodo de Busca:\n(1) Binaria\n(2) Sequencial");
                    selecionado = Integer.parseInt(sc.nextLine());

                    System.out.println();

                    System.out.println("Qual a palavra buscada?");
                    palavraBuscada = sc.nextLine();

                    switch (selecionado){
                        case 1: Busca.buscaBinariaHibrida(tpDicionario, palavraBuscada); break;
                        case 2: Busca.buscaSequencial(tpDicionario, palavraBuscada); break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
