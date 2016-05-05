package poo.negocios;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;

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
        
        public ArrayList<Integer> retornarAnosAteAtualList(){
                ArrayList<Integer> anos = new ArrayList<Integer>();
		Calendar a = Calendar.getInstance();
		int ano = a.get(Calendar.YEAR);
		int inicio = 1900;
                anos.add(inicio);
		while(inicio < ano){
                    inicio++;
                    anos.add(inicio);
                }
                return anos;
        }
        
        public int okcancel(String theMessage, String titulo) {
            int result = JOptionPane.showConfirmDialog((Component) null, theMessage,
                 titulo, JOptionPane.OK_CANCEL_OPTION);
            return result;
        }
        
        public ArrayList<Integer> retornarAnosAPartirDeList(int inicio){
                ArrayList<Integer> anos = new ArrayList<Integer>();
		Calendar a = Calendar.getInstance();
		int ano = a.get(Calendar.YEAR);
                anos.add(inicio);
		while(inicio < ano){
                    inicio++;
                    anos.add(inicio);
                }
                return anos;
        }
        
	
       public int[] retornarAnosAPartirDe(int inicio){
		Calendar a = Calendar.getInstance();
		int ano = a.get(Calendar.YEAR);
		int total = ano - inicio;
		int[] anosTodos = new int[total];
		for(int i = 0; i <= total; i++, inicio++ ){
			anosTodos[i] = inicio;
		}
		return anosTodos;
	}
	
}
