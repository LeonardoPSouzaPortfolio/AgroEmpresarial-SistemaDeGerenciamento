/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.graficoFinanceiro;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis3D;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.CombinedRangeCategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class GraficosAvancados extends JFrame {
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
    private Map graficos = new HashMap();

    /**
     * Construtor padrão.
     */
    public GraficosAvancados() {
        super();
        montarTela();
        registrarListeners();
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

    private void registrarListeners() {
        //quando mudar o item, altera o item destacado do gráfico 1
        jComboBox.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int indice = ((JComboBox) e.getSource()).getSelectedIndex();
                mudarDestaqueGraficoPizza( indice );
            }
        } );

        //Model de 0 a 360, passo 1
        SpinnerModel model = new SpinnerNumberModel( 0, 0, 360, 1 );
        jSpinner.setModel( model );
        //quando o valor for alterado, muda o ângulo do gráfico 1
        jSpinner.addChangeListener( new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                Number n = (Number) ((JSpinner) e.getSource()).getValue();
                mudarAnguloGraficoPizza( n.intValue() );
            }
        } );

        //registra listener do checkbox de animação de cores
        jCheckBox.addChangeListener( new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                //se checkbox estiver selecionado
                if( ((JCheckBox)e.getSource()).isSelected() ) {
                    animarGraficoPizza( true ); //animar
                } else {
                    animarGraficoPizza( false ); //parar animação
                }
            }
        } );

        //registra listener do checkbox de animação de rotação
        jCheckBox1.addChangeListener( new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                //se checkbox estiver selecionado
                if( ((JCheckBox)e.getSource()).isSelected() ) {
                    rotacionarGraficoPizza( true ); //rotacionar
                } else {
                    rotacionarGraficoPizza( false ); //parar rotação
                }
            }
        } );
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
            jTabbedPane.addTab("Licensas no SourceForge", null, getjPanel2(), null);
            jTabbedPane.addTab("Osciloscópio de Som", null, getjPanel5(), null);
            jTabbedPane.addTab("Eixo Duplo", null, getJPanel6(), null);
            jTabbedPane.addTab("Gráficos Combinados", null, getJPanel7(), null);
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
    	gerarGraficoPizza();
        gerarGraficoOsciloscopio();
        gerarGraficoEixos();
        gerarGraficosCombinados();
    }

    /**
     * Gera o gráfico de pizza (gráfico 1).
     */
    private void gerarGraficoPizza() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        //busca os dados e os coloca no dataset
        Object[][] dados = obterDadosLicensaSourceForge();
        for( int i=0; i<dados[0].length; i++ ) {
            dataset.setValue( (String) dados[0][i], (Integer) dados[1][i] );
        }
        //cria o gráfico
        JFreeChart grafico = ChartFactory.createPieChart( "Número de projetos por licensa (SourceForge)", dataset, true, false, false );

        PiePlot pieplot = (PiePlot) grafico.getPlot();
        //altera o ângulo incial do gráfico igual a zero
        pieplot.setStartAngle( 0 );
        //destaca um primeiro item do gráfico de pizza
        pieplot.setExplodePercent( 0, 0.2 );

        /*
         pieplot.setSectionPaint(0,Color.WHITE);
         pieplot.setSectionPaint(1,new GradientPaint(0.0F, 0.0F, Color.WHITE, 105F, 105F, Color.BLUE,true));
         */

        //guarda uma referência global para o gráfico
        graficos.put( "grafico1", grafico );

        //exibe o gráfico em um panel
        ChartPanel chartPanel = new ChartPanel( grafico );
        jPanel4.add( chartPanel );
        jPanel4.revalidate();

        //carrega os dados no combobox para selecionar o destaque
        carregarDadosComboBox1( dados[0] );
    }

    /**
     * Carrega no combobox um array de strings contendo
     * os nomes das licensas a serem exibidas.
     * @param dados Array com os dados a serem exibidos.
     */
    private void carregarDadosComboBox1( Object[] dados ) {
        jComboBox.removeAllItems();
        for( int i=0; i<dados.length; i++ ) {
            jComboBox.addItem( dados[i] );
        }
        jComboBox.addItem( "Nenhum" );
    }

    /**
     * Muda o item em destaque do gráfico 1.
     * @param indice Índice do item em destaque.
     */
    private void mudarDestaqueGraficoPizza( int indice ) {
        //obtém uma referência para o gráfico desejado
        JFreeChart grafico = (JFreeChart) graficos.get( "grafico1" );
        //coloca todos os itens sem destaque
        PiePlot pieplot = (PiePlot) grafico.getPlot();
        int num = pieplot.getDataset().getItemCount();
        for( int i=0; i<num; i++ ) {
            pieplot.setExplodePercent( i, 0 );
        }
        if( indice >= 0 && indice < num ) {
            //coloca o item desejado em destaque
            pieplot.setExplodePercent( indice, 0.2 );
        }
    }

    /**
     * Muda o ângulo inicial da plotagem do gráfico 1.
     * @param angulo Ângulo desejado, que vai de 0 a 360.
     */
    private void mudarAnguloGraficoPizza( int angulo ) {
        //obtém uma referência para o gráfico desejado
        JFreeChart grafico = (JFreeChart) graficos.get( "grafico1" );
        //altera o ângulo do gráfico
        PiePlot pieplot = (PiePlot) grafico.getPlot();
        pieplot.setStartAngle( angulo );
    }

    /**
     * Cria os dados do número de licensas utilizados no SourceForge.
     * A matriz é bidimensional, onde o primeiro eixo vem os nomes
     * das licensas (String) e o segundo eixo vem o número de
     * projetos por cada licensas (Integer).
     * @return Matriz bidimensional com os dados.
     */
    private Object[][] obterDadosLicensaSourceForge() {
        Object[][] dados = new Object[2][5];

        dados[0][0] = "GPL";
        dados[0][1] = "LGPL";
        dados[0][2] = "BSD";
        dados[0][3] = "ASL";
        dados[0][4] = "Outras";

        dados[1][0] = new Integer(43089);
        dados[1][1] = new Integer(6974);
        dados[1][2] = new Integer(4472);
        dados[1][3] = new Integer(958);
        dados[1][4] = new Integer(6798);
        //TOTAL = 62291

        return dados;
    }

    /**
     * Gera o gráfico do osciloscópio (gráfico 2).
     */
    private void gerarGraficoOsciloscopio() {
        //cria o dataset e o popula com os dados iniciais
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        atualizarDadosDataset( dataset );
        //cria o gráfico com base no dataser
        final JFreeChart grafico = ChartFactory.createBarChart("Osciloscópio","canal","potência",dataset,PlotOrientation.VERTICAL,false,false,false);
        //exibe o gráfico em um panel
        ChartPanel chartPanel = new ChartPanel( grafico );
        jPanel5.add( chartPanel );
        jPanel5.revalidate();

        //guarda uma referência global para o gráfico
        graficos.put( "grafico2", grafico );

        //Cria a thread que de tempos em tempos atualiza os dados
        //do osciloscópio e a executa
        new Thread() {
            public void run() {
                while( true ) {
                    try {
                        //dorme a thread por um instante
                        Thread.sleep(100);
                    } catch( Exception e ) {}
                    //obtém o dataset e atualiza os dados
                    DefaultCategoryDataset dataset = (DefaultCategoryDataset) grafico.getCategoryPlot().getDataset();
                    atualizarDadosDataset( dataset );
                }
            }
        }.start();
    }

    /**
     * Atualiza os valores dentro do dataset informado.
     * @param dataset Dataset a ser populado com os dados.
     */
    private void atualizarDadosDataset( DefaultCategoryDataset dataset ) {
        Integer[] valores = gerarDadosOsciloscopio();
        for( int i=0; i<valores.length; i++ ) {
            dataset.addValue( valores[i], "A", "A"+i );
        }
    }

    /**
     * Gera os dados do osciloscópio de forma aleatória.
     * @return Array de Integers com valores aleatórios.
     */
    private Integer[] gerarDadosOsciloscopio() {
        Integer[] valores = new Integer[15];
        for( int i=0; i<valores.length; i++ ) {
            valores[i] = new Integer( (int) (Math.random() * 10) );
        }
        return valores;
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
        graficos.put( "grafico3", grafico );
    }

    /**
     * Cria o Dataset com os dados do primeiro eixo do gráfico 3.
     * @return
     */
    private CategoryDataset obterDados1Grafico3() {
        String p1 = "Camisa";
        String p2 = "Calça";
        String p3 = "Sapato";
        String m1 = "Janeiro";
        String m2 = "Fevereiro";
        String m3 = "Março";
        String m4 = "Abril";
        String m5 = "Junho";
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(2, p1, m1);
        dataset.addValue(4, p1, m2);
        dataset.addValue(3, p1, m3);
        dataset.addValue(5, p1, m4);
        dataset.addValue(5, p1, m5);
        dataset.addValue(5D, p2, m1);
        dataset.addValue(7D, p2, m2);
        dataset.addValue(6D, p2, m3);
        dataset.addValue(8D, p2, m4);
        dataset.addValue(4D, p2, m5);
        dataset.addValue(4D, p3, m1);
        dataset.addValue(3D, p3, m2);
        dataset.addValue(2D, p3, m3);
        dataset.addValue(3D, p3, m4);
        dataset.addValue(6D, p3, m5);
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
        dataset.addValue(2, p1, m1);
        dataset.addValue(3, p1, m2);
        dataset.addValue(5, p1, m3);
        dataset.addValue(4, p1, m4);
        dataset.addValue(5, p1, m5);
        return dataset;
    }

    /**
     * Gera o gráfico 4.
     */
    private void gerarGraficosCombinados() {
        CategoryDataset dataset = null;
        CategoryPlot catplot = null;

        //cria o plot de combinação de categorias pelo range
        CombinedRangeCategoryPlot plot = new CombinedRangeCategoryPlot();

        //obtém os dados do primeiro gráfico, cria o plot e adiciona à combinação
        dataset = obterDadosGrafico4("Real");
        catplot = new CategoryPlot( dataset, new CategoryAxis("Real"), null, new LineAndShapeRenderer() );
        plot.add( catplot );

        //obtém os dados do segundo gráfico, cria o plot e adiciona à combinação
        dataset = obterDadosGrafico4("Dólar");
        catplot = new CategoryPlot( dataset, new CategoryAxis("Dólar"), null, new BarRenderer() );
        plot.add( catplot );

        //obtém os dados do terceiro gráfico, cria o plot e adiciona à combinação
        dataset = obterDadosGrafico4("Euro");
        catplot = new CategoryPlot( dataset, new CategoryAxis("Euro"), null, new BarRenderer3D() );
        plot.add( catplot );

        //cria o gráfico usando o plot combinado
        JFreeChart grafico = new JFreeChart("Flutuação Cambial", plot);
        //cria um fundo degradê
        grafico.setBackgroundPaint(new GradientPaint(0.0F, 0.0F, Color.WHITE, 0.0F, 1000F, Color.BLUE));
        //adiciona subtítulo no gráfico
        TextTitle texttitle = new TextTitle("flutuação mensal", new Font("Courier New", 1, 12));
        grafico.addSubtitle(texttitle);

        //exibe o gráfico em um panel
        ChartPanel chartPanel = new ChartPanel( grafico );
        jPanel7.add( chartPanel );
        jPanel7.revalidate();

        //guarda uma referência global para o gráfico
        graficos.put( "grafico4", grafico );
    }

    private CategoryDataset obterDadosGrafico4( String moeda ) {
        double dados[] = new double[6];
        if( "Real".equals(moeda) ) {
            dados[0] = 10.0;
            dados[1] = 7.75;
            dados[2] = 8.0;
            dados[3] = 6.33;
            dados[4] = 9.99;
            dados[5] = 9;
        }
        else if( "Dólar".equals(moeda) ) {
            dados[0] = 12.0;
            dados[1] = 9.5;
            dados[2] = 7.1;
            dados[3] = 7.2;
            dados[4] = 8.88;
            dados[5] = 9.5;
        }
        else if( "Euro".equals(moeda) ) {
            dados[0] = 15.0;
            dados[1] = 10.1;
            dados[2] = 11.11;
            dados[3] = 9.45;
            dados[4] = 11.33;
            dados[5] = 12.01;
        }
        //cria um dataset com os dados
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for( int i=0; i<dados.length; i++ ) {
            dataset.setValue( dados[i], moeda, "0"+(i+1) );
        }
        return dataset;
    }

    /**
     * Atributo estático que guarda a thread de animação de cores.
     */
    private static Thread threadAnimacao1;

    /**
     * Cria uma thread que faz a animação de cores do gráfico 1.
     * @param animar true ou false indicado se é para iniciar (true) ou
     * parar (false) a animação.
     */
    private void animarGraficoPizza( boolean animar ) {
        if( animar && threadAnimacao1==null ) {
            threadAnimacao1 = new Thread() {
                public void run() {
                    //obtém uma referência para o gráfico desejado
                    JFreeChart grafico = (JFreeChart) graficos.get( "grafico1" );
                    PiePlot pieplot = (PiePlot) grafico.getPlot();
                    int pedaco = 0;
                    Color[] cores = new Color[]{ Color.WHITE, Color.ORANGE, Color.RED, Color.GREEN, Color.YELLOW, Color.BLUE, Color.CYAN, Color.MAGENTA, Color.PINK, Color.DARK_GRAY };
                    Color cor = null;
                    while( true ) {
                        pedaco = (int) (Math.random() * 10);
                        cor = cores[(int) (Math.random() * 10)];
                        pedaco = pedaco > 5 ? pedaco-5 : pedaco;
                        pieplot.setSectionPaint( pedaco, cor );
                        try {
                            Thread.sleep(100);
                        } catch( Exception e ) {}
                    }
                }
            };
            threadAnimacao1.start();
        }
        if( !animar && threadAnimacao1!=null ) {
            threadAnimacao1.stop();
            threadAnimacao1 = null;
        }
    }

    /**
     * Atributo estático que guarda a thread de animação de rotação.
     */
    private static Thread threadAnimacao2;

    /**
     * Cria uma thread que faz a animação de rotação do gráfico 1.
     * @param animar true ou false indicado se é para iniciar (true) ou
     * parar (false) a animação.
     */
    private void rotacionarGraficoPizza( boolean animar ) {
        if( animar && threadAnimacao2==null ) {
            threadAnimacao2 = new Thread() {
                public void run() {
                    //obtém uma referência para o gráfico desejado
                    JFreeChart grafico = (JFreeChart) graficos.get( "grafico1" );
                    PiePlot pieplot = (PiePlot) grafico.getPlot();
                    //obtém o valor o jSpinner e usa como valor inicial
                    int angulo = ((Integer)jSpinner.getValue()).intValue();
                    boolean paraFrente = true;
                    while( true ) {
                        mudarAnguloGraficoPizza( angulo );
                        //atualiza o valor no jSpinner
                        jSpinner.setValue(new Integer(angulo));
                        try {
                            Thread.sleep(10);
                        } catch( Exception e ) {}
                        //calcula novo ângulo
                        if( paraFrente ) {
                            angulo++;
                        } else {
                            angulo--;
                        }
                        //cuida dos limites dos ângulo e define
                        //se a rotação vai ou vem
                        if( paraFrente && angulo > 360 ) {
                            paraFrente = false;
                        } else if( !paraFrente && angulo < 0 ) {
                            paraFrente = true;
                        }
                    }
                }
            };
            threadAnimacao2.start();
        }
        if( !animar && threadAnimacao2!=null ) {
            threadAnimacao2.stop();
            threadAnimacao2 = null;
        }
    }

    /**
     * Início do programa.
     * @param args Nenhum parâmetro é solicitado.
     */
    public static void main(String[] args) {
        GraficosAvancados g = new GraficosAvancados();
        g.setVisible(true);
    }
}