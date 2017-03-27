/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.graficoFinanceiro;


import java.awt.BorderLayout;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis3D;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class Metas extends JFrame {
    private JPanel jContentPane = null;
    private JTabbedPane jTabbedPane = null;
    private JPanel jPanel = null;
    private JPanel jPanel1 = null;
    private JPanel jPanel2 = null;
    private JPanel jPanel3 = null;
    private JPanel jPanel4 = null;
    private JPanel jPanel5 = null;
    private JPanel jPanel6 = null;
    private JPanel jPanel7 = null;

    private JLabel jLabel = null;
    private JLabel jLabel1 = null;

    private JComboBox jComboBox = null;
    private JSpinner jSpinner = null;
    private JCheckBox jCheckBox = null;
    private JCheckBox jCheckBox1 = null;

    /**
     * Map que mantém uma referência para os gráficos criados.
     */
//    private Map graficos = new HashMap();

    /**
     * Construtor padrão.
     */
    public Metas() {
        super();
        montarTela();
        desenharGraficos();
    }

    /**
     * This method initializes this
     *
     * @return void
     */
    private void montarTela() {
        this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 500);
        this.setContentPane(getJContentPane());
        this.setTitle("Gráficos com JFreeChart - Java Magazine");
    }

   

    /**
     * This method initializes jPanel
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJPanel() {
        if (jPanel == null) {
            jPanel = new JPanel();
            jPanel.setLayout(new BorderLayout());
            jPanel.add(getjPanel1(), java.awt.BorderLayout.CENTER);
        }
        return jPanel;
    }

    /**
     * This method initializes jContentPane
     *
     * @return javax.swing.JPanel
     */
    private javax.swing.JPanel getJContentPane() {
        if(jContentPane == null) {
            jContentPane = new javax.swing.JPanel();
            jContentPane.setLayout(new java.awt.BorderLayout());
            jContentPane.add(getJPanel(), java.awt.BorderLayout.CENTER);
        }
        return jContentPane;
    }

    /**
     * This method initializes jPanel1
     *
     * @return javax.swing.JPanel
     */
    private JPanel getjPanel1() {
        if (jPanel1 == null) {
            jPanel1 = new JPanel();
            jPanel1.setLayout(new BorderLayout());
            jPanel1.add(getJTabbedPane(), java.awt.BorderLayout.CENTER);
        }
        return jPanel1;
    }

    private JTabbedPane getJTabbedPane() {
        if (jTabbedPane == null) {
            jTabbedPane = new JTabbedPane();
            jTabbedPane.addTab("Eixo Duplo", null, getJPanel6(), null);
        }
        return jTabbedPane;
    }

    /**
     * This method initializes jPanel2
     *
     * @return javax.swing.JPanel
     */
    private JPanel getjPanel2() {
        if (jPanel2 == null) {
            jPanel2 = new JPanel();
            jPanel2.setLayout(new BorderLayout());
            jPanel2.add(getjPanel3(), java.awt.BorderLayout.NORTH);
            jPanel2.add(getJPanel4(), java.awt.BorderLayout.CENTER);
        }
        return jPanel2;
    }

    /**
     * This method initializes jPanel5
     *
     * @return javax.swing.JPanel
     */
    private JPanel getjPanel5() {
        if (jPanel5 == null) {
            jPanel5 = new JPanel();
            jPanel5.setLayout(new BorderLayout());
        }
        return jPanel5;
    }

    /**
     * This method initializes jPanel3
     *
     * @return javax.swing.JPanel
     */
    private JPanel getjPanel3() {
        if (jPanel3 == null) {
            jLabel1 = new JLabel();
            jLabel = new JLabel();
            jPanel3 = new JPanel();
            jLabel.setText("Destaque: ");
            jLabel1.setText("Ângulo: ");
            jPanel3.add(jLabel, null);
            jPanel3.add(getJComboBox(), null);
            jPanel3.add(jLabel1, null);
            jPanel3.add(getJSpinner(), null);
            jPanel3.add(getJCheckBox(), null);
            jPanel3.add(getJCheckBox1(), null);
        }
        return jPanel3;
    }

    /**
     * This method initializes jPanel4
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJPanel4() {
        if (jPanel4 == null) {
            jPanel4 = new JPanel();
            jPanel4.setLayout(new BorderLayout());
        }
        return jPanel4;
    }

    /**
     * This method initializes jComboBox
     *
     * @return javax.swing.JComboBox
     */
    private JComboBox getJComboBox() {
        if (jComboBox == null) {
            jComboBox = new JComboBox();
        }
        return jComboBox;
    }

    /**
     * This method initializes jSpinner
     *
     * @return javax.swing.JSpinner
     */
    private JSpinner getJSpinner() {
        if (jSpinner == null) {
            jSpinner = new JSpinner();
        }
        return jSpinner;
    }

    /**
     * This method initializes jCheckBox
     *
     * @return javax.swing.JCheckBox
     */
    private JCheckBox getJCheckBox() {
        if (jCheckBox == null) {
            jCheckBox = new JCheckBox();
            jCheckBox.setText("Animação");
        }
        return jCheckBox;
    }

    /**
     * This method initializes jPanel6
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJPanel6() {
        if (jPanel6 == null) {
            jPanel6 = new JPanel(new BorderLayout());
        }
        return jPanel6;
    }

    /**
     * This method initializes jPanel7
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJPanel7() {
        if (jPanel7 == null) {
            jPanel7 = new JPanel();
            jPanel7.setLayout(new BorderLayout());
        }
        return jPanel7;
    }

    /**
     * This method initializes jCheckBox1
     *
     * @return javax.swing.JCheckBox
     */
    private JCheckBox getJCheckBox1() {
        if (jCheckBox1 == null) {
            jCheckBox1 = new JCheckBox();
            jCheckBox1.setText("Rotacionar");
        }
        return jCheckBox1;
    }

    /**
     * Método que delega a geração dos gráficos.
     */
    private void desenharGraficos() {
        gerarGraficoEixos();
    }


    /**
     * Gera o gráfico 3.
     */
    private void gerarGraficoEixos() {
        //cria o dataset com os dados dos resultados das vendas
        CategoryDataset dataset1 = obterDados1Grafico3();
        //cria o gráfico de barras 3d
        JFreeChart grafico = ChartFactory.createBarChart3D("Vendas de Produtos", "Período", "Vendas (milhões)", dataset1, PlotOrientation.VERTICAL, true, true, false);
        //altera a cor de fundo do gráfico
        grafico.setBackgroundPaint(new Color(204, 255, 204));
        CategoryPlot categoryplot = grafico.getCategoryPlot();
        //categoryplot.setDomainAxisLocation(AxisLocation.BOTTOM_OR_LEFT);
        //categoryplot.setRangeAxisLocation(AxisLocation.TOP_OR_LEFT);

        //define as cores de cada item do grafico de barras
        CategoryItemRenderer categoryitemrenderer = categoryplot.getRenderer();
        categoryitemrenderer.setSeriesPaint(0, Color.BLUE);
        categoryitemrenderer.setSeriesPaint(1, Color.YELLOW);
        categoryitemrenderer.setSeriesPaint(2, Color.GREEN);

        //cria o segundo dataset com os dados das metas mensais
        //e adiciona ao plot do gráfico
        CategoryDataset dataset2 = obterDados2Grafico3();
        categoryplot.setDataset(1, dataset2);

        //Cria um novo eixo no gráfico
        NumberAxis3D numberaxis3d = new NumberAxis3D("Metas");
        categoryplot.setRangeAxis(1, numberaxis3d);
        //categoryplot.mapDatasetToRangeAxis(1, 1);

        //Cria e define o renderer do novo eixo
        //LineRenderer3D linerenderer = new LineRenderer3D();
        LineAndShapeRenderer linerenderer = new LineAndShapeRenderer();
        //define a cor vermelha para o item desenhado
        linerenderer.setSeriesPaint(0, Color.RED);
        //define o renderer do segundo dataset
        categoryplot.setRenderer(1, linerenderer);
        //ordena a disponibilização da visualização dos datasets no gráfico
        //onde o primeiro dataset aparece atrás e o último mais à frente
        categoryplot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);

        //exibe o gráfico em um panel
        ChartPanel chartPanel = new ChartPanel( grafico );
        jPanel6.add( chartPanel );
        jPanel6.revalidate();

        //guarda uma referência global para o gráfico
//        graficos.put( "grafico3", grafico );
    }

    /**
     * Cria o Dataset com os dados do primeiro eixo do gráfico 3.
     * @return
     */
    private CategoryDataset obterDados1Grafico3() {
        String p1 = "Camisa";
        String m1 = "Janeiro";
        String m2 = "Fevereiro";
        String m3 = "Março";
        String m4 = "Abril";
        String m5 = "Junho";
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(5, p1, m1);
        dataset.addValue(4, p1, m2);
        dataset.addValue(3, p1, m3);
        dataset.addValue(2, p1, m4);
        dataset.addValue(1, p1, m5);
        return dataset;
    }

    /**
     * Cria o Dataset com os dados do segundo eixo do gráfico 3.
     * @return
     */
    private CategoryDataset obterDados2Grafico3() {
        String p1 = "Meta";
        String m1 = "Janeiro";
        String m2 = "Fevereiro";
        String m3 = "Março";
        String m4 = "Abril";
        String m5 = "Junho";
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1, p1, m1);
        dataset.addValue(2, p1, m2);
        dataset.addValue(3, p1, m3);
        dataset.addValue(4, p1, m4);
        dataset.addValue(5, p1, m5);
        return dataset;
    }


    /**
     * Início do programa.
     * @param args Nenhum parâmetro é solicitado.
     */
    public static void main(String[] args) {
        Metas g = new Metas();
        g.setVisible(true);
    }
}