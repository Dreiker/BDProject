/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Juan Manuel
 */
@Entity
@Table(name = "accounts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accounts.findAll", query = "SELECT a FROM Accounts a"),
    @NamedQuery(name = "Accounts.findByAccountId", query = "SELECT a FROM Accounts a WHERE a.accountId = :accountId"),
    @NamedQuery(name = "Accounts.findByAccountName", query = "SELECT a FROM Accounts a WHERE a.accountName = :accountName"),
    @NamedQuery(name = "Accounts.findByMd5PassHash", query = "SELECT a FROM Accounts a WHERE a.md5PassHash = :md5PassHash"),
    @NamedQuery(name = "Accounts.findByEmail", query = "SELECT a FROM Accounts a WHERE a.email = :email"),
    @NamedQuery(name = "Accounts.findByLastIp", query = "SELECT a FROM Accounts a WHERE a.lastIp = :lastIp"),
    @NamedQuery(name = "Accounts.findByOnline", query = "SELECT a FROM Accounts a WHERE a.online = :online"),
    @NamedQuery(name = "Accounts.findByLastLogin", query = "SELECT a FROM Accounts a WHERE a.lastLogin = :lastLogin"),
    @NamedQuery(name = "Accounts.findByCreationDate", query = "SELECT a FROM Accounts a WHERE a.creationDate = :creationDate"),
    @NamedQuery(name = "Accounts.findByActive", query = "SELECT a FROM Accounts a WHERE a.active = :active"),
    @NamedQuery(name = "Accounts.findByTemporal", query = "SELECT a FROM Accounts a WHERE a.temporal = :temporal")})
public class Accounts implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "account_id")
    private Integer accountId;
    @Column(name = "account_name")
    private String accountName;
    @Column(name = "md5_pass_hash")
    private String md5PassHash;
    @Column(name = "email")
    private String email;
    @Column(name = "last_ip")
    private String lastIp;
    @Column(name = "online")
    private Boolean online;
    @Column(name = "last_login")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Column(name = "active")
    private Boolean active;
    @Column(name = "temporal")
    private Boolean temporal;
    @OneToMany(mappedBy = "accountId")
    private Collection<SpecialPermissions> specialPermissionsCollection;
    @OneToMany(mappedBy = "accountId")
    private Collection<AccountBan> accountBanCollection;

    public Accounts() {
    }

    public Accounts(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getMd5PassHash() {
        return md5PassHash;
    }

    public void setMd5PassHash(String md5PassHash) {
        this.md5PassHash = md5PassHash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getTemporal() {
        return temporal;
    }

    public void setTemporal(Boolean temporal) {
        this.temporal = temporal;
    }

    @XmlTransient
    public Collection<SpecialPermissions> getSpecialPermissionsCollection() {
        return specialPermissionsCollection;
    }

    public void setSpecialPermissionsCollection(Collection<SpecialPermissions> specialPermissionsCollection) {
        this.specialPermissionsCollection = specialPermissionsCollection;
    }

    @XmlTransient
    public Collection<AccountBan> getAccountBanCollection() {
        return accountBanCollection;
    }

    public void setAccountBanCollection(Collection<AccountBan> accountBanCollection) {
        this.accountBanCollection = accountBanCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountId != null ? accountId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accounts)) {
            return false;
        }
        Accounts other = (Accounts) object;
        if ((this.accountId == null && other.accountId != null) || (this.accountId != null && !this.accountId.equals(other.accountId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.entities.Accounts[ accountId=" + accountId + " ]";
    }
    
}
