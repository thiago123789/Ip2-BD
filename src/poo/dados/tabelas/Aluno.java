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
@Table(name = "aluno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aluno.findAll", query = "SELECT a FROM Aluno a"),
    @NamedQuery(name = "Aluno.findByCpfAlu", query = "SELECT a FROM Aluno a WHERE a.cpfAlu = :cpfAlu"),
    @NamedQuery(name = "Aluno.findByPrioridade", query = "SELECT a FROM Aluno a WHERE a.prioridade = :prioridade"),
    @NamedQuery(name = "Aluno.findByCurso", query = "SELECT a FROM Aluno a WHERE a.curso = :curso"),
    @NamedQuery(name = "Aluno.findByAnoEntrada", query = "SELECT a FROM Aluno a WHERE a.anoEntrada = :anoEntrada"),
    @NamedQuery(name = "Aluno.findBySemestreEntrada", query = "SELECT a FROM Aluno a WHERE a.semestreEntrada = :semestreEntrada"),
    @NamedQuery(name = "Aluno.findByTurno", query = "SELECT a FROM Aluno a WHERE a.turno = :turno")})
public class Aluno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CPF_ALU")
    private String cpfAlu;
    @Basic(optional = false)
    @Column(name = "PRIORIDADE")
    private boolean prioridade;
    @Basic(optional = false)
    @Column(name = "CURSO")
    private int curso;
    @Basic(optional = false)
    @Column(name = "ANO_ENTRADA")
    private int anoEntrada;
    @Basic(optional = false)
    @Column(name = "SEMESTRE_ENTRADA")
    private int semestreEntrada;
    @Basic(optional = false)
    @Column(name = "TURNO")
    private String turno;
    @JoinColumn(name = "CPF_ALU", referencedColumnName = "CPF_P", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Pessoa pessoa;

    public Aluno() {
    }

    public Aluno(String cpfAlu) {
        this.cpfAlu = cpfAlu;
    }

    public Aluno(String cpfAlu, boolean prioridade, int curso, int anoEntrada, int semestreEntrada, String turno) {
        this.cpfAlu = cpfAlu;
        this.prioridade = prioridade;
        this.curso = curso;
        this.anoEntrada = anoEntrada;
        this.semestreEntrada = semestreEntrada;
        this.turno = turno;
    }

    public String getCpfAlu() {
        return cpfAlu;
    }

    public void setCpfAlu(String cpfAlu) {
        this.cpfAlu = cpfAlu;
    }

    public boolean getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(boolean prioridade) {
        this.prioridade = prioridade;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public int getAnoEntrada() {
        return anoEntrada;
    }

    public void setAnoEntrada(int anoEntrada) {
        this.anoEntrada = anoEntrada;
    }

    public int getSemestreEntrada() {
        return semestreEntrada;
    }

    public void setSemestreEntrada(int semestreEntrada) {
        this.semestreEntrada = semestreEntrada;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
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
        hash += (cpfAlu != null ? cpfAlu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aluno)) {
            return false;
        }
        Aluno other = (Aluno) object;
        if ((this.cpfAlu == null && other.cpfAlu != null) || (this.cpfAlu != null && !this.cpfAlu.equals(other.cpfAlu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "poo.dados.tabelas.Aluno[ cpfAlu=" + cpfAlu + " ]";
    }
    
}
