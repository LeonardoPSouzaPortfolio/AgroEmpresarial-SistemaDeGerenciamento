/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Jorge
 */
public class ConverterData extends org.jdesktop.beansbinding.Converter{
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    @Override
    // objeto para tela
    public Object convertForward(Object value) {
        Calendar c = (Calendar) value;
        return sdf.format(c.getTime());
    }

    @Override
    // tela para o objeto
    public Object convertReverse(Object value) {
        String str = (String) value;
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(str));
            return c;
        }catch (Exception e){
            return null;
        }
    }
    
}
