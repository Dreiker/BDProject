/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Juan Manuel
 */
@Entity
@Table(name = "account_ban")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccountBan.findAll", query = "SELECT a FROM AccountBan a"),
    @NamedQuery(name = "AccountBan.findByBanId", query = "SELECT a FROM AccountBan a WHERE a.banId = :banId"),
    @NamedQuery(name = "AccountBan.findByDescription", query = "SELECT a FROM AccountBan a WHERE a.description = :description"),
    @NamedQuery(name = "AccountBan.findByBannedBy", query = "SELECT a FROM AccountBan a WHERE a.bannedBy = :bannedBy"),
    @NamedQuery(name = "AccountBan.findByBanDate", query = "SELECT a FROM AccountBan a WHERE a.banDate = :banDate"),
    @NamedQuery(name = "AccountBan.findByBanFinish", query = "SELECT a FROM AccountBan a WHERE a.banFinish = :banFinish")})
public class AccountBan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ban_id")
    private Integer banId;
    @Column(name = "description")
    private String description;
    @Column(name = "bannedBy")
    private Integer bannedBy;
    @Column(name = "ban_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date banDate;
    @Column(name = "ban_finish")
    @Temporal(TemporalType.TIMESTAMP)
    private Date banFinish;
    @JoinColumn(name = "account_id", referencedColumnName = "account_id")
    @ManyToOne
    private Accounts accountId;

    public AccountBan() {
    }

    public AccountBan(Integer banId) {
        this.banId = banId;
    }

    public Integer getBanId() {
        return banId;
    }

    public void setBanId(Integer banId) {
        this.banId = banId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getBannedBy() {
        return bannedBy;
    }

    public void setBannedBy(Integer bannedBy) {
        this.bannedBy = bannedBy;
    }

    public Date getBanDate() {
        return banDate;
    }

    public void setBanDate(Date banDate) {
        this.banDate = banDate;
    }

    public Date getBanFinish() {
        return banFinish;
    }

    public void setBanFinish(Date banFinish) {
        this.banFinish = banFinish;
    }

    public Accounts getAccountId() {
        return accountId;
    }

    public void setAccountId(Accounts accountId) {
        this.accountId = accountId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (banId != null ? banId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccountBan)) {
            return false;
        }
        AccountBan other = (AccountBan) object;
        if ((this.banId == null && other.banId != null) || (this.banId != null && !this.banId.equals(other.banId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.entities.AccountBan[ banId=" + banId + " ]";
    }
    
}
