package poo.negocios.beans.sidronio;

import poo.negocios.beans.davi.*;
import poo.negocios.beans.veneranda.*;

import java.util.Arrays;

public class Departamento {

	private String nome;
	private String sigla;
	private Curso[] cursos;
	private Funcionario[] funcionarios;
	private Professor diretor,vice;
	
	public Departamento(){
		
	}
	
	public Departamento(String nome, String codigo, Professor diretor, Professor vice){
		this.nome=nome;
		this.sigla=sigla; 
		this.diretor=diretor;
		this.vice=vice;

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Curso[] getCursos() {
		return cursos;
	}

	public void setCursos(Curso[] cursos) {
		this.cursos = cursos;
	}

	public Funcionario[] getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Funcionario[] funcionarios) {
		this.funcionarios = funcionarios;
	}
	

	public Professor getDiretor() {
		return diretor;
	}

	public void setDiretor(Professor diretor) {
		this.diretor = diretor;
	}

	public Professor getVice() {
		return vice;
	}

	public void setVice(Professor vice) {
		this.vice = vice;
	}

	@Override
	public String toString() {
		return "Departamento [nome=" + nome + ", sigla=" + sigla + ", cursos=" + Arrays.toString(cursos) + "]";
	}

	

	
	
	
	
}
