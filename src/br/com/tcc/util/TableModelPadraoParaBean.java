package br.com.tcc.util;

import java.lang.reflect.Method;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelPadraoParaBean extends AbstractTableModel {
  private Class<?> classe;
  private List<?> lista;

   public TableModelPadraoParaBean(List<?> linhas) {
      this.setLinhas(linhas);
      if (linhas != null)
        this.classe = linhas.get(0).getClass();
   }

   public void atualiza(List<?> lista) {
        setLinhas(lista);

        if((lista != null))
        	this.classe = lista.get(0).getClass();
}


   public int getRowCount() {
      if (lista != null) {
         return lista.size();
      } else {
         return 0;
      }
   }

   public int getColumnCount() {
       int colunas = 0;
       for(Method m : classe.getDeclaredMethods()){
           if(m.isAnnotationPresent(Coluna.class)){
               colunas++;
           }
       }
      return colunas;
   }

    @Override
   public boolean isCellEditable(int row, int col) {
      return false;
    }

    @Override
    public Class getColumnClass(int c) {
      return getValueAt(0, c).getClass();
    }

    public void setLinhas(List<?> linhas) {
      this.lista = linhas;
      fireTableDataChanged();
   }

   public Object getValueAt(int rowIndex, int columnIndex) {
       try{
           Object objeto = lista.get(rowIndex);
           for(Method m : classe.getDeclaredMethods()){
               Coluna c = m.getAnnotation(Coluna.class);
               if(c != null && c.posicao() == columnIndex){
                   return String.format(c.formato(), m.invoke(objeto));
               }
           }
       }catch(Exception ex){
           ex.printStackTrace();
       }
       return "";
   }
    @Override
    public String getColumnName(int coluna){
        for(Method m : classe.getDeclaredMethods()){
            Coluna c = m.getAnnotation(Coluna.class);
            if(c != null && c.posicao() == coluna ){
                return c.nome();
            }
        }
        return "";
    }
}
