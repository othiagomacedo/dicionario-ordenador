package br.com.phcsoftware.processados;

public interface IProcessado {


    void armazenaProcessado(String[] vetorOrganizado) throws Exception;

    String[] vetorOrganizadoArmazenado() throws Exception;
}
