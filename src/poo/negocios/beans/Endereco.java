package poo.negocios.beans;
public class Endereco{
	//Atributos
	private String logradouro, numero, bairro, cidade, cep;
	
	//Construtor
	public Endereco(String logradouro, String numero, String bairro, String cidade, String cep){
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cep = cep;
	}
	
	//Metodos
	public String getLogradouro(){
		return this.logradouro;
	}
	
	public String getNumero(){
		return this.numero;
	}
	
	public String getBairro(){
		return this.bairro;
	}
	
	public String getCidade(){
		return this.cidade;
	}
	
	public String getCep(){
		return this.cep;
	}
	//metodo toString
	public String toString(){
		return "Logradouro: " + this.getLogradouro() + "\nNumero: " + this.getNumero() + "\nBairro:"+ this.getBairro() + "\nCidade: " + 
		this.getCidade() + "\nCEP: " + this.getCep();
		} 
}