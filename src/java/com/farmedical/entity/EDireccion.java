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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author WIN7
 */
@Entity
@Table(name = "e_direccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EDireccion.findAll", query = "SELECT e FROM EDireccion e"),
    @NamedQuery(name = "EDireccion.findByIdDireccion", query = "SELECT e FROM EDireccion e WHERE e.idDireccion = :idDireccion"),
    @NamedQuery(name = "EDireccion.findByCalle", query = "SELECT e FROM EDireccion e WHERE e.calle = :calle"),
    @NamedQuery(name = "EDireccion.findByCiudad", query = "SELECT e FROM EDireccion e WHERE e.ciudad = :ciudad"),
    @NamedQuery(name = "EDireccion.findByDepartamento", query = "SELECT e FROM EDireccion e WHERE e.departamento = :departamento"),
    @NamedQuery(name = "EDireccion.findByNro", query = "SELECT e FROM EDireccion e WHERE e.nro = :nro"),
    @NamedQuery(name = "EDireccion.findByPais", query = "SELECT e FROM EDireccion e WHERE e.pais = :pais"),
    @NamedQuery(name = "EDireccion.findByZona", query = "SELECT e FROM EDireccion e WHERE e.zona = :zona")})
public class EDireccion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_direccion")
    private Integer idDireccion;
    @Size(max = 255)
    @Column(name = "calle")
    private String calle;
    @Size(max = 255)
    @Column(name = "ciudad")
    private String ciudad;
    @Size(max = 255)
    @Column(name = "departamento")
    private String departamento;
    @Column(name = "nro")
    private Integer nro;
    @Size(max = 255)
    @Column(name = "pais")
    private String pais;
    @Size(max = 255)
    @Column(name = "zona")
    private String zona;
    @JoinColumn(name = "id_regional", referencedColumnName = "id_regional")
    @ManyToOne
    private ERegional idRegional;

    public EDireccion() {
    }

    public EDireccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    public Integer getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Integer getNro() {
        return nro;
    }

    public void setNro(Integer nro) {
        this.nro = nro;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public ERegional getIdRegional() {
        return idRegional;
    }

    public void setIdRegional(ERegional idRegional) {
        this.idRegional = idRegional;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDireccion != null ? idDireccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EDireccion)) {
            return false;
        }
        EDireccion other = (EDireccion) object;
        if ((this.idDireccion == null && other.idDireccion != null) || (this.idDireccion != null && !this.idDireccion.equals(other.idDireccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ " + idDireccion + " ] "+idRegional.toString();
    }
    
}
