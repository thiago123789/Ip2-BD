package poo.negocios;

import java.util.Calendar;

import sun.util.calendar.BaseCalendar.Date;

public class Auxiliar {
	
	public Auxiliar(){
		
	}
	
	public int[] retornarAnosAteAtual(){
		Calendar a = Calendar.getInstance();
		int ano = a.get(Calendar.YEAR);
		int inicio = 1900;
		int total = ano - inicio;
		int[] anosTodos = new int[total];
		for(int i = 0; i <= total; i++, inicio++ ){
			anosTodos[i] = inicio;
		}
		return anosTodos;
	}
	
	
}
