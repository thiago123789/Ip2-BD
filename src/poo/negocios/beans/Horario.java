package poo.negocios.beans;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Horario {
	private int id;
	private String dia;
	private Time horaInicio, horaTermino;
	private ArrayList<Aula> aulas;

	public Horario() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public Time getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Time getHoraTermino() {
		return horaTermino;
	}

	public void setHoraTermino(Time horaTermino) {
		this.horaTermino = horaTermino;
	}

	public ArrayList<Aula> getAulas() {
		return aulas;
	}

	public void setAulas(ArrayList<Aula> aulas) {
		this.aulas = aulas;
	}

    @Override
    public String toString() {
        return "Horario{" + "dia=" + dia + ", horaInicio=" + horaInicio + ", horaTermino=" + horaTermino + '}';
    }




}
