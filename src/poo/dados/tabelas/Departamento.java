/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.dados.tabelas;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Thiago Gomes
 */
@Entity
@Table(name = "departamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departamento.findAll", query = "SELECT d FROM Departamento d"),
    @NamedQuery(name = "Departamento.findByIdDep", query = "SELECT d FROM Departamento d WHERE d.idDep = :idDep"),
    @NamedQuery(name = "Departamento.findByNome", query = "SELECT d FROM Departamento d WHERE d.nome = :nome"),
    @NamedQuery(name = "Departamento.findBySigla", query = "SELECT d FROM Departamento d WHERE d.sigla = :sigla"),
    @NamedQuery(name = "Departamento.findByDiretor", query = "SELECT d FROM Departamento d WHERE d.diretor = :diretor"),
    @NamedQuery(name = "Departamento.findByVice", query = "SELECT d FROM Departamento d WHERE d.vice = :vice")})
public class Departamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_DEP")
    private Integer idDep;
    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;
    @Basic(optional = false)
    @Column(name = "SIGLA")
    private String sigla;
    @Basic(optional = false)
    @Column(name = "DIRETOR")
    private String diretor;
    @Basic(optional = false)
    @Column(name = "VICE")
    private String vice;

    public Departamento() {
    }

    public Departamento(Integer idDep) {
        this.idDep = idDep;
    }

    public Departamento(Integer idDep, String nome, String sigla, String diretor, String vice) {
        this.idDep = idDep;
        this.nome = nome;
        this.sigla = sigla;
        this.diretor = diretor;
        this.vice = vice;
    }

    public Integer getIdDep() {
        return idDep;
    }

    public void setIdDep(Integer idDep) {
        this.idDep = idDep;
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

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getVice() {
        return vice;
    }

    public void setVice(String vice) {
        this.vice = vice;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDep != null ? idDep.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamento)) {
            return false;
        }
        Departamento other = (Departamento) object;
        if ((this.idDep == null && other.idDep != null) || (this.idDep != null && !this.idDep.equals(other.idDep))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "poo.dados.tabelas.Departamento[ idDep=" + idDep + " ]";
    }
    
}
