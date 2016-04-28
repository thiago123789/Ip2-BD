/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.dados.tabelas;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Thiago Gomes
 */
@Entity
@Table(name = "historico_login")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistoricoLogin.findAll", query = "SELECT h FROM HistoricoLogin h"),
    @NamedQuery(name = "HistoricoLogin.findByCpfLog", query = "SELECT h FROM HistoricoLogin h WHERE h.historicoLoginPK.cpfLog = :cpfLog"),
    @NamedQuery(name = "HistoricoLogin.findByDataLogin", query = "SELECT h FROM HistoricoLogin h WHERE h.historicoLoginPK.dataLogin = :dataLogin")})
public class HistoricoLogin implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HistoricoLoginPK historicoLoginPK;

    public HistoricoLogin() {
    }

    public HistoricoLogin(HistoricoLoginPK historicoLoginPK) {
        this.historicoLoginPK = historicoLoginPK;
    }

    public HistoricoLogin(String cpfLog, Date dataLogin) {
        this.historicoLoginPK = new HistoricoLoginPK(cpfLog, dataLogin);
    }

    public HistoricoLoginPK getHistoricoLoginPK() {
        return historicoLoginPK;
    }

    public void setHistoricoLoginPK(HistoricoLoginPK historicoLoginPK) {
        this.historicoLoginPK = historicoLoginPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (historicoLoginPK != null ? historicoLoginPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistoricoLogin)) {
            return false;
        }
        HistoricoLogin other = (HistoricoLogin) object;
        if ((this.historicoLoginPK == null && other.historicoLoginPK != null) || (this.historicoLoginPK != null && !this.historicoLoginPK.equals(other.historicoLoginPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "poo.dados.tabelas.HistoricoLogin[ historicoLoginPK=" + historicoLoginPK + " ]";
    }
    
}
