/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.dados.tabelas;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Thiago Gomes
 */
@Embeddable
public class HistoricoLoginPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "CPF_LOG")
    private String cpfLog;
    @Basic(optional = false)
    @Column(name = "DATA_LOGIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataLogin;

    public HistoricoLoginPK() {
    }

    public HistoricoLoginPK(String cpfLog, Date dataLogin) {
        this.cpfLog = cpfLog;
        this.dataLogin = dataLogin;
    }

    public String getCpfLog() {
        return cpfLog;
    }

    public void setCpfLog(String cpfLog) {
        this.cpfLog = cpfLog;
    }

    public Date getDataLogin() {
        return dataLogin;
    }

    public void setDataLogin(Date dataLogin) {
        this.dataLogin = dataLogin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cpfLog != null ? cpfLog.hashCode() : 0);
        hash += (dataLogin != null ? dataLogin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistoricoLoginPK)) {
            return false;
        }
        HistoricoLoginPK other = (HistoricoLoginPK) object;
        if ((this.cpfLog == null && other.cpfLog != null) || (this.cpfLog != null && !this.cpfLog.equals(other.cpfLog))) {
            return false;
        }
        if ((this.dataLogin == null && other.dataLogin != null) || (this.dataLogin != null && !this.dataLogin.equals(other.dataLogin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "poo.dados.tabelas.HistoricoLoginPK[ cpfLog=" + cpfLog + ", dataLogin=" + dataLogin + " ]";
    }
    
}
