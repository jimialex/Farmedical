/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmedical.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author WIN7
 */
@Entity
@Table(name = "motivo_permiso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MotivoPermiso.findAll", query = "SELECT m FROM MotivoPermiso m"),
    @NamedQuery(name = "MotivoPermiso.findByIdMotivo", query = "SELECT m FROM MotivoPermiso m WHERE m.idMotivo = :idMotivo"),
    @NamedQuery(name = "MotivoPermiso.findByMotivoPermiso", query = "SELECT m FROM MotivoPermiso m WHERE m.motivoPermiso = :motivoPermiso")})
public class MotivoPermiso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_motivo")
    private Integer idMotivo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "motivo_permiso")
    private String motivoPermiso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMotivo")
    private Collection<Permiso> permisoCollection;

    public MotivoPermiso() {
    }

    public MotivoPermiso(Integer idMotivo) {
        this.idMotivo = idMotivo;
    }

    public MotivoPermiso(Integer idMotivo, String motivoPermiso) {
        this.idMotivo = idMotivo;
        this.motivoPermiso = motivoPermiso;
    }

    public Integer getIdMotivo() {
        return idMotivo;
    }

    public void setIdMotivo(Integer idMotivo) {
        this.idMotivo = idMotivo;
    }

    public String getMotivoPermiso() {
        return motivoPermiso;
    }

    public void setMotivoPermiso(String motivoPermiso) {
        this.motivoPermiso = motivoPermiso;
    }

    @XmlTransient
    public Collection<Permiso> getPermisoCollection() {
        return permisoCollection;
    }

    public void setPermisoCollection(Collection<Permiso> permisoCollection) {
        this.permisoCollection = permisoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMotivo != null ? idMotivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MotivoPermiso)) {
            return false;
        }
        MotivoPermiso other = (MotivoPermiso) object;
        if ((this.idMotivo == null && other.idMotivo != null) || (this.idMotivo != null && !this.idMotivo.equals(other.idMotivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ " + idMotivo + " ] "+motivoPermiso;
    }
    
}
