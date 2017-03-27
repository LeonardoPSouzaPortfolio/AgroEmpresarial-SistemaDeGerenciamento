/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.graficoFinanceiro;

import br.com.tcc.GraficoTop10.*;
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
public class VendasMensalPizza extends JFrame {

    Connection con = new ConnectionFactory().getConnection();
    DefaultPieDataset my_pie_chart_dataset = new DefaultPieDataset();

    public VendasMensalPizza() throws SQLException {
        super("Gráfico Mensal");
        // Cria um dataSet para inserir os dados que serão passados para a criação dos gráficos
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        Statement stmt = con.createStatement();
        try {
            ResultSet query_set = stmt.executeQuery(
                    "SELECT MONTH(dataVenda) as mes, SUM(totalVenda) as total FROM vendaregistro WHERE YEAR(dataVenda) = YEAR(CURRENT_DATE) GROUP BY mes");
            while (query_set.next()) {
                String mes = query_set.getString("mes");
                int total = query_set.getInt("total");
                int mesInteiro = Integer.parseInt(mes);
                 switch(mesInteiro)
        {
           case 1: mes = "Janeiro";my_pie_chart_dataset.setValue(mes, total);break; 
           case 2: mes = "Fevereiro";my_pie_chart_dataset.setValue(mes, total);break;
           case 3: mes = "Março";my_pie_chart_dataset.setValue(mes, total);break;
           case 4: mes = "Abril";my_pie_chart_dataset.setValue(mes, total);break;
           case 5: mes = "Maio";my_pie_chart_dataset.setValue(mes, total);break;
           case 6: mes = "Junho";my_pie_chart_dataset.setValue(mes, total);break;
           case 7: mes = "Julho";my_pie_chart_dataset.setValue(mes, total);break;
           case 8: mes = "Agosto";my_pie_chart_dataset.setValue(mes, total);break;
           case 9: mes = "Setembro";my_pie_chart_dataset.setValue(mes, total);break;
           case 10: mes = "Outubro";my_pie_chart_dataset.setValue(mes, total);break;
           case 11: mes = "Novembro";my_pie_chart_dataset.setValue(mes, total);break;
           case 12: mes = "Dezembro";my_pie_chart_dataset.setValue(mes, total);break;
        }
                

            }
            JFreeChart PieChartObject = ChartFactory.createPieChart(
                    "Gráfico Mensal",
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
        new VendasMensalPizza().setVisible(true);
    }

}
