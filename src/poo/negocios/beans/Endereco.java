package poo.negocios.beans;
public class Endereco{
	//Atributos
	private String logradouro, bairro, cidade, cep, estado;
        private int numero;
	
	//Construtor
	public Endereco(String logradouro, int numero, String bairro, String cidade, String cep, String estado){
            this.setLogradouro(logradouro);
            this.setNumero(numero);
            this.setBairro(bairro);
            this.setCidade(cidade);
            this.setCep(cep);
            this.setEstado(estado);
	}
        
        public String getEstado(){
            return this.estado;
        }
                
        
        public void setEstado(String estado){
            if(estado != null){
                this.estado = estado;
            }
        }
                
        public void setCep(String cep){
            if(cep != null){
                this.cep = cep;
            }
        }
        
        public void setCidade(String cidade){
            if(cidade != null){
                this.cidade = cidade;
            }
        }
        
        public void setBairro(String bairro){
            if(bairro != null){
                this.bairro = bairro;
            }
        }
        
        public void setNumero(int num){
            if(num > 0){
                this.numero = num;
            }
        }
        
        public void setLogradouro(String logradouro){
            if(logradouro != null){
                this.logradouro = logradouro;
            }
        }
	
	//Metodos
	public String getLogradouro(){
		return this.logradouro;
	}
	
	public int getNumero(){
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