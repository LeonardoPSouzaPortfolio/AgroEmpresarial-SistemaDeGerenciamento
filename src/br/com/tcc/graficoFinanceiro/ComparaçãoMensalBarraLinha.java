/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.graficoFinanceiro;

import Conexao.ConnectionFactory;
import java.awt.Color;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.NumberAxis3D;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 * A simple demonstration application showing how to create a dual axis chart based on data
 * from two {@link CategoryDataset} instances.
 *
 */
public class ComparaçãoMensalBarraLinha extends ApplicationFrame {

    Connection con = new ConnectionFactory().getConnection();
    public ComparaçãoMensalBarraLinha(final String title) throws SQLException {

        super(title);
        String query = "SELECT MONTH(dataVenda)  AS mes, SUM(totalVenda) as Vendas FROM vendaregistro WHERE YEAR(dataVenda) = YEAR(CURRENT_DATE) GROUP BY mes ORDER BY mes";
        JDBCCategoryDataset dataset = new JDBCCategoryDataset(con,query);
        String query2 = "SELECT MONTH(dataEntrada)  AS mes, SUM(vlrTotal) as Compras FROM entradaprodutoregistro WHERE YEAR(dataEntrada) = YEAR(CURRENT_DATE) GROUP BY mes ORDER BY mes";
        JDBCCategoryDataset dataset2 = new JDBCCategoryDataset(con,query2);
//        final CategoryDataset dataset1 = createDataset1();
        
        

        // create the chart...
        final JFreeChart chart = ChartFactory.createBarChart3D(
            "Gráficos de Entrada e Saída",  // chart title
            "Meses",         // domain axis label
            "Valor Compra/Venda",            // range axis label
//            dataset1,           // data
            dataset,           // data
            PlotOrientation.VERTICAL,
            true,               // include legend
            true,
            false
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...

        // set the background color for the chart...
        chart.setBackgroundPaint(new Color(0xCC, 0xFF, 0xCC));
//        chart.getLegend().setAnchor(Legend.SOUTH);

        // get a reference to the plot for further customisation...
        final CategoryPlot plot = chart.getCategoryPlot();
//        plot.setDomainAxisLocation(AxisLocation.BOTTOM_OR_LEFT);
//        plot.setRangeAxisLocation(AxisLocation.TOP_OR_LEFT);
        final CategoryItemRenderer renderer1 = plot.getRenderer();
        renderer1.setSeriesPaint(0, Color.red);
        renderer1.setSeriesPaint(1, Color.yellow);
        renderer1.setSeriesPaint(2, Color.green);
//        final CategoryDataset dataset2 = createDataset2();
//        final ValueAxis axis2 = new NumberAxis3D("Valor R$");
//        plot.setRangeAxis(1, axis2);
        
        plot.setDataset(1, dataset2);
//        plot.mapDatasetToRangeAxis(1, 1);
        
        final CategoryItemRenderer renderer2 = new LineAndShapeRenderer();
        renderer2.setSeriesPaint(0, Color.blue);
        plot.setRenderer(1, renderer2);

        plot.setDatasetRenderingOrder(DatasetRenderingOrder.REVERSE);
        // OPTIONAL CUSTOMISATION COMPLETED.

        // add the chart to a panel...
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);

    }

    // ****************************************************************************
    // * JFREECHART DEVELOPER GUIDE                                               *
    // * The JFreeChart Developer Guide, written by David Gilbert, is available   *
    // * to purchase from Object Refinery Limited:                                *
    // *                                                                          *
    // * http://www.object-refinery.com/jfreechart/guide.html                     *
    // *                                                                          *
    // * Sales are used to provide funding for the JFreeChart project - please    * 
    // * support us so that we can continue developing free software.             *
    // ****************************************************************************
    
    /**
     * Creates a sample dataset.
     *
     * @return  The dataset.
     */
//    private CategoryDataset createDataset1() {
//
//        // row keys...
//        final String series1 = "Mes";
//
//        // column keys...
//        final String category1 = "Janeiro";
//        final String category2 = "Fevereiro";
//        final String category3 = "Março";
//        final String category4 = "Abril";
//        final String category5 = "Maio";
//        final String category6 = "Junho";
//        final String category7 = "Julho";
//        final String category8 = "Agosto";
//        final String category9 = "Setembro";
//        final String category10 = "Outubro";
//        final String category11 = "Novambro";
//        final String category12 = "Dezembro";
//
//        // create the dataset... Valor
//        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//
//        dataset.addValue(1000.0, series1, category1);
//        dataset.addValue(2000.0, series1, category2);
//        dataset.addValue(3000.0, series1, category3);
//        dataset.addValue(4000.0, series1, category4);
//        dataset.addValue(5000.0, series1, category5);
//        dataset.addValue(6000.0, series1, category6);
//        dataset.addValue(7000.0, series1, category7);
//        dataset.addValue(8000.0, series1, category8);
//        dataset.addValue(9000.0, series1, category9);
//        dataset.addValue(10000.0, series1, category10);
//        dataset.addValue(11000.0, series1, category11);
//        dataset.addValue(12000.0, series1, category12);
//
//        return dataset;
//
//    }

    /**
     * Creates a sample dataset. 
     *
     * @return  The dataset.
     */
//    private CategoryDataset createDataset2() {
//
//        // row keys...
//        final String series1 = "Meta";
//        
//
//
//        // column keys...
//        final String category1 = "1";
//        final String category2 = "2";
//        final String category3 = "3";
//        final String category4 = "4";
//        final String category5 = "5";
//        final String category6 = "6";
//        final String category7 = "7";
//        final String category8 = "8";
//        final String category9 = "9";
//        final String category10 = "10";
//        final String category11 = "11";
//        final String category12 = "12";
//
//        // create the dataset... Metas
//        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//
//        dataset.addValue(1000.0, series1, category1);
//        dataset.addValue(3000.0, series1, category2);
//        dataset.addValue(4000.0, series1, category3);
//        dataset.addValue(5000.0, series1, category4);
//        dataset.addValue(6000.0, series1, category5);
//        dataset.addValue(4000.0, series1, category6);
//        dataset.addValue(8000.0, series1, category7);
//        dataset.addValue(8000.0, series1, category8);
//        dataset.addValue(9000.0, series1, category9);
//        dataset.addValue(12000.0, series1, category10);
//        dataset.addValue(11000.0, series1, category11);
//        dataset.addValue(12000.0, series1, category12);
//
//        return dataset;
//
//    }

    /**
     * Starting point for the demonstration application.
     *
     * @param args  ignored.
     */
    public static void main(final String[] args) throws SQLException {

        final ComparaçãoMensalBarraLinha demo = new ComparaçãoMensalBarraLinha("Gráficos de Entrada e Saída");
        demo.setExtendedState(MAXIMIZED_BOTH);
//        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

    }

}