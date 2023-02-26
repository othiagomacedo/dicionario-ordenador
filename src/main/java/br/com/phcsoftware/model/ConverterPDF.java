/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.phcsoftware.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 *
 * @author Pedro Augusto
 */
public class ConverterPDF implements IConverterPDF{

    public ConverterPDF() {
    }
    
    @Override
    public void ConverterPDF(String arquivoPDF) throws FileNotFoundException, IOException{
        //Configurar path do arquivo aqui
        String inputFile = "caminho/do/arquivo/exemplo.txt";
        String outputFile = "saida/do/caminho/do/arquivo/exemplo.txt";
    
         // Ler o inputFile
        FileReader fileReader = new FileReader(inputFile);
        StringBuilder sb;
        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            sb = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        }
        // Criar um novo documento pdf e adicionar uma página
        try ( 
                PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);
            
            // Cria um novo "fluxo de conteúdo(nova instância)" e adicione o texto à página
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.beginText();
            contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
            contentStream.newLineAtOffset(50, 700);
            contentStream.showText(sb.toString());
            contentStream.endText();
            
            // Salvar e fechar
            document.save(outputFile);
            document.close();
        }
    }
}


