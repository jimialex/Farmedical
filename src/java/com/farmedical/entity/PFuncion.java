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
@Table(name = "p_funcion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PFuncion.findAll", query = "SELECT p FROM PFuncion p"),
    @NamedQuery(name = "PFuncion.findByIdFuncion", query = "SELECT p FROM PFuncion p WHERE p.idFuncion = :idFuncion"),
    @NamedQuery(name = "PFuncion.findByRutaFuncion", query = "SELECT p FROM PFuncion p WHERE p.rutaFuncion = :rutaFuncion"),
    @NamedQuery(name = "PFuncion.findByTipoFuncion", query = "SELECT p FROM PFuncion p WHERE p.tipoFuncion = :tipoFuncion")})
public class PFuncion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_funcion")
    private Integer idFuncion;
    @Size(max = 100)
    @Column(name = "ruta_funcion")
    private String rutaFuncion;
    @Size(max = 30)
    @Column(name = "tipo_funcion")
    private String tipoFuncion;
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    @ManyToOne
    private PEmpleado idEmpleado;

    public PFuncion() {
    }

    public PFuncion(Integer idFuncion) {
        this.idFuncion = idFuncion;
    }

    public Integer getIdFuncion() {
        return idFuncion;
    }

    public void setIdFuncion(Integer idFuncion) {
        this.idFuncion = idFuncion;
    }

    public String getRutaFuncion() {
        return rutaFuncion;
    }

    public void setRutaFuncion(String rutaFuncion) {
        this.rutaFuncion = rutaFuncion;
    }

    public String getTipoFuncion() {
        return tipoFuncion;
    }

    public void setTipoFuncion(String tipoFuncion) {
        this.tipoFuncion = tipoFuncion;
    }

    public PEmpleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(PEmpleado idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFuncion != null ? idFuncion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PFuncion)) {
            return false;
        }
        PFuncion other = (PFuncion) object;
        if ((this.idFuncion == null && other.idFuncion != null) || (this.idFuncion != null && !this.idFuncion.equals(other.idFuncion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ " + idFuncion + " ] "+tipoFuncion;
    }
    
}
