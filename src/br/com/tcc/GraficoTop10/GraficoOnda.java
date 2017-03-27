/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.GraficoTop10;

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
public class GraficoOnda extends JFrame{
    Connection con = new ConnectionFactory().getConnection();
    
    public GraficoOnda() throws SQLException{
// 
         String query = "SELECT produto.descricao , SUM(vendadetalhe.qtde) AS `qtde` FROM produto INNER JOIN vendadetalhe ON produto.ID = vendadetalhe.idProduto GROUP BY produto.descricao ORDER BY `qtde` DESC LIMIT 10";
        JDBCCategoryDataset dataset = new JDBCCategoryDataset(con,query);
        JFreeChart chart = ChartFactory.createAreaChart("10 Mais vendidos", "Produtos", "Vendidos", dataset, PlotOrientation.VERTICAL,false,true,true);
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
        new GraficoOnda().setVisible(true);
        
    }
    
}
