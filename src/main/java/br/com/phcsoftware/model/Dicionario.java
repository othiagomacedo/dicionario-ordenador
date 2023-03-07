package br.com.phcsoftware.model;

public class Dicionario {

    static String[] dicionarioPortuguesOrganizado;
    static String[] dicionarioEstrangeiroOrganizado;
    static String[] dicionarioPortuguesCru;
    static String[] dicionarioEstrangeiroCru;

    private Dicionario() {}

    //Get e set dos Dicionarios já organizados
    public static String[] getDicionarioPortugues() {
        return dicionarioPortuguesOrganizado;
    }

    public static void setDicionarioPortugues(String[] dicionarioPortugues) {
        Dicionario.dicionarioPortuguesOrganizado = dicionarioPortugues;
    }

    public static String[] getDicionarioEstrangeiro() {
        return dicionarioEstrangeiroOrganizado;
    }

    public static void setDicionarioEstrangeiro(String[] dicionarioEstrangeiroOrganizado) {
        Dicionario.dicionarioEstrangeiroOrganizado = dicionarioEstrangeiroOrganizado;
    }


    //Get e set dos dos dicionados sem organizar
    public static String[] getDicionarioPortuguesCru() {
        return dicionarioPortuguesCru;
    }

    public static void setDicionarioPortuguesCru(String[] dicionarioPortuguesCru) {
        Dicionario.dicionarioPortuguesCru = dicionarioPortuguesCru;
    }

    public static String[] getDicionarioEstrangeiroCru() {
        return dicionarioEstrangeiroCru;
    }

    public static void setDicionarioEstrangeiroCru(String[] dicionarioEstrangeiroCru) {
        Dicionario.dicionarioEstrangeiroCru = dicionarioEstrangeiroCru;
    }
}
