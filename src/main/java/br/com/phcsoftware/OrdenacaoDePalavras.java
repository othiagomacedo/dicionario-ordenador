package br.com.phcsoftware;
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
        Collections.sort(palavras, (s1, s2) -> Integer.compare(s1.length(), s2.length()));

        //Utilizando BuubleSort
        bubbleSort(palavras);

        // Escrever as palavras ordenadas no arquivo de saída
        escreverArquivo(arquivoSaida, palavras);
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

}

}
