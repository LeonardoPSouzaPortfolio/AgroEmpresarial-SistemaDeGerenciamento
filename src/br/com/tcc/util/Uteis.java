/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.util;

import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.*;

/**
 *
 * @author Jorge Luis Boeira Bavaresco
 */
public class Uteis {

    /**
     * M�todo que retorna falso ou verdadeiro numa caixa de dialogo com sim ou
     * n�o
     *
     * @param msg Mensgem que aparece no dialogo
     * @return Verdadeiro para sim e falso para n�o
     */
    public static boolean confirmar(String msg) {
        return confirmar(msg, "Confirme...");
    }

    public static boolean confirmar(String msg, String titulo) {
        int escolha = confirmar(msg, titulo,
                new String[]{"Sim", "Não"}, 0);
        return (escolha == 0);
    }

    public static int confirmar(String msg, String titulo,
            String[] opcoes, int selecao) {
        int escolha = JOptionPane.showOptionDialog(null,
                msg, titulo, JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, opcoes, opcoes[selecao]);
        return escolha;
    }

    /**
     * M�todo que deixa o campo amarelo. Usar no evento focusGained
     *
     * @param evt
     */
    public static void entraCampo(java.awt.event.FocusEvent evt) {
        if (evt.getSource() instanceof JTextField) {
            ((JTextField) evt.getSource()).setBackground(Color.lightGray);
        } else if (evt.getSource() instanceof JComboBox) {
            ((JComboBox) evt.getSource()).setBackground(Color.lightGray);
        } else if (evt.getSource() instanceof JTextArea) {
            ((JTextArea) evt.getSource()).setBackground(Color.lightGray);
        }
    }

    /**
     * M�todo que deixa o campo branco. Usar no evento focusLost
     *
     * @param evt
     */
    public static void saiCampo(java.awt.event.FocusEvent evt) {
        if (evt.getSource() instanceof JTextField) {
            ((JTextField) evt.getSource()).setBackground(Color.WHITE);
        } else if (evt.getSource() instanceof JComboBox) {
            ((JComboBox) evt.getSource()).setBackground(Color.WHITE);
        } else if (evt.getSource() instanceof JTextArea) {
            ((JTextArea) evt.getSource()).setBackground(Color.WHITE);
        }
    }

    /**
     * Metodo para n�o deixar que sejam digitadas letras, e limita o tamanho do
     * campo Deve ser chamado no evento KeyTyped * Para JTextField e
     * JFormattedTextField
     *
     * @param evt evento passado
     * @param tamanhoCampo Integer que informa o tamanho do campo
     */
    public static void validaCampoNumericoInteger(java.awt.event.KeyEvent evt, int tamanhoCampo) {
        if (!(verificaBackSpace(evt))) {
            if (evt.getSource() instanceof JTextField) {
                int c = evt.getKeyChar();

                if (Character.isDigit(c)) {
                    if (((JTextField) evt.getSource()).getText().length() <= tamanhoCampo - 1) {
                        //deixe passar
                    } else {
                        evt.setKeyChar((char) KeyEvent.VK_CLEAR);
                    }
                } else {
                    evt.setKeyChar((char) KeyEvent.VK_CLEAR);
                }
            } else if (evt.getSource() instanceof JFormattedTextField) {
                int c = evt.getKeyChar();
                if (Character.isDigit(c)) {
                    if (((JFormattedTextField) evt.getSource()).getText().length() <= tamanhoCampo - 1) {
                        //deixe passar
                    } else {
                        evt.setKeyChar((char) KeyEvent.VK_CLEAR);
                    }
                } else {
                    evt.setKeyChar((char) KeyEvent.VK_CLEAR);
                }
            }
        }
    }

    /**
     * Metodo para não deixar que sejam digitadas letras Deve ser chamado no
     * evento KeyTyped * Para JTextField e JFormattedTextField
     *
     * @param evt evento passado
     */
    public static void validaCampoNumericoInteger(java.awt.event.KeyEvent evt) {
        if (!(verificaBackSpace(evt))) {
            if (evt.getSource() instanceof JTextField) {
                int c = evt.getKeyChar();
                if (Character.isDigit(c)) {
                    //deixar passar
                } else {
                    evt.setKeyChar((char) KeyEvent.VK_CLEAR);
                }
            } else if (evt.getSource() instanceof JFormattedTextField) {
                int c = evt.getKeyChar();
                if (Character.isDigit(c)) {
                    //deixar passar
                } else {
                    evt.setKeyChar((char) KeyEvent.VK_CLEAR);
                }
            }
        }
    }

    /**
     * Metodo para n�o deixar que sejam digitadas letras somente numeros e o 01
     * ponto. Se for digitado uma virgula ele converte em ponto Para JTextField
     * e JFormattedTextField Deve ser chamado no evento KeyTyped
     *
     * @param evt evento passado
     */
    public static void validaCampoNumericoDouble(java.awt.event.KeyEvent evt) {
        if (!(verificaBackSpace(evt))) {
            // aqui eu pego oque esta digitado no campo e conto os pontos
            String str = "";
            if (evt.getSource() instanceof JTextField) {
                str = ((JTextField) evt.getSource()).getText();
            } else if (evt.getSource() instanceof JFormattedTextField) {
                str = ((JFormattedTextField) evt.getSource()).getText();
            }
            int cont = 0;
            char ponto = '.';
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == ponto) {
                    cont++;
                }
            }
            if (evt.getKeyChar() == ',') {
                evt.setKeyChar('.');
            }
            // aqui se o caracter digitado � ponto conto mais 1
            if (evt.getKeyChar() == '.') {
                cont++;
            }
            /*
             * E aqui eu teste se o caracter digitado � um numero ou um ponto, e
             * se for o segundo ponto digitado ele apaga
             */
            if (evt.getSource() instanceof JTextField) {
                int c = evt.getKeyChar();
                if ((Character.isDigit(c) || (evt.getKeyChar() == '.')) && (cont <= 1)) {
                    //deixar passar
                } else {
                    evt.setKeyChar((char) KeyEvent.VK_CLEAR);
                }
            } else if (evt.getSource() instanceof JFormattedTextField) {
                int c = evt.getKeyChar();
                if ((Character.isDigit(c) || (evt.getKeyChar() == '.')) && (cont <= 1)) {
                    //deixar passar
                } else {
                    evt.setKeyChar((char) KeyEvent.VK_CLEAR);
                }
            }
        }
    }

    /**
     * Metodo para limitar o tamanho do campo Deve ser chamado no evento
     * KeyTyped Serve Para JTextField e JTextArea
     *
     * @param evt evento passado
     * @param tamanhoCampo Integer que informa o tamanho do campo
     */
    public static void limitaTamanhoCampo(java.awt.event.KeyEvent evt, int tamanhoCampo) {
        if (!(verificaBackSpace(evt))) {
            if (evt.getSource() instanceof JTextField) {
                int c = evt.getKeyChar();
                if (((JTextField) evt.getSource()).getText().length() <= tamanhoCampo - 1) {
                    //deixe passar
                } else {
                    evt.setKeyChar((char) KeyEvent.VK_CLEAR);
                }
            } else if (evt.getSource() instanceof JTextArea) {
                int c = evt.getKeyChar();
                if (((JTextArea) evt.getSource()).getText().length() <= tamanhoCampo - 1) {
                    //deixe passar
                } else {
                    evt.setKeyChar((char) KeyEvent.VK_CLEAR);
                }
            }
        }
    }

    /**
     * M�todo que verifica se a tecla pressiona � backspace
     *
     * @param evt
     * @return false ou verdadeiro
     */
    public static boolean verificaBackSpace(java.awt.event.KeyEvent evt) {
        if (evt.getKeyChar() == '') {
            //     System.out.println("Backspace ou Delete");
            return true;
        } else {
            //  System.out.println("N�o backspace ou delete: codigo = " + evt.getKeyCode());
            return false;
        }
    }

    /**
     * M�todo que remove caracteres de uma String
     *
     * @param texto que possui os caracteres a serem removidos
     * @param caracteres que ser�o removidos
     * @return
     */
    public static String removeCaracteres(String texto, String caracteres) {
        String str = texto;
        str = texto.replaceAll("[" + caracteres + "]", "");
        return str;
    }

    /**
     * M�todo que recebe um CPF e retorna se ele � v�lido ou n�o. Valida com ou
     * sem mascara
     * @param cpf CPF a ser validado
     * @return FALSE ou TRUE para CPF v�lido ou n�o
     */
    public static boolean validaCpf(String cpf) {
        cpf = removeCaracteres(cpf, "./-");
        if (cpf.equals("11111111111")) {
            return false;
        }
        int d1, d2;
        int digito1, digito2, resto;
        int digitoCPF;
        String nDigResult;
        d1 = d2 = 0;
        digito1 = digito2 = resto = 0;
        for (int nCount = 1; nCount < cpf.length() - 1; nCount++) {
            digitoCPF = Integer.valueOf(cpf.substring(nCount - 1, nCount)).intValue();
            //multiplique a ultima casa por 2 a seguinte por 3 a seguinte por 4 e assim por diante.
            d1 = d1 + (11 - nCount) * digitoCPF;
            //para o segundo digito repita o procedimento incluindo o primeiro digito calculado no passo anterior.
            d2 = d2 + (12 - nCount) * digitoCPF;
        }
        ;
        //Primeiro resto da divis�o por 11.
        resto = (d1 % 11);
        //Se o resultado for 0 ou 1 o digito � 0 caso contr�rio o digito � 11 menos o resultado anterior.
        if (resto < 2) {
            digito1 = 0;
        } else {
            digito1 = 11 - resto;
        }
        d2 += 2 * digito1;
        //Segundo resto da divis�o por 11.
        resto = (d2 % 11);
        //Se o resultado for 0 ou 1 o digito � 0 caso contr�rio o digito � 11 menos o resultado anterior.
        if (resto < 2) {
            digito2 = 0;
        } else {
            digito2 = 11 - resto;
        }
        //Digito verificador do CPF que est� sendo validado.
        String nDigVerific = cpf.substring(cpf.length() - 2, cpf.length());
        //Concatenando o primeiro resto com o segundo.
        nDigResult = String.valueOf(digito1) + String.valueOf(digito2);
        //comparar o digito verificador do cpf com o primeiro resto + o segundo resto.
        return nDigVerific.equals(nDigResult);
    }

    /**
     * M�todo que valida um CNPJ com ou sem mascara
     * @param cnpj CNPJ a ser validado
     * @return FALSE ou TRUE se o CNPJ � valido ou n�o
     */
    public static boolean validaCnpj(String cnpj) {
        cnpj = removeCaracteres(cnpj, "./-");
        int soma = 0, dig;
        String cnpj_calc = cnpj.substring(0, 12);
        if (cnpj.length() != 14) {
            return false;
        }
        char[] chr_cnpj = cnpj.toCharArray();
        /*
         * Primeira parte
         */
        for (int i = 0; i < 4; i++) {
            if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                soma += (chr_cnpj[i] - 48) * (6 - (i + 1));
            }
        }
        for (int i = 0; i < 8; i++) {
            if (chr_cnpj[i + 4] - 48 >= 0 && chr_cnpj[i + 4] - 48 <= 9) {
                soma += (chr_cnpj[i + 4] - 48) * (10 - (i + 1));
            }
        }
        dig = 11 - (soma % 11);
        cnpj_calc += (dig == 10 || dig == 11) ? "0" : Integer.toString(dig);
        /*
         * Segunda parte
         */
        soma = 0;
        for (int i = 0; i < 5; i++) {
            if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                soma += (chr_cnpj[i] - 48) * (7 - (i + 1));
            }
        }
        for (int i = 0; i < 8; i++) {
            if (chr_cnpj[i + 5] - 48 >= 0 && chr_cnpj[i + 5] - 48 <= 9) {
                soma += (chr_cnpj[i + 5] - 48) * (10 - (i + 1));
            }
        }
        dig = 11 - (soma % 11);
        cnpj_calc += (dig == 10 || dig == 11) ? "0" : Integer.toString(dig);
        return cnpj.equals(cnpj_calc);
    }
}
