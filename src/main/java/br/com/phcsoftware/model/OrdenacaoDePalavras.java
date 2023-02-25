package br.com.phcsoftware.model;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class OrdenacaoDePalavras {

    public static void main(String[] args) {

        // Caminho do arquivo de entrada e de saída

        // TEM DE DEFINIR O CAMINHO DO ARQUIVO DE ENTRADA E SAIDA AINDA

        String arquivoEntrada = "arquivo.txt";
        String arquivoSaida = "saida.txt";

        // Ler as palavras do arquivo de entrada e armazenar em uma lista
        List<String> palavras = lerArquivo(arquivoEntrada);

        // Ordenar as palavras em ordem crescente de tamanho
        // Utilizando Collections.sort
        List<String> palavrasOrdenadasCollections = lerArquivo(arquivoEntrada);
        long tempoInicioCollectionsSort = System.currentTimeMillis();
        Collections.sort(palavrasOrdenadasCollections, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        long tempoFimCollectionsSort= System.currentTimeMillis();
        long tempoExecucaoCollections = tempoFimCollectionsSort - tempoInicioCollectionsSort;

        //Utilizando BuubleSort
        List<String> palavrasOrdenadasBubbleSort = new ArrayList<>(palavras);
        long tempoInicioBubbleSort = System.currentTimeMillis();
        bubbleSort(palavrasOrdenadasBubbleSort);
        long tempoFimBubbleSort= System.currentTimeMillis();
        long tempoExecucaoBubbleSort = tempoFimBubbleSort - tempoInicioBubbleSort;

        // Ordenar as palavras em ordem crescente de tamanho com Insertion Sort
        List<String> palavrasOrdenadasInsertionSort = new ArrayList<>(palavras);
        long tempoInicioInsertionSort = System.currentTimeMillis();
        insertionSort(palavrasOrdenadasInsertionSort);
        long tempoFimInsertionSort = System.currentTimeMillis();
        long tempoExecucaoInsertionSort = tempoFimInsertionSort - tempoInicioInsertionSort;

        // Ordenar as palavras em ordem crescente de tamanho com Merge Sort
        List<String> palavrasOrdenadasMergeSort = new ArrayList<>(palavras);
        long tempoInicioMergeSort = System.currentTimeMillis();
        //mergeSort(palavrasOrdenadasMergeSort, 0, palavras.size() - 1);
        long tempoFimMergeSort = System.currentTimeMillis();
        long tempoExecucaoMergeSort = tempoFimMergeSort - tempoInicioMergeSort;

        // Ordenar as palavras em ordem crescente de tamanho com Quick Sort
        List<String> palavrasOrdenadasQuickSort = new ArrayList<>(palavras);
        long tempoInicioQuickSort = System.currentTimeMillis();
        //quickSort(palavrasOrdenadasQuickSort, 0, palavras.size() - 1);
        long tempoFimQuickSort = System.currentTimeMillis();
        long tempoExecucaoQuickSort = tempoFimQuickSort - tempoInicioQuickSort;

        // Escrever as palavras ordenadas com cada algoritmo no arquivo de saída

        /**
         * IDENTIFICAR A MELHOR MANEIRA DE IMPRIMIR NO ARQUIVO DE SAÍDA POIS ASSIM
         * TODOS VÃO PARA O MESMO ARQUIVO JUNTO DO TEMPO DE EXECUÇÃO
         * SEPARAR DE ACORDO COM O MÉTODO SELECIONADO?
         *
         * Dá para escrever elas ordenada com um só método e depois vir colocando o tempo de todos

        escreverArquivo(arquivoSaida, "Bubble Sorte (" + tempoExecucaoBubbleSort + "ms):\n", palavrasOrdenadasBubbleSort);
        escreverArquivo(arquivoSaida, "Insertion Sort (" + tempoExecucaoInsertionSort + " ms):\n", palavrasOrdenadasInsertionSort);
        escreverArquivo(arquivoSaida, "Merge Sort (" + tempoExecucaoMergeSort + " ms):\n", palavrasOrdenadasMergeSort);
        escreverArquivo(arquivoSaida, "Quick Sort (" + tempoExecucaoQuickSort + " ms):\n", palavrasOrdenadasQuickSort);
        escreverArquivo(arquivoSaida, "Collections.sort (" + tempoExecucaoCollections + " ms):\n", palavrasOrdenadasCollections);
         */
    }




    /**
     * Ler as palavras de um arquivo de texto e as armazena em uma lista.
     */
    private static List<String> lerArquivo(String caminhoArquivo) {
        List<String> palavras = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(caminhoArquivo))) {
            while (scanner.hasNext()) {
                palavras.add(scanner.next());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + caminhoArquivo);
        }
        return palavras;
    }

    /**
     * Escrever as palavras em ordem crescente de tamanho em um arquivo de texto.
     */
    private static void escreverArquivo(String caminhoArquivo, List<String> palavras) {
        try (PrintWriter writer = new PrintWriter(new File(caminhoArquivo))) {
            for (String palavra : palavras) {
                writer.println(palavra);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + caminhoArquivo);
        }
    }

    //BUBBLE SORT
    private static void bubbleSort(List<String> palavras) {
        int n = palavras.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                String palavra1 = palavras.get(j);
                String palavra2 = palavras.get(j + 1);
                if (palavra1.length() > palavra2.length()) {
                    // Troca as posições das palavras na lista
                    palavras.set(j, palavra2);
                    palavras.set(j + 1, palavra1);
                }
            }
        }
    }

    //INSERCTION SORT
    private static void insertionSort(List<String> palavras) {
        int n = palavras.size();
        for (int i = 1; i < n; ++i) {
            String chave = palavras.get(i);
            int j = i - 1;
            while (j >= 0 && palavras.get(j).length() > chave.length()) {
                palavras.set(j + 1, palavras.get(j));
                j = j - 1;
            }
            palavras.set(j + 1, chave);
        }
    }


}

