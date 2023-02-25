package br.com.phcsoftware.model;

public interface IBusca {
    int buscaBinaria(String palavraBuscada) throws Exception;

    int buscaSequencial(String palavraBuscada) throws Exception;
}
