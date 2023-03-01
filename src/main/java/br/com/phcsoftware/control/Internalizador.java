package br.com.phcsoftware.control;

import java.io.File;

public class Internalizador {

    IControleArquivoIn control;
    public Internalizador() {
        this.control = new ControleArquivoIn();
    }

    public void start() throws Exception {

        String pastaEntrada = "";
        System.out.println("Iniciando monitoramento na pasta de entrada configurada: "+pastaEntrada);
        try {
            while (true) {
                //dir de entrada do Servico
                File dirEntrada = new File(pastaEntrada);
                //Lista todos os arquivos que estão na pasta de entrada
                File[] arquivos = dirEntrada.listFiles();

                if (arquivos.length > 0) {
                    System.out.printf("Foi encontrado %d arquivos na pasta de entrada\n",arquivos.length);

                    for (File fileTemp : arquivos) {
                        System.out.println("Arquivo identificado: " + fileTemp.getName());
                        control.internalizarArquivo(fileTemp);
                    }
                }
                Thread.sleep(3500);
            }
        } catch (Exception e) {
            throw new Exception(e.getCause() + ". Não foi possivel realizar leitura da pasta de entrada: " + e.getMessage());
        }
    }

}
