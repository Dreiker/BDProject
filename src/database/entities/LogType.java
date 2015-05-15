/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Juan Manuel
 */
@Entity
@Table(name = "log_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LogType.findAll", query = "SELECT l FROM LogType l"),
    @NamedQuery(name = "LogType.findByLogTypeid", query = "SELECT l FROM LogType l WHERE l.logTypeid = :logTypeid"),
    @NamedQuery(name = "LogType.findByType", query = "SELECT l FROM LogType l WHERE l.type = :type")})
public class LogType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "logType_id")
    private Integer logTypeid;
    @Column(name = "type")
    private String type;
    @OneToMany(mappedBy = "logTypeid")
    private Collection<Log> logCollection;

    public LogType() {
    }

    public LogType(Integer logTypeid) {
        this.logTypeid = logTypeid;
    }

    public Integer getLogTypeid() {
        return logTypeid;
    }

    public void setLogTypeid(Integer logTypeid) {
        this.logTypeid = logTypeid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlTransient
    public Collection<Log> getLogCollection() {
        return logCollection;
    }

    public void setLogCollection(Collection<Log> logCollection) {
        this.logCollection = logCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (logTypeid != null ? logTypeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LogType)) {
            return false;
        }
        LogType other = (LogType) object;
        if ((this.logTypeid == null && other.logTypeid != null) || (this.logTypeid != null && !this.logTypeid.equals(other.logTypeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.entities.LogType[ logTypeid=" + logTypeid + " ]";
    }
    
}
