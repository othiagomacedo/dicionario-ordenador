package br.com.phcsoftware.model;

public interface IOrdenacao {
    void selectionSort(TipoDicionario tipoDicionario) throws Exception;

    void bubbleSort(TipoDicionario tipoDicionario) throws Exception;

    void insertionSort(TipoDicionario tipoDicionario) throws Exception;

    void mergeSort(TipoDicionario tipoDicionario) throws Exception;

    void quickSort(TipoDicionario tipoDicionario) throws Exception;
}
