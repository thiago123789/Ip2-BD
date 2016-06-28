//CLASSE PARA DAVI;
package poo.negocios.beans;

import java.util.Calendar;

import poo.excecoes.CPFInvalidoException;

public class Professor extends Pessoa{
	private String titulo;
	private Departamento departamento;
	private String ies;

	public Professor(String titulo, String lattes,boolean sexo, String senha,
			String email, Endereco endereco,
			String pNome, String uNome, String cpf, Cargo cargo, Calendar nascimento,
			Departamento depat, String lattes1) throws CPFInvalidoException	{
		super(pNome, uNome, cpf, sexo, senha, email, endereco, 1, nascimento, lattes);
		this.setTitulo(titulo);
                this.setDepartamento(depat);
	}

	public Professor(String cpf) throws CPFInvalidoException{
		super();
		this.setCpf(cpf);
	}

    public Professor(String titulo, String pNome, String uNome, String cpf, boolean sexo, String senha, String email, Endereco endereco, Departamento depat, String lattes, Calendar nascimento) throws CPFInvalidoException {
        super(pNome, uNome, cpf, sexo, senha, email, endereco, 1, nascimento, lattes);
        this.titulo = titulo;
        this.setDepartamento(depat);
        this.setIes("UFRPE");
        this.setTitulo("ADJUNTO");
    }
       public String getIes() {
		return ies;
	}

	public void setIes(String ies) {
		this.ies = ies;
	}


	public void setTitulo(String titulo)
	{
		if(titulo != null)
		{
			this.titulo = titulo;
		}
	}

	public String getTitulo()
	{
		return this.titulo;
	}

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

//    @Override
//    public String toString() {
//        return "Professor{" + "titulo=" + titulo + ", departamento=" + departamento + ", ies=" + ies + ", externo=" + externo + '}';
//    }
        
        
}
