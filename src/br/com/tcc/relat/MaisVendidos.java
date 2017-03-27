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
import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo P Souza
 */
public class MaisVendidos {

    public static void main(String[] args) throws Exception {
        /* Create Connection objects */
        Connection con = new ConnectionFactory().getConnection();
        Statement stmt = con.createStatement();
        /* Define the SQL query */
        ResultSet query = stmt.executeQuery("SELECT produto.descricao , SUM(vendadetalhe.qtde) AS qtde FROM produto INNER JOIN vendadetalhe"
                + " ON produto.ID = vendadetalhe.idProduto GROUP BY produto.descricao"
                + " ORDER BY qtde DESC LIMIT 30");
        /* Step-2: Initialize PDF documents - logical objects */
        Document PDFLogReport = new Document();
        PdfWriter.getInstance(PDFLogReport, new FileOutputStream("../../MaisVendidos.pdf"));
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
        Paragraph tableHeader = new Paragraph("30 Mais vendidos");

        PdfPCell header = new PdfPCell(tableHeader);

        // Definindo que o header vai ocupar as 2 colunas
        header.setColspan(2);
        // Definindo alinhamento do header
        header.setHorizontalAlignment(Paragraph.ALIGN_CENTER);
        // Adicionando o header à tabela

        Font fonte = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.BLACK);

        LogTable.addCell(header);
        LogTable.addCell(new Paragraph("Produto ", fonte));
        LogTable.addCell(new Paragraph("Vendidos", fonte));
        //create a cell object  
//         PdfPCell table_cell;  
        while (query.next()) {
            String produto = query.getString("descricao");
            LogTable.addCell(new Paragraph(produto));
            String quantidade = query.getString("qtde");
            LogTable.addCell(new Paragraph(quantidade));
        }
        /* Attach report table to PDF */
        PDFLogReport.add(LogTable);
        PDFLogReport.close();
        /* Close all DB related objects */
        query.close();
        stmt.close();
        con.close();
        String file;
        file = "C:\\Users\\Leonardo P Souza\\Desktop\\Relat\\MaisVendidos.pdf";
        //Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL " + file);
        File pdf = new File("../../MaisVendidos.pdf");
        try {
            Desktop.getDesktop().open(pdf);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao abrir relatório: " + ex);
        }
    }
}
