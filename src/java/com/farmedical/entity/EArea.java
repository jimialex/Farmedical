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
@Table(name = "e_area")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EArea.findAll", query = "SELECT e FROM EArea e"),
    @NamedQuery(name = "EArea.findByIdArea", query = "SELECT e FROM EArea e WHERE e.idArea = :idArea"),
    @NamedQuery(name = "EArea.findByDato", query = "SELECT e FROM EArea e WHERE e.dato = :dato"),
    @NamedQuery(name = "EArea.findByArea", query = "SELECT e FROM EArea e WHERE e.area = :area")})
public class EArea implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_area")
    private Integer idArea;
    @Size(max = 50)
    @Column(name = "dato")
    private String dato;
    @Size(max = 50)
    @Column(name = "area")
    private String area;
    @JoinColumn(name = "id_regional", referencedColumnName = "id_regional")
    @ManyToOne
    private ERegional idRegional;
    @OneToMany(mappedBy = "idArea")
    private Collection<Cargo> cargoCollection;

    public EArea() {
    }

    public EArea(Integer idArea) {
        this.idArea = idArea;
    }

    public Integer getIdArea() {
        return idArea;
    }

    public void setIdArea(Integer idArea) {
        this.idArea = idArea;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public ERegional getIdRegional() {
        return idRegional;
    }

    public void setIdRegional(ERegional idRegional) {
        this.idRegional = idRegional;
    }

    @XmlTransient
    public Collection<Cargo> getCargoCollection() {
        return cargoCollection;
    }

    public void setCargoCollection(Collection<Cargo> cargoCollection) {
        this.cargoCollection = cargoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArea != null ? idArea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EArea)) {
            return false;
        }
        EArea other = (EArea) object;
        if ((this.idArea == null && other.idArea != null) || (this.idArea != null && !this.idArea.equals(other.idArea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ " + idArea + " ] "+area;
    }
    
}
