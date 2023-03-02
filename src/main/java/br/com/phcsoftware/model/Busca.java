package br.com.phcsoftware.model;

import br.com.phcsoftware.processados.IProcessado;
import br.com.phcsoftware.processados.Processado;

public class Busca{

    IProcessado lista;
    IOrdenacao ordem;
    private Busca() {
        this.ordem = new Ordenacao();
        this.lista = new Processado();
    }

    public static void buscaBinaria(String[] vetorPreOrganizado,String palavraBuscada) throws Exception{
        try{
            long start = System.nanoTime();
            int inicio = 0;
            int fim = vetorPreOrganizado.length - 1;
            boolean achou = false;
            int posAchou = 0;
            while (inicio <= fim) {
                int meio = (inicio + fim) / 2;

                int comparacao = palavraBuscada.compareTo(vetorPreOrganizado[meio]);

                if (comparacao == 0) {
                    posAchou = meio;
                    achou = true;
                    inicio = 1;
                    fim = 0;
                } else if (comparacao < 0) {
                    fim = meio - 1;
                } else {
                    inicio = meio + 1;
                }
            }
            long termino = System.nanoTime() - start;
            imprimirResultados("Binaria",termino,achou,posAchou,palavraBuscada);
        } catch (Exception e){
            throw new Exception("Nao foi possivel executar a busca binaria: "+e.getMessage());
        }
    }

    public static void buscaSequencial (String[] vetorPreOrganizado,String palavraBuscada) throws Exception{
        try{
            long start = System.nanoTime();
            boolean achou = false;
            int posAchou = 0;
            for (int i = 0; i < vetorPreOrganizado.length ; i++) {
                if (vetorPreOrganizado[i].equals(palavraBuscada)){
                    posAchou = i;
                    achou = true;
                    continue;
                }
            }
            long termino = System.nanoTime() - start;
            imprimirResultados("Sequencial",termino,achou,posAchou,palavraBuscada);
        } catch (Exception e){
            throw new Exception("Nao foi possivel executar a busca binaria: "+e.getMessage());
        }
    }

    private static void imprimirResultados(String tipoDeBusca, long tempoGastoMili, boolean achou, int posicaoAchada, String palavraBuscada) {
        System.out.println("\n-- Busca "+tipoDeBusca+" -------------");
        if (achou){
            System.out.println("Palavra "+palavraBuscada+" encontrada em "+posicaoAchada);
        } else {
            System.out.println("Palavra "+palavraBuscada+" nao encontrada");
        }
        System.out.println("Tempo de execucao da Busca "+tipoDeBusca+ " em mili segundos: "+tempoGastoMili);
    }
}
