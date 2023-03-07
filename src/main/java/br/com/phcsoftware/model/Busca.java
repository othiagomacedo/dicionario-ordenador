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

     public static void buscaBinariaHibrida(TipoDicionario tipoDicionario, String palavraBuscada)throws Exception{
        try{
            long start = System.nanoTime();
            String[] vetor;
            if (tipoDicionario == TipoDicionario.PORTUGUES){
                vetor=Dicionario.getDicionarioPortugues();
            } else {
                vetor=Dicionario.getDicionarioEstrangeiro();
            }

            int inicio = 0;
            int fim = vetor.length - 1;
            boolean achou = false;
            int posAchou = 0;
            int tamanhoPalavraBuscada = palavraBuscada.length();
            int meio = 0;

            while (inicio <= fim) {
                meio = (inicio + fim) / 2;

                int tamanhoElementoPosicaoAtual = vetor[meio].length();

                if (tamanhoElementoPosicaoAtual == tamanhoPalavraBuscada) {
                    posAchou = meio;
                    inicio = 1;
                    fim = 0;
                    //esse "achou" é apenas para achar o tamanho da palavra, e nao a palavra em si
                    achou = true;
                } else if (tamanhoElementoPosicaoAtual < tamanhoPalavraBuscada) {
                    fim = meio - 1;
                } else {
                    inicio = meio + 1;
                }
            }

            if(achou){
                //pega o range do vetor até o final
                fim = posAchou;
                int cont = posAchou;
                while(vetor[cont].length() == palavraBuscada.length()){
                    fim += 1;
                    cont += 1;
                }

                //pega o range do vetor até o inicio
                inicio = posAchou;
                cont = posAchou;
                while(vetor[cont].length() == palavraBuscada.length()){
                    inicio -= 1;
                    cont -= 1;
                }
            }

            if (achou){
                //agora o achou vai contar se de fato a palavra existe ou não, se der true, é porque a palavra existe dentro do range delimitado no if anterior
                achou = false;
                for (int i = inicio; i <= fim ; i++){
                    if (vetor[i].equals(palavraBuscada)){
                        //com o achou agora conta para palavra encontrada, se de fato a palavra existe, vai cair nesse if e o achou recebe true
                        posAchou = i;
                        achou = true;
                    }
                }
            }

            long termino = System.nanoTime() - start;
            imprimirResultados("Binaria",termino,achou,posAchou,palavraBuscada);
        }catch (Exception e){
            throw new Exception("Nao foi possivel executar a busca binaria: "+e.getMessage());
        }
    }

    public static void buscaSequencial (TipoDicionario tipoDicionario,String palavraBuscada) throws Exception{
        try{
            long start = System.nanoTime();
            String[] vetor;
            if (tipoDicionario == TipoDicionario.PORTUGUES){
                vetor=Dicionario.getDicionarioPortugues();
            } else {
                vetor=Dicionario.getDicionarioEstrangeiro();
            }
            boolean achou = false;
            int posAchou = 0;
            for (int i = 0; i < vetor.length ; i++) {
                if (vetor[i].equals(palavraBuscada)){
                    posAchou = i;
                    achou = true;
                    break;
                }
            }
            long termino = System.nanoTime() - start;
            imprimirResultados("Sequencial",termino,achou,posAchou,palavraBuscada);
        } catch (Exception e){
            throw new Exception("Nao foi possivel executar a busca sequencial: "+e.getMessage());
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
