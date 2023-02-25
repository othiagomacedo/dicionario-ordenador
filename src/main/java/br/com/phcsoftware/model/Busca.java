package br.com.phcsoftware.model;

import br.com.phcsoftware.processados.IProcessado;
import br.com.phcsoftware.processados.Processado;

public class Busca implements IBusca{

    IProcessado lista;
    public Busca() {
        this.lista = new Processado();
    }

    @Override
    public int buscaBinaria(String palavraBuscada) throws Exception{
        try{
            long start = System.nanoTime();

            long termino = System.nanoTime() - start;
            return 0;
        } catch (Exception e){
            throw new Exception("Nao foi possivel executar a busca binaria: "+e.getMessage());
        }
    }

    @Override
    public int buscaSequencial (String palavraBuscada) throws Exception{
        try{
            long start = System.nanoTime();

            long termino = System.nanoTime() - start;
            return 0;
        } catch (Exception e){
            throw new Exception("Nao foi possivel executar a busca binaria: "+e.getMessage());
        }
    }
}
