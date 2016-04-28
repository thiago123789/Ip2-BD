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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "professor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Professor.findAll", query = "SELECT p FROM Professor p"),
    @NamedQuery(name = "Professor.findByCpfProf", query = "SELECT p FROM Professor p WHERE p.cpfProf = :cpfProf"),
    @NamedQuery(name = "Professor.findByCargo", query = "SELECT p FROM Professor p WHERE p.cargo = :cargo")})
public class Professor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CPF_PROF")
    private String cpfProf;
    @Basic(optional = false)
    @Column(name = "CARGO")
    private String cargo;
    @JoinColumn(name = "CPF_PROF", referencedColumnName = "CPF_P", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Pessoa pessoa;

    public Professor() {
    }

    public Professor(String cpfProf) {
        this.cpfProf = cpfProf;
    }

    public Professor(String cpfProf, String cargo) {
        this.cpfProf = cpfProf;
        this.cargo = cargo;
    }

    public String getCpfProf() {
        return cpfProf;
    }

    public void setCpfProf(String cpfProf) {
        this.cpfProf = cpfProf;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cpfProf != null ? cpfProf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Professor)) {
            return false;
        }
        Professor other = (Professor) object;
        if ((this.cpfProf == null && other.cpfProf != null) || (this.cpfProf != null && !this.cpfProf.equals(other.cpfProf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "poo.dados.tabelas.Professor[ cpfProf=" + cpfProf + " ]";
    }
    
}
