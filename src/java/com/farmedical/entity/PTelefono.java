/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmedical.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author WIN7
 */
@Entity
@Table(name = "p_telefono")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PTelefono.findAll", query = "SELECT p FROM PTelefono p"),
    @NamedQuery(name = "PTelefono.findByIdTelefono", query = "SELECT p FROM PTelefono p WHERE p.idTelefono = :idTelefono"),
    @NamedQuery(name = "PTelefono.findByNumero", query = "SELECT p FROM PTelefono p WHERE p.numero = :numero"),
    @NamedQuery(name = "PTelefono.findByTipo", query = "SELECT p FROM PTelefono p WHERE p.tipo = :tipo")})
public class PTelefono implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "id_telefono")
    private String idTelefono;
    @Size(max = 255)
    @Column(name = "numero")
    private String numero;
    @Size(max = 255)
    @Column(name = "tipo")
    private String tipo;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    @ManyToOne
    private Persona idPersona;

    public PTelefono() {
    }

    public PTelefono(String idTelefono) {
        this.idTelefono = idTelefono;
    }

    public String getIdTelefono() {
        return idTelefono;
    }

    public void setIdTelefono(String idTelefono) {
        this.idTelefono = idTelefono;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
        hash += (idTelefono != null ? idTelefono.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PTelefono)) {
            return false;
        }
        PTelefono other = (PTelefono) object;
        if ((this.idTelefono == null && other.idTelefono != null) || (this.idTelefono != null && !this.idTelefono.equals(other.idTelefono))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.farmedical.entity.PTelefono[ idTelefono=" + idTelefono + " ]";
    }
    
}
