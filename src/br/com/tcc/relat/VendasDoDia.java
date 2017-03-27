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
public class VendasDoDia {

    public static void main(String[] args) throws Exception {
        /* Create Connection objects */
        Connection con = new ConnectionFactory().getConnection();
        Statement stmt = con.createStatement();
        /* Define the SQL query */
        ResultSet query = stmt.executeQuery("SELECT cliente.nome, funcionario.nome, tipopagamento.descricao, vendaregistro.dataVenda, vendaregistro.vlrSugerido, vendaregistro.totalVenda, vendaregistro.parcela, vendaregistro.1vencimento, vendaregistro.ativo FROM vendaregistro as vendaregistro INNER JOIN cliente as cliente ON (vendaregistro.idCliente = cliente.id) \n"
                + "INNER JOIN funcionario as funcionario ON (vendaregistro.idFuncionario = funcionario.id) INNER JOIN tipopagamento as tipopagamento ON (vendaregistro.idTipoPagamento = tipopagamento.id) WHERE  dataVenda = CURRENT_DATE");
        /* Step-2: Initialize PDF documents - logical objects */
        Document PDFLogReport = new Document();
        PdfWriter.getInstance(PDFLogReport, new FileOutputStream("../../VendaDoDia.pdf"));
        PDFLogReport.open();

        Paragraph cabecalho = new Paragraph("AGRO EMPRESARIAL - SISTEMA DE GERENCIAMENTO\n"
                + "RUA GONÇALVES CHAVES, 602 PELOTAS/RS\n"
                + "FONE:(53) 3232-3232 BAIRRO: CENTRO\n"
                + "CNPJ: 12.345.678/1011-12\n\n\n");
        cabecalho.setAlignment(Element.ALIGN_CENTER);
        PDFLogReport.add(cabecalho);
        //we have two columns in our table  
        PdfPTable LogTable = new PdfPTable(9);

        // Título para a tabela
        Paragraph tableHeader = new Paragraph("Relatório Venda do Dia");

        PdfPCell header = new PdfPCell(tableHeader);

        // Definindo que o header vai ocupar as 2 colunas
        header.setColspan(9);
        // Definindo alinhamento do header
        header.setHorizontalAlignment(Paragraph.ALIGN_CENTER);
        // Adicionando o header à tabela

        Font fonte = new Font(Font.FontFamily.HELVETICA, 7, Font.BOLD, BaseColor.BLACK);
        Font fonteDados = new Font(Font.FontFamily.TIMES_ROMAN, 6, Font.NORMAL, BaseColor.BLACK);

        LogTable.addCell(header);
        LogTable.addCell(new Paragraph("Cliente ", fonte));
        LogTable.addCell(new Paragraph("Funcionario", fonte));
        LogTable.addCell(new Paragraph("Tipo Pagamento", fonte));
        LogTable.addCell(new Paragraph("Data Compra", fonte));
        LogTable.addCell(new Paragraph("Valor Sugerido", fonte));
        LogTable.addCell(new Paragraph("Valor da Venda", fonte));
        LogTable.addCell(new Paragraph("Parcelas", fonte));
        LogTable.addCell(new Paragraph("1º Vencimento", fonte));
        LogTable.addCell(new Paragraph("Status da Compra", fonte));
        //create a cell object  
//         PdfPCell table_cell;  
        while (query.next()) {
            String cliente = query.getString("cliente.nome");
            LogTable.addCell(new Paragraph(cliente, fonteDados));
            String funcionario = query.getString("funcionario.nome");
            LogTable.addCell(new Paragraph(funcionario, fonteDados));
            String tipoPagamento = query.getString("tipopagamento.descricao");
            LogTable.addCell(new Paragraph(tipoPagamento, fonteDados));
            String dataVenda = query.getString("dataVenda");
            LogTable.addCell(new Paragraph(dataVenda, fonteDados));
            String vlrSugerido = query.getString("vlrSugerido");
            LogTable.addCell(new Paragraph(vlrSugerido, fonteDados));
            String totalVenda = query.getString("totalVenda");
            LogTable.addCell(new Paragraph(totalVenda, fonteDados));
            String parcela = query.getString("parcela");
            LogTable.addCell(new Paragraph(parcela, fonteDados));
            String vencimento = query.getString("1vencimento");
            LogTable.addCell(new Paragraph(vencimento, fonteDados));
            String ativo = query.getString("ativo");
            LogTable.addCell(new Paragraph(ativo, fonteDados));
        }
        /* Attach report table to PDF */
        PDFLogReport.add(LogTable);
        PDFLogReport.close();
        /* Close all DB related objects */
        query.close();
        stmt.close();
        con.close();
        String file;
        file = "C:\\Users\\Leonardo P Souza\\Desktop\\Relat\\VendaDoDia.pdf";
        //Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL " + file);
        File pdf = new File("../../VendaDoDia.pdf");
        try {
            Desktop.getDesktop().open(pdf);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao abrir relatório: " + ex);
        }
    }
}
