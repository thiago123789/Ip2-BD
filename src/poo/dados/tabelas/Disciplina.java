/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.dados.tabelas;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Thiago Gomes
 */
@Entity
@Table(name = "disciplina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Disciplina.findAll", query = "SELECT d FROM Disciplina d"),
    @NamedQuery(name = "Disciplina.findByCodigoDis", query = "SELECT d FROM Disciplina d WHERE d.codigoDis = :codigoDis"),
    @NamedQuery(name = "Disciplina.findByNome", query = "SELECT d FROM Disciplina d WHERE d.nome = :nome"),
    @NamedQuery(name = "Disciplina.findByCurso", query = "SELECT d FROM Disciplina d WHERE d.curso = :curso"),
    @NamedQuery(name = "Disciplina.findByCargaHoraria", query = "SELECT d FROM Disciplina d WHERE d.cargaHoraria = :cargaHoraria"),
    @NamedQuery(name = "Disciplina.findByTrilha", query = "SELECT d FROM Disciplina d WHERE d.trilha = :trilha"),
    @NamedQuery(name = "Disciplina.findByOptativa", query = "SELECT d FROM Disciplina d WHERE d.optativa = :optativa"),
    @NamedQuery(name = "Disciplina.findByObrigatorioa", query = "SELECT d FROM Disciplina d WHERE d.obrigatorioa = :obrigatorioa"),
    @NamedQuery(name = "Disciplina.findByGraduacao", query = "SELECT d FROM Disciplina d WHERE d.graduacao = :graduacao"),
    @NamedQuery(name = "Disciplina.findByPosgraduacao", query = "SELECT d FROM Disciplina d WHERE d.posgraduacao = :posgraduacao")})
public class Disciplina implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODIGO_DIS")
    private String codigoDis;
    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;
    @Basic(optional = false)
    @Column(name = "CURSO")
    private int curso;
    @Basic(optional = false)
    @Column(name = "CARGA_HORARIA")
    private int cargaHoraria;
    @Column(name = "TRILHA")
    private String trilha;
    @Column(name = "OPTATIVA")
    private Boolean optativa;
    @Column(name = "OBRIGATORIOA")
    private Boolean obrigatorioa;
    @Column(name = "GRADUACAO")
    private Boolean graduacao;
    @Column(name = "POSGRADUACAO")
    private Boolean posgraduacao;
    @JoinTable(name = "pre_requisito", joinColumns = {
        @JoinColumn(name = "DISCIPLINA", referencedColumnName = "CODIGO_DIS")}, inverseJoinColumns = {
        @JoinColumn(name = "PREREQUISITO", referencedColumnName = "CODIGO_DIS")})
    @ManyToMany
    private Collection<Disciplina> disciplinaCollection;
    @ManyToMany(mappedBy = "disciplinaCollection")
    private Collection<Disciplina> disciplinaCollection1;

    public Disciplina() {
    }

    public Disciplina(String codigoDis) {
        this.codigoDis = codigoDis;
    }

    public Disciplina(String codigoDis, String nome, int curso, int cargaHoraria) {
        this.codigoDis = codigoDis;
        this.nome = nome;
        this.curso = curso;
        this.cargaHoraria = cargaHoraria;
    }

    public String getCodigoDis() {
        return codigoDis;
    }

    public void setCodigoDis(String codigoDis) {
        this.codigoDis = codigoDis;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getTrilha() {
        return trilha;
    }

    public void setTrilha(String trilha) {
        this.trilha = trilha;
    }

    public Boolean getOptativa() {
        return optativa;
    }

    public void setOptativa(Boolean optativa) {
        this.optativa = optativa;
    }

    public Boolean getObrigatorioa() {
        return obrigatorioa;
    }

    public void setObrigatorioa(Boolean obrigatorioa) {
        this.obrigatorioa = obrigatorioa;
    }

    public Boolean getGraduacao() {
        return graduacao;
    }

    public void setGraduacao(Boolean graduacao) {
        this.graduacao = graduacao;
    }

    public Boolean getPosgraduacao() {
        return posgraduacao;
    }

    public void setPosgraduacao(Boolean posgraduacao) {
        this.posgraduacao = posgraduacao;
    }

    @XmlTransient
    public Collection<Disciplina> getDisciplinaCollection() {
        return disciplinaCollection;
    }

    public void setDisciplinaCollection(Collection<Disciplina> disciplinaCollection) {
        this.disciplinaCollection = disciplinaCollection;
    }

    @XmlTransient
    public Collection<Disciplina> getDisciplinaCollection1() {
        return disciplinaCollection1;
    }

    public void setDisciplinaCollection1(Collection<Disciplina> disciplinaCollection1) {
        this.disciplinaCollection1 = disciplinaCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoDis != null ? codigoDis.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Disciplina)) {
            return false;
        }
        Disciplina other = (Disciplina) object;
        if ((this.codigoDis == null && other.codigoDis != null) || (this.codigoDis != null && !this.codigoDis.equals(other.codigoDis))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "poo.dados.tabelas.Disciplina[ codigoDis=" + codigoDis + " ]";
    }
    
}
