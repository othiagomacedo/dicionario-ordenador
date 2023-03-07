package br.com.phcsoftware.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ordenacao implements IOrdenacao {

    public Ordenacao(){
    }

    @Override
    public void selectionSort(TipoDicionario tipoDicionario) throws Exception {
        try {
            String[] listaDesorganizada;

            Date data = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY HH:mm ");
            String relatorio = "Método de ordenacao SelectionSort ==============\nData e Hora da Execução: "+sdf.format(data)+"\n";

            if(tipoDicionario == TipoDicionario.PORTUGUES){
                listaDesorganizada = Dicionario.getDicionarioPortuguesCru();
            } else {
                listaDesorganizada = Dicionario.getDicionarioEstrangeiroCru();
            }

            long inicioNano = System.nanoTime();
            long inicioMilli = System.currentTimeMillis();
            int cont = 0;
            for(int i = 0; i < listaDesorganizada.length; i++) {
                int menor = i;

                for (int j = menor + 1; j < listaDesorganizada.length; j++){
                    if (listaDesorganizada[j].length() < listaDesorganizada[menor].length()){
                        menor = j;
                        cont+=1;
                    }
                }
                if (menor != i){
                    String temp = listaDesorganizada[i];
                    listaDesorganizada[i] = listaDesorganizada[menor];
                    listaDesorganizada[menor] = temp;
                    cont+=1;
                }

            }
            long finalNano =  System.nanoTime();
            long finalMilli = System.currentTimeMillis();

            long tempoExecucaoNano = finalNano - inicioNano;
            long tempoExecucaoMilli = finalMilli - inicioMilli;

            salvarDicionarioOrganizado(tipoDicionario, listaDesorganizada);

            relatorio += "Tempo de execucao (nanosegundos): "+ tempoExecucaoNano+
                    "\nTempo de execucao (millisegundos): "+ tempoExecucaoMilli+
                    "\nTempo de execucao (segundos): "+ tempoExecucaoMilli/1000+
                    "\nNumero de trocas feitas por este método de organização: "+cont;

            Resultado.relatorioTempoOrganizado(relatorio,"SelectionSort");
        }catch (Exception e) {
            throw new Exception("Erro ao executar o método selectionSort: "+e.getMessage());
        }
    }

    @Override
    public void bubbleSort(TipoDicionario tipoDicionario) throws Exception {
        try {
            String[] listaDesorganizada;
            Date data = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY HH:mm ");
            String relatorio = "Método de ordenacao BubleSort ==============\nData e Hora da Execução: "+sdf.format(data)+"\n";

            if(tipoDicionario == TipoDicionario.PORTUGUES){
                listaDesorganizada = Dicionario.getDicionarioPortuguesCru();
            } else {
                listaDesorganizada = Dicionario.getDicionarioEstrangeiroCru();
            }
            long inicioNano = System.nanoTime();
            long inicioMilli = System.currentTimeMillis();

            int n = listaDesorganizada.length;

            int cont = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (listaDesorganizada[j].length() > listaDesorganizada[j + 1].length()) {
                        String temp = listaDesorganizada[j];
                        listaDesorganizada[j] = listaDesorganizada[j + 1];
                        listaDesorganizada[j + 1] = temp;
                        cont+=1;
                        //System.out.println("Contador de troca feita pelo buble: "+ cont);
                    }
                }
            }

            long finalNano =  System.nanoTime();
            long finalMilli = System.currentTimeMillis();

            long tempoExecucaoNano = finalNano - inicioNano;
            long tempoExecucaoMilli = finalMilli - inicioMilli;


            relatorio += "Tempo de execucao (nanosegundos): "+ tempoExecucaoNano+
                    "\nTempo de execucao (millisegundos): "+ tempoExecucaoMilli+
                    "\nTempo de execucao (segundos): "+ tempoExecucaoMilli/1000+
                    "\nNumero de trocas feitas por este método de organização: "+cont;

            salvarDicionarioOrganizado(tipoDicionario, listaDesorganizada);

            //Resultado.salvarTXT(listaDesorganizada,"BubbleSort");
            Resultado.relatorioTempoOrganizado(relatorio,"BubbleSort");
        }catch (Exception e) {
            throw new Exception("Erro ao executar o método bubbleSort: "+e.getMessage());
        }
    }

    @Override
    public void insertionSort(TipoDicionario tipoDicionario) throws Exception {
        try {
            String[] listaDesorganizada;

            Date data = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY HH:mm ");
            String relatorio = "Método de ordenacao InsertionSort ==============\nData e Hora da Execução: "+sdf.format(data)+"\n";

            if(tipoDicionario == TipoDicionario.PORTUGUES){
                listaDesorganizada = Dicionario.getDicionarioPortuguesCru();
            } else {
                listaDesorganizada = Dicionario.getDicionarioEstrangeiroCru();
            }

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
                //if (cont%1000==0)System.out.println("Contador de troca feita pelo insertion: "+ cont);
            }
            long finalNano =  System.nanoTime();
            long finalMilli = System.currentTimeMillis();

            long tempoExecucaoNano = finalNano - inicioNano;
            long tempoExecucaoMilli = finalMilli - inicioMilli;

            salvarDicionarioOrganizado(tipoDicionario, listaDesorganizada);

            relatorio += "Tempo de execucao (nanosegundos): "+ tempoExecucaoNano+
                    "\nTempo de execucao (millisegundos): "+ tempoExecucaoMilli+
                    "\nTempo de execucao (segundos): "+ tempoExecucaoMilli/1000+
                    "\nNumero de trocas feitas por este método de organização: "+cont;

            //Resultado.salvarTXT(listaDesorganizada,"InsertionSort");
            Resultado.relatorioTempoOrganizado(relatorio,"InsertionSort");

        }catch (Exception e) {
            throw new Exception("Erro ao executar o método insertionSort: "+e.getMessage());
        }
    }

    @Override
    public void mergeSort(TipoDicionario tipoDicionario) throws Exception {
        try {
            Date data = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY HH:mm ");
            String relatorio = "Método de ordenacao MergeSort ==============\nData e Hora da Execução: "+sdf.format(data)+"\n";

            long inicioNano = System.nanoTime();
            long inicioMilli = System.currentTimeMillis();

            String[] listaDesorganizada;
            if(tipoDicionario == TipoDicionario.PORTUGUES){
                listaDesorganizada = Dicionario.getDicionarioPortuguesCru();
            } else {
                listaDesorganizada = Dicionario.getDicionarioEstrangeiroCru();
            }
            long inicio = System.nanoTime();

            mergeSort(listaDesorganizada,listaDesorganizada.length);

            long finalNano =  System.nanoTime();
            long finalMilli = System.currentTimeMillis();

            long tempoExecucaoNano = finalNano - inicioNano;
            long tempoExecucaoMilli = finalMilli - inicioMilli;

            salvarDicionarioOrganizado(tipoDicionario, listaDesorganizada);

            relatorio += "Tempo de execucao (nanosegundos): "+ tempoExecucaoNano+
                    "\nTempo de execucao (millisegundos): "+ tempoExecucaoMilli+
                    "\nTempo de execucao (segundos): "+ tempoExecucaoMilli/1000;

            Resultado.relatorioTempoOrganizado(relatorio,"MergeSort");

        }catch (Exception e) {
            throw e;
        }
    }

    private static void mergeSort(String[] vetor, int tamVetor) {
        if (tamVetor < 2) {
            return;
        }
        int mid = tamVetor / 2;
        String[] l = new String[mid];
        String[] r = new String[tamVetor - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = vetor[i];
        }
        for (int i = mid; i < tamVetor; i++) {
            r[i - mid] = vetor[i];
        }
        mergeSort(l, mid);
        mergeSort(r, tamVetor - mid);

        merge(vetor, l, r, mid, tamVetor - mid);
    }

    private static void merge(String[] vetor, String[] l, String[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i].length() <= r[j].length()) {
                vetor[k++] = l[i++];
            }
            else {
                vetor[k++] = r[j++];
            }
        }
        while (i < left) {
            vetor[k++] = l[i++];
        }
        while (j < right) {
            vetor[k++] = r[j++];
        }
    }

    @Override
    public void quickSort(TipoDicionario tipoDicionario) throws Exception {
        try {
            String[] listaDesorganizada;
            if(tipoDicionario == TipoDicionario.PORTUGUES){
                listaDesorganizada = Dicionario.getDicionarioPortuguesCru();
            } else {
                listaDesorganizada = Dicionario.getDicionarioEstrangeiroCru();
            }
            long inicio = System.nanoTime();




            long tempoDeExecucao = inicio - System.nanoTime();

            salvarDicionarioOrganizado(tipoDicionario, listaDesorganizada);

        }catch (Exception e) {

        }
    }

    private void salvarDicionarioOrganizado(TipoDicionario tipoDicionario, String[] listaOrganizada)throws Exception {
        try{
            if (tipoDicionario == TipoDicionario.PORTUGUES){
                Dicionario.setDicionarioPortugues(listaOrganizada);
            } else {
                Dicionario.setDicionarioEstrangeiro(listaOrganizada);
            }
        }catch (Exception e){
            throw e;
        }
    }

}
