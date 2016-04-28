/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.dados.tabelas;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Thiago Gomes
 */
@Entity
@Table(name = "pessoa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p"),
    @NamedQuery(name = "Pessoa.findByCpfP", query = "SELECT p FROM Pessoa p WHERE p.cpfP = :cpfP"),
    @NamedQuery(name = "Pessoa.findByPNome", query = "SELECT p FROM Pessoa p WHERE p.pNome = :pNome"),
    @NamedQuery(name = "Pessoa.findByUNome", query = "SELECT p FROM Pessoa p WHERE p.uNome = :uNome"),
    @NamedQuery(name = "Pessoa.findBySexo", query = "SELECT p FROM Pessoa p WHERE p.sexo = :sexo"),
    @NamedQuery(name = "Pessoa.findBySenha", query = "SELECT p FROM Pessoa p WHERE p.senha = :senha"),
    @NamedQuery(name = "Pessoa.findByEmail", query = "SELECT p FROM Pessoa p WHERE p.email = :email"),
    @NamedQuery(name = "Pessoa.findByLogradouro", query = "SELECT p FROM Pessoa p WHERE p.logradouro = :logradouro"),
    @NamedQuery(name = "Pessoa.findByCep", query = "SELECT p FROM Pessoa p WHERE p.cep = :cep"),
    @NamedQuery(name = "Pessoa.findByTipoPessoa", query = "SELECT p FROM Pessoa p WHERE p.tipoPessoa = :tipoPessoa"),
    @NamedQuery(name = "Pessoa.findByCidade", query = "SELECT p FROM Pessoa p WHERE p.cidade = :cidade"),
    @NamedQuery(name = "Pessoa.findByBairro", query = "SELECT p FROM Pessoa p WHERE p.bairro = :bairro"),
    @NamedQuery(name = "Pessoa.findByNumero", query = "SELECT p FROM Pessoa p WHERE p.numero = :numero"),
    @NamedQuery(name = "Pessoa.findByEstado", query = "SELECT p FROM Pessoa p WHERE p.estado = :estado")})
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CPF_P")
    private String cpfP;
    @Basic(optional = false)
    @Column(name = "P_NOME")
    private String pNome;
    @Basic(optional = false)
    @Column(name = "U_NOME")
    private String uNome;
    @Basic(optional = false)
    @Column(name = "SEXO")
    private boolean sexo;
    @Basic(optional = false)
    @Column(name = "SENHA")
    private String senha;
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @Column(name = "LOGRADOURO")
    private String logradouro;
    @Basic(optional = false)
    @Column(name = "CEP")
    private String cep;
    @Column(name = "TIPO_PESSOA")
    private Integer tipoPessoa;
    @Basic(optional = false)
    @Column(name = "CIDADE")
    private String cidade;
    @Basic(optional = false)
    @Column(name = "BAIRRO")
    private String bairro;
    @Basic(optional = false)
    @Column(name = "NUMERO")
    private int numero;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private String estado;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pessoa")
    private Aluno aluno;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pessoa")
    private Professor professor;

    public Pessoa() {
    }

    public Pessoa(String cpfP) {
        this.cpfP = cpfP;
    }

    public Pessoa(String cpfP, String pNome, String uNome, boolean sexo, String senha, String email, String logradouro, String cep, String cidade, String bairro, int numero, String estado) {
        this.cpfP = cpfP;
        this.pNome = pNome;
        this.uNome = uNome;
        this.sexo = sexo;
        this.senha = senha;
        this.email = email;
        this.logradouro = logradouro;
        this.cep = cep;
        this.cidade = cidade;
        this.bairro = bairro;
        this.numero = numero;
        this.estado = estado;
    }

    public String getCpfP() {
        return cpfP;
    }

    public void setCpfP(String cpfP) {
        this.cpfP = cpfP;
    }

    public String getPNome() {
        return pNome;
    }

    public void setPNome(String pNome) {
        this.pNome = pNome;
    }

    public String getUNome() {
        return uNome;
    }

    public void setUNome(String uNome) {
        this.uNome = uNome;
    }

    public boolean getSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(Integer tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cpfP != null ? cpfP.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.cpfP == null && other.cpfP != null) || (this.cpfP != null && !this.cpfP.equals(other.cpfP))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "poo.dados.tabelas.Pessoa[ cpfP=" + cpfP + " ]";
    }
    
}
