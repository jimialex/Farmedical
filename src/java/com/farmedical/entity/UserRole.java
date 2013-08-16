/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmedical.entity;

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
 * @author WIN7
 */
@Entity
@Table(name = "user_role")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserRole.findAll", query = "SELECT u FROM UserRole u"),
    @NamedQuery(name = "UserRole.findByEstado", query = "SELECT u FROM UserRole u WHERE u.estado = :estado"),
    @NamedQuery(name = "UserRole.findByIdUserrole", query = "SELECT u FROM UserRole u WHERE u.idUserrole = :idUserrole")})
public class UserRole implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "estado")
    private Boolean estado;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_userrole")
    private Integer idUserrole;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne(optional = false)
    private Users idUser;
    @JoinColumn(name = "id_role", referencedColumnName = "id_role")
    @ManyToOne
    private Roles idRole;

    public UserRole() {
    }

    public UserRole(Integer idUserrole) {
        this.idUserrole = idUserrole;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Integer getIdUserrole() {
        return idUserrole;
    }

    public void setIdUserrole(Integer idUserrole) {
        this.idUserrole = idUserrole;
    }

    public Users getIdUser() {
        return idUser;
    }

    public void setIdUser(Users idUser) {
        this.idUser = idUser;
    }

    public Roles getIdRole() {
        return idRole;
    }

    public void setIdRole(Roles idRole) {
        this.idRole = idRole;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUserrole != null ? idUserrole.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserRole)) {
            return false;
        }
        UserRole other = (UserRole) object;
        if ((this.idUserrole == null && other.idUserrole != null) || (this.idUserrole != null && !this.idUserrole.equals(other.idUserrole))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.farmedical.entity.UserRole[ idUserrole=" + idUserrole + " ]";
    }
    
}
