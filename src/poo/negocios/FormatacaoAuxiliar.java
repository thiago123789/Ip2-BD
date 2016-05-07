/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.negocios;

import java.util.InputMismatchException;
import poo.excecoes.CPFInvalidoException;

/**
 *
 * @author Thiago Gomes
 */
public class FormatacaoAuxiliar {
    private static FormatacaoAuxiliar instance;
    
    public static FormatacaoAuxiliar getInstance(){
    	if(instance == null){
    		instance = new FormatacaoAuxiliar();
    	}
    	return instance;
    }
	
    private FormatacaoAuxiliar(){    }
    
    public String formatarCpf(String cpf){
        String resultado = "";
        String bloco1 = cpf.substring(0, 3);
        String bloco2 = cpf.substring(3, 6);
        String bloco3 = cpf.substring(6, 9);
        String bloco4 = cpf.substring(9, 11);
        resultado = bloco1+"."+bloco2+"."+bloco3+"-"+bloco4;
        return resultado;
    }
    
    public String soNumerosCPF(String cpf){
        String resultado = "";
        String bloco1 = cpf.substring(0, 3);
        String bloco2 = cpf.substring(4, 7);
        String bloco3 = cpf.substring(8, 11);
        String bloco4 = cpf.substring(12, 14);
        resultado = bloco1+bloco2+bloco3+bloco4;
        return resultado;
    }
    
    
    public boolean validarCPF(String numeroCPF) throws CPFInvalidoException {

		// considera-se erro CPF's formados por uma sequencia de numeros iguais
		if (numeroCPF.equals("00000000000") || numeroCPF.equals("11111111111")
				|| numeroCPF.equals("22222222222") || numeroCPF.equals("33333333333")
				|| numeroCPF.equals("44444444444") || numeroCPF.equals("55555555555")
				|| numeroCPF.equals("66666666666") || numeroCPF.equals("77777777777")
				|| numeroCPF.equals("88888888888") || numeroCPF.equals("99999999999")
				|| (numeroCPF.length() != 11))
			return (false);
		char dig10, dig11;
		int sm, i, r, num, peso;

		try {
			// Calculo do 1o. Digito Verificador
			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) { //
				// converte o i-esimo caractere do CPF em um numero: por
				// exemplo,
				// transforma o caractere '0' no inteiro 0 (48 eh a
				// posicao de '0' na tabela ASCII)
				num = (int) (numeroCPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}
			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else
				dig10 = (char) (r + 48);
			// converte no respectivo caractere numerico
			// Calculo do 2o. Digito Verificador
			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (numeroCPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}
			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else
				dig11 = (char) (r + 48);
			// Verifica se os digitos calculados
			// conferem com os digitos informados.
			if ((dig10 == numeroCPF.charAt(9)) && (dig11 == numeroCPF.charAt(10)))
				return (true);
			else
				return (false);
		} catch (InputMismatchException erro) {
			return (false);
		}

	}
    
}
