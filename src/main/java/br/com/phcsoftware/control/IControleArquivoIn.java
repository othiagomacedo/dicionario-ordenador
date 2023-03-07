package br.com.phcsoftware.control;

import br.com.phcsoftware.model.TipoDicionario;

import java.io.File;

public interface IControleArquivoIn {
    void internalizarArquivo(File arquivoSelecionado, TipoDicionario tipoDicionario) throws Exception;
}
