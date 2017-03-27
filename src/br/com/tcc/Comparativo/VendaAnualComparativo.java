/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.Comparativo;

import br.com.tcc.graficoFinanceiro.*;
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
public class VendaAnualComparativo extends JFrame{
    Connection con = new ConnectionFactory().getConnection();
    
    public VendaAnualComparativo() throws SQLException{
// 
         String query = "SELECT YEAR(dataVenda) as ano, SUM(totalVenda) as total FROM vendaregistro WHERE YEAR(dataVenda) = YEAR(CURRENT_DATE) OR YEAR(dataVenda) = YEAR(CURRENT_DATE)-1 GROUP BY ano";
        JDBCCategoryDataset dataset = new JDBCCategoryDataset(con,query);
        JFreeChart chart = ChartFactory.createBarChart("Comparação com Ano passado", "Ano", "Total", dataset, PlotOrientation.VERTICAL,false,true,true);
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
        new VendaAnualComparativo().setVisible(true);
        
    }
    
}
