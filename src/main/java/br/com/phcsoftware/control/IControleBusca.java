package br.com.phcsoftware.control;

public interface IControleBusca {
    int buscaBinaria(String palavraBuscada) throws Exception;

    int buscaSequencial(String palavraBuscada) throws Exception;
}
