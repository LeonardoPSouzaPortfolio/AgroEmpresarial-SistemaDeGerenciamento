package br.com.tcc.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Coluna {
//vamos utilizar esta annotation para pegar o nome da coluna,posicao no jtable e o formato que queremos mostrar - vamos usar com uma data
//como exemplo.
	String nome();
	int posicao();
	String formato() default "%s";
}