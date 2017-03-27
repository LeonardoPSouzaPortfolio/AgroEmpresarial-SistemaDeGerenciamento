/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.graficoFinanceiro;

import br.com.tcc.GraficoTop10.*;
import Conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;

/**
 *
 * @author Leonardo P Souza
 */
public class VendasAnuallBarra extends JFrame{
    Connection con = new ConnectionFactory().getConnection();
    
    public VendasAnuallBarra() throws SQLException{
// 
         String query = "SELECT YEAR(dataVenda) as ano, SUM(totalVenda) as total FROM vendaregistro GROUP BY ano LIMIT 5";
        JDBCCategoryDataset dataset = new JDBCCategoryDataset(con,query);
        JFreeChart chart = ChartFactory.createBarChart("Vendas Anual", "Ano", "Total", dataset, PlotOrientation.VERTICAL,false,true,true);
//        BarRenderer renderer=null;
//        CategoryPlot plot = null;
//        renderer = new BarRenderer();
//        ChartFrame frame = new ChartFrame("10 Mais vendidos", chart);
        this.add(new ChartPanel(chart));
        this.setVisible(true);
        this.pack();
        con.close();
    }
    
    public static void main(String[] args) throws SQLException {
        new VendasAnuallBarra().setVisible(true);
        
    }
    
}
