/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entities;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Juan Manuel
 */
@Entity
@Table(name = "special_permissions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SpecialPermissions.findAll", query = "SELECT s FROM SpecialPermissions s"),
    @NamedQuery(name = "SpecialPermissions.findByPermissionId", query = "SELECT s FROM SpecialPermissions s WHERE s.permissionId = :permissionId"),
    @NamedQuery(name = "SpecialPermissions.findByPermissionLevel", query = "SELECT s FROM SpecialPermissions s WHERE s.permissionLevel = :permissionLevel"),
    @NamedQuery(name = "SpecialPermissions.findByRole", query = "SELECT s FROM SpecialPermissions s WHERE s.role = :role")})
public class SpecialPermissions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "permission_id")
    private Integer permissionId;
    @Column(name = "permission_level")
    private Integer permissionLevel;
    @Column(name = "role")
    private String role;
    @JoinColumn(name = "account_id", referencedColumnName = "account_id")
    @ManyToOne
    private Accounts accountId;

    public SpecialPermissions() {
    }

    public SpecialPermissions(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public Integer getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(Integer permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
        hash += (permissionId != null ? permissionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SpecialPermissions)) {
            return false;
        }
        SpecialPermissions other = (SpecialPermissions) object;
        if ((this.permissionId == null && other.permissionId != null) || (this.permissionId != null && !this.permissionId.equals(other.permissionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.entities.SpecialPermissions[ permissionId=" + permissionId + " ]";
    }
    
}
