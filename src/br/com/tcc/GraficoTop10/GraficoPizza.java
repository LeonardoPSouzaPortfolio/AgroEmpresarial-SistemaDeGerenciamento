/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.GraficoTop10;

import Conexao.ConnectionFactory;
import Conexao.ConnectionFactory;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;

/**
 *
 * @author Leonardo P Souza
 */
public class GraficoPizza extends JFrame {

    Connection con = new ConnectionFactory().getConnection();
    DefaultPieDataset my_pie_chart_dataset = new DefaultPieDataset();

    public GraficoPizza() throws SQLException {
        super("Primeiro Grafico");
        // Cria um dataSet para inserir os dados que serão passados para a criação dos gráficos
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        Statement stmt = con.createStatement();
        try {
            ResultSet query_set = stmt.executeQuery(
                    "SELECT produto.descricao , SUM(vendadetalhe.qtde) AS `qtde` FROM produto INNER JOIN vendadetalhe"
                            + " ON produto.ID = vendadetalhe.idProduto GROUP BY produto.descricao"
                            + " ORDER BY `qtde` DESC LIMIT 10");
            while (query_set.next()) {
                String produto = query_set.getString("descricao");
                int quantidade = query_set.getInt("qtde");
                my_pie_chart_dataset.setValue(produto, quantidade);

            }
            JFreeChart PieChartObject = ChartFactory.createPieChart(
                    "Gráfico Pizza \n10 Mais vendidos",
                    my_pie_chart_dataset, true, true, false);
            query_set.close();
            stmt.close();
            con.close();

            /* Specify dimensions and quality factor for Pie Chart */
            this.add(new ChartPanel(PieChartObject));
            this.setVisible(true);
            this.pack();
        } catch (Exception i) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) throws SQLException {
        new GraficoPizza().setVisible(true);
    }

}
