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
public class BalancoAnual {

    public static void main(String[] args) throws Exception {
        /* Create Connection objects */
        Connection con = new ConnectionFactory().getConnection();
        Statement stmt = con.createStatement();
        /* Define the SQL query */
        ResultSet query = stmt.executeQuery("SELECT produto.ID, produto.descricao, produto.numEstoque, produto.numEstoqueCritico, unidade.descricao, fornecedor.nome FROM produto as produto INNER JOIN unidade as unidade ON (produto.idUnidade = unidade.id) INNER JOIN fornecedor as fornecedor ON (produto.idFornecedor = fornecedor.id)");
        /* Step-2: Initialize PDF documents - logical objects */
        Document PDFLogReport = new Document();
        //PdfWriter.getInstance(PDFLogReport, new FileOutputStream("C:\\Users\\Leonardo P Souza\\Desktop\\Relat\\Balanco.pdf"));
        PdfWriter.getInstance(PDFLogReport, new FileOutputStream("../../RelatBalanco.pdf"));
        PDFLogReport.open();

        Paragraph cabecalho = new Paragraph("AGRO EMPRESARIAL - SISTEMA DE GERENCIAMENTO\n"
                + "RUA GONÇALVES CHAVES, 602 PELOTAS/RS\n"
                + "FONE:(53) 3232-3232 BAIRRO: CENTRO\n"
                + "CNPJ: 12.345.678/1011-12\n\n\n");
        cabecalho.setAlignment(Element.ALIGN_CENTER);
        PDFLogReport.add(cabecalho);
        //we have two columns in our table  
        PdfPTable LogTable = new PdfPTable(6);

        // Título para a tabela
        Paragraph tableHeader = new Paragraph("Balanço Anual");

        PdfPCell header = new PdfPCell(tableHeader);

        // Definindo que o header vai ocupar as 2 colunas
        header.setColspan(6);
        // Definindo alinhamento do header
        header.setHorizontalAlignment(Paragraph.ALIGN_CENTER);
        // Adicionando o header à tabela

        Font fonte = new Font(Font.FontFamily.HELVETICA, 7, Font.BOLD, BaseColor.BLACK);
        Font fonteDados = new Font(Font.FontFamily.TIMES_ROMAN, 6, Font.NORMAL, BaseColor.BLACK);
        LogTable.addCell(header);
        LogTable.addCell(new Paragraph("Produto ", fonte));
        LogTable.addCell(new Paragraph("Fornecedor", fonte));
        LogTable.addCell(new Paragraph("Unidade", fonte));
        LogTable.addCell(new Paragraph("Estoque", fonte));
        LogTable.addCell(new Paragraph("Estoque Crítico", fonte));
        LogTable.addCell(new Paragraph("Quantidade", fonte));
        //create a cell object  
//         PdfPCell table_cell;  
        while (query.next()) {
            String produto = query.getString("descricao");
            LogTable.addCell(new Paragraph(produto, fonteDados));
            String fornecedor = query.getString("nome");
            LogTable.addCell(new Paragraph(fornecedor, fonteDados));
            String unidade = query.getString("unidade.descricao");
            LogTable.addCell(new Paragraph(unidade, fonteDados));
            String estoque = query.getString("numEstoque");
            LogTable.addCell(new Paragraph(estoque, fonteDados));
            String critico = query.getString("numEstoqueCritico");
            LogTable.addCell(new Paragraph(critico, fonteDados));
            LogTable.addCell(new Paragraph("       ", fonteDados));
        }
        /* Attach report table to PDF */
        PDFLogReport.add(LogTable);
        PDFLogReport.close();
        /* Close all DB related objects */
        query.close();
        stmt.close();
        con.close();
        String file;
        file = "C:\\Users\\Leonardo P Souza\\Desktop\\Relat\\Balanco.pdf";
        //Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL " + file);

        File pdf = new File("../../RelatBalanco.pdf");
        try {
            Desktop.getDesktop().open(pdf);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao abrir relatório: " + ex);
        }
    }
}
