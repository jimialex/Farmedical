/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmedical.entity;

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
 * @author WIN7
 */
@Entity
@Table(name = "vacacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vacacion.findAll", query = "SELECT v FROM Vacacion v"),
    @NamedQuery(name = "Vacacion.findByIdVacacion", query = "SELECT v FROM Vacacion v WHERE v.idVacacion = :idVacacion"),
    @NamedQuery(name = "Vacacion.findByFeInicio", query = "SELECT v FROM Vacacion v WHERE v.feInicio = :feInicio"),
    @NamedQuery(name = "Vacacion.findByFeFin", query = "SELECT v FROM Vacacion v WHERE v.feFin = :feFin"),
    @NamedQuery(name = "Vacacion.findByEstado", query = "SELECT v FROM Vacacion v WHERE v.estado = :estado")})
public class Vacacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_vacacion")
    private Integer idVacacion;
    @Column(name = "fe_inicio")
    @Temporal(TemporalType.DATE)
    private Date feInicio;
    @Column(name = "fe_fin")
    @Temporal(TemporalType.DATE)
    private Date feFin;
    @Column(name = "estado")
    private Boolean estado;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_Persona")
    @ManyToOne(optional = false)
    private Persona idPersona;

    public Vacacion() {
    }

    public Vacacion(Integer idVacacion) {
        this.idVacacion = idVacacion;
    }

    public Integer getIdVacacion() {
        return idVacacion;
    }

    public void setIdVacacion(Integer idVacacion) {
        this.idVacacion = idVacacion;
    }

    public Date getFeInicio() {
        return feInicio;
    }

    public void setFeInicio(Date feInicio) {
        this.feInicio = feInicio;
    }

    public Date getFeFin() {
        return feFin;
    }

    public void setFeFin(Date feFin) {
        this.feFin = feFin;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVacacion != null ? idVacacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vacacion)) {
            return false;
        }
        Vacacion other = (Vacacion) object;
        if ((this.idVacacion == null && other.idVacacion != null) || (this.idVacacion != null && !this.idVacacion.equals(other.idVacacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ " + idVacacion + " ] "+idPersona;
    }
    
}
