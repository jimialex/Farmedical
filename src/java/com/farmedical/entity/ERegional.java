/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmedical.entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author WIN7
 */
@Entity
@Table(name = "e_regional")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ERegional.findAll", query = "SELECT e FROM ERegional e"),
    @NamedQuery(name = "ERegional.findByIdRegional", query = "SELECT e FROM ERegional e WHERE e.idRegional = :idRegional"),
    @NamedQuery(name = "ERegional.findByRegional", query = "SELECT e FROM ERegional e WHERE e.regional = :regional")})
public class ERegional implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_regional")
    private Integer idRegional;
    @Size(max = 2147483647)
    @Column(name = "regional")
    private String regional;
    @OneToMany(mappedBy = "idRegional")
    private Collection<EArea> eAreaCollection;
    @JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa")
    @ManyToOne
    private Empresa idEmpresa;
    @OneToMany(mappedBy = "idRegional")
    private Collection<ETelefono> eTelefonoCollection;
    @OneToMany(mappedBy = "idRegional")
    private Collection<EDireccion> eDireccionCollection;
    @OneToMany(mappedBy = "idRegional")
    private Collection<Persona> personaCollection;

    public ERegional() {
    }

    public ERegional(Integer idRegional) {
        this.idRegional = idRegional;
    }

    public Integer getIdRegional() {
        return idRegional;
    }

    public void setIdRegional(Integer idRegional) {
        this.idRegional = idRegional;
    }

    public String getRegional() {
        return regional;
    }

    public void setRegional(String regional) {
        this.regional = regional;
    }

    @XmlTransient
    public Collection<EArea> getEAreaCollection() {
        return eAreaCollection;
    }

    public void setEAreaCollection(Collection<EArea> eAreaCollection) {
        this.eAreaCollection = eAreaCollection;
    }

    public Empresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @XmlTransient
    public Collection<ETelefono> getETelefonoCollection() {
        return eTelefonoCollection;
    }

    public void setETelefonoCollection(Collection<ETelefono> eTelefonoCollection) {
        this.eTelefonoCollection = eTelefonoCollection;
    }

    @XmlTransient
    public Collection<EDireccion> getEDireccionCollection() {
        return eDireccionCollection;
    }

    public void setEDireccionCollection(Collection<EDireccion> eDireccionCollection) {
        this.eDireccionCollection = eDireccionCollection;
    }

    @XmlTransient
    public Collection<Persona> getPersonaCollection() {
        return personaCollection;
    }

    public void setPersonaCollection(Collection<Persona> personaCollection) {
        this.personaCollection = personaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRegional != null ? idRegional.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ERegional)) {
            return false;
        }
        ERegional other = (ERegional) object;
        if ((this.idRegional == null && other.idRegional != null) || (this.idRegional != null && !this.idRegional.equals(other.idRegional))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return " [" + idRegional + "] "+regional;
    }
    
}
