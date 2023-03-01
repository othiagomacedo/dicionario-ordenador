package br.com.phcsoftware.model;

import java.util.Arrays;

public class Ordenacao implements IOrdenacao {

    public Ordenacao(){
    }

    @Override
    public void selectionSort(String[] listaDesorganizada) throws Exception {
        try {
            long inicioNano = System.nanoTime();
            long inicioMilli = System.currentTimeMillis();
            for(int i = 0; i < listaDesorganizada.length; i++) {
                int menor = i;
                int cont = 0;
                for (int j = menor + 1; j < listaDesorganizada.length; j++){
                    if (listaDesorganizada[j].length() < listaDesorganizada[menor].length()){
                        menor = j;
                    }
                }
                if (menor != i){
                    String temp = listaDesorganizada[i];
                    listaDesorganizada[i] = listaDesorganizada[menor];
                    listaDesorganizada[menor] = temp;
                }


            }
            long finalNano =  System.nanoTime();
            long finalMilli = System.currentTimeMillis();

            long tempoExecucaoNano = finalNano - inicioNano;
            long tempoExecucaoMilli = finalMilli - inicioMilli;

            System.out.println("Tempo de execucao do selectionSort (nano): "+ tempoExecucaoNano);
            System.out.println("Tempo de execucao do selectionSort (milli): "+ tempoExecucaoMilli);

            Resultado.salvarTXT(listaDesorganizada,"SelectionSort");
        }catch (Exception e) {
            throw new Exception("Erro ao executar o método selectionSort: "+e.getMessage());
        }
    }

    @Override
    public void bubbleSort(String[] listaDesorganizada) throws Exception {
        try {
            long inicio = System.nanoTime();

            int n = listaDesorganizada.length;

            int cont = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (listaDesorganizada[j].length() > listaDesorganizada[j + 1].length()) {
                        String temp = listaDesorganizada[j];
                        listaDesorganizada[j] = listaDesorganizada[j + 1];
                        listaDesorganizada[j + 1] = temp;

                        //isso aqui é puro teste pra ver até onde esse cara vai
                        cont+=1;
                        System.out.println("Contador de troca feita pelo buble: "+ cont);
                    }
                }
            }

            long tempoDeExecucao = inicio - System.nanoTime();
            System.out.println("Tempo de execucao do BubbleSort: "+tempoDeExecucao);
            Resultado.salvarTXT(listaDesorganizada,"BubbleSort");
        }catch (Exception e) {
            throw new Exception("Erro ao executar o método bubbleSort: "+e.getMessage());
        }
    }

    @Override
    public void insertionSort(String[] listaDesorganizada) throws Exception {
        try {
            long inicioNano = System.nanoTime();
            long inicioMilli = System.currentTimeMillis();
            int n = listaDesorganizada.length;
            int cont = 0;
            for (int i = 1; i < n; i++) {
                String palavra = listaDesorganizada[i];
                int j = i - 1;
                while (j >= 0 && listaDesorganizada[j].length() > palavra.length()) {
                    listaDesorganizada[j + 1] = listaDesorganizada[j];
                    j = j - 1;
                }
                listaDesorganizada[j + 1] = palavra;

                //isso aqui é puro teste pra ver até onde esse cara vai
                cont+=1;
                if (cont%1000==0)System.out.println("Contador de troca feita pelo insertion: "+ cont);
            }
            long finalNano =  System.nanoTime();
            long finalMilli = System.currentTimeMillis();

            long tempoExecucaoNano = finalNano - inicioNano;
            long tempoExecucaoMilli = finalMilli - inicioMilli;

            System.out.println("Tempo de execucao do insertionSort (nano): "+ tempoExecucaoNano);
            System.out.println("Tempo de execucao do insertionSort (milli): "+ tempoExecucaoMilli);


            Resultado.salvarTXT(listaDesorganizada,"InsertionSort");
        }catch (Exception e) {
            throw new Exception("Erro ao executar o método insertionSort: "+e.getMessage());
        }
    }

    @Override
    public void mergeSort(String[] listaDesorganizada) throws Exception {
        try {
            long inicio = System.nanoTime();
            long tempoDeExecucao = inicio - System.nanoTime();
        }catch (Exception e) {

        }
    }

    @Override
    public void quickSort(String[] listaDesorganizada) throws Exception {
        try {
            long inicio = System.nanoTime();
            long tempoDeExecucao = inicio - System.nanoTime();
        }catch (Exception e) {

        }
    }

    @Override
    public String[] getParteListaOrdenada(String[] vetorOrganizadoPorTamanhoPalavra, int tamanhoPalavraBuscada) throws Exception{
        String[] vetor = vetorOrganizadoPorTamanhoPalavra;
        int busca = tamanhoPalavraBuscada;
        String palavras = "";
        try{
            //busca sequencial para obter apenas a parte do vetor que corresponde o tamanho da palavra buscada
            for(int i = 0; i < vetor.length ; i++){
                if (vetor[i].length() == tamanhoPalavraBuscada) {
                    //preenche uma string com as palavras preenchidas
                    palavras += vetor[i] + ";";
                } else {
                    if (vetor[i].length() > tamanhoPalavraBuscada){
                        //para sair do loop
                        i = vetor.length;
                    }
                }
            }
            if (palavras.endsWith(";")) {
                palavras = palavras.substring(0, palavras.length() - 1);
            }
            String[] vet = palavras.split(";");
            Arrays.sort(vet);
            return vet;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
