/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.relat;

import Conexao.ConnectionFactory;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import static java.awt.BorderLayout.CENTER;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo P Souza
 */
public class VendasDoMes {

    public static void main(String[] args) throws Exception{
         /* Create Connection objects */  
         Connection con = new ConnectionFactory().getConnection(); 
         Statement stmt = con.createStatement();  
         Calendar cal = Calendar.getInstance();   
        int ano = cal.get(Calendar.YEAR); 
         /* Define the SQL query */  
         ResultSet query = stmt.executeQuery("SELECT MONTH(dataVenda) as mes, SUM(totalVenda) as total FROM vendaregistro WHERE YEAR(dataVenda) = YEAR(CURRENT_DATE) GROUP BY mes");  
         /* Step-2: Initialize PDF documents - logical objects */  
         Document PDFLogReport = new Document();  
         PdfWriter.getInstance(PDFLogReport, new FileOutputStream("../../VendaDoMes"+ano+".pdf"));  
         PDFLogReport.open();       
         
         Paragraph cabecalho = new Paragraph("AGRO EMPRESARIAL - SISTEMA DE GERENCIAMENTO\n"
                    + "RUA GONÇALVES CHAVES, 602 PELOTAS/RS\n"
                    + "FONE:(53) 3232-3232 BAIRRO: CENTRO\n"
                    + "CNPJ: 12.345.678/1011-12\n\n\n");
            cabecalho.setAlignment(Element.ALIGN_CENTER);
            PDFLogReport.add(cabecalho);
         //we have two columns in our table  
         PdfPTable LogTable = new PdfPTable(2);  
         
         
         // Título para a tabela
        Paragraph tableHeader = new Paragraph("Relatório Mensal -" + ano);
        
         PdfPCell header = new PdfPCell(tableHeader);
         
        // Definindo que o header vai ocupar as 2 colunas
        header.setColspan(2);
        // Definindo alinhamento do header
        header.setHorizontalAlignment(Paragraph.ALIGN_CENTER);
        // Adicionando o header à tabela
        
        Font fonte = new Font(Font.FontFamily.HELVETICA, 7, Font.BOLD, BaseColor.BLACK);
        Font fonteDados = new Font(Font.FontFamily.TIMES_ROMAN, 6, Font.NORMAL, BaseColor.BLACK);
                
        LogTable.addCell(header);
        LogTable.addCell(new Paragraph("Mes ",fonte));
        LogTable.addCell(new Paragraph("Total",fonte));
        //create a cell object  
//         PdfPCell table_cell;  
         while (query.next()) {          
                 String mes = query.getString("mes");
                 int mesInteiro = Integer.parseInt(mes);
                 switch(mesInteiro)
        {
           case 1: mes = "Janeiro";LogTable.addCell(new Paragraph(mes,fonteDados));break; 
           case 2: mes = "Fevereiro";LogTable.addCell(new Paragraph(mes,fonteDados));break;
           case 3: mes = "Março";LogTable.addCell(new Paragraph(mes,fonteDados));break;
           case 4: mes = "Abril";LogTable.addCell(new Paragraph(mes,fonteDados));break;
           case 5: mes = "Maio";LogTable.addCell(new Paragraph(mes,fonteDados));break;
           case 6: mes = "Junho";LogTable.addCell(new Paragraph(mes,fonteDados));break;
           case 7: mes = "Julho";LogTable.addCell(new Paragraph(mes,fonteDados));break;
           case 8: mes = "Agosto";LogTable.addCell(new Paragraph(mes,fonteDados));break;
           case 9: mes = "Setembro";LogTable.addCell(new Paragraph(mes,fonteDados));break;
           case 10: mes = "Outubro";LogTable.addCell(new Paragraph(mes,fonteDados));break;
           case 11: mes = "Novembro";LogTable.addCell(new Paragraph(mes,fonteDados));break;
           case 12: mes = "Dezembro";LogTable.addCell(new Paragraph(mes,fonteDados));break;
        }
                   
                 String total=query.getString("total");  
                 LogTable.addCell(new Paragraph(total,fonteDados));
                 }  
         /* Attach report table to PDF */  
         PDFLogReport.add(LogTable);              
         PDFLogReport.close();  
         /* Close all DB related objects */  
         query.close();  
         stmt.close();   
         con.close(); 
         String file;
            file = "C:\\Users\\Leonardo P Souza\\Desktop\\Relat\\VendaDoMes"+ano+".pdf";  
            //Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL " + file);
         File pdf = new File("../../VendaDoMes"+ano+".pdf");
        try {
            Desktop.getDesktop().open(pdf);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao abrir relatório: " + ex);
        }
     }  
 }  
