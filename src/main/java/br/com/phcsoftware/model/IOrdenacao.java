package br.com.phcsoftware.model;

public interface IOrdenacao {
    void selectionSort(String[] listaDesorganizada) throws Exception;

    void bubbleSort(String[] listaDesorganizada) throws Exception;

    void insertionSort(String[] listaDesorganizada) throws Exception;

    void mergeSort(String[] listaDesorganizada) throws Exception;

    void quickSort(String[] listaDesorganizada) throws Exception;

    String[] getParteListaOrdenada(String[] vetorOrganizadoPorTamanhoPalavra, int tamanhoPalavraBuscada) throws Exception;
}
