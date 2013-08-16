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
@Table(name = "e_telefono")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ETelefono.findAll", query = "SELECT e FROM ETelefono e"),
    @NamedQuery(name = "ETelefono.findByIdTelefono", query = "SELECT e FROM ETelefono e WHERE e.idTelefono = :idTelefono"),
    @NamedQuery(name = "ETelefono.findByNumero", query = "SELECT e FROM ETelefono e WHERE e.numero = :numero"),
    @NamedQuery(name = "ETelefono.findByTipo", query = "SELECT e FROM ETelefono e WHERE e.tipo = :tipo")})
public class ETelefono implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_telefono")
    private Integer idTelefono;
    @Size(max = 255)
    @Column(name = "numero")
    private String numero;
    @Size(max = 255)
    @Column(name = "tipo")
    private String tipo;
    @JoinColumn(name = "id_regional", referencedColumnName = "id_regional")
    @ManyToOne
    private ERegional idRegional;

    public ETelefono() {
    }

    public ETelefono(Integer idTelefono) {
        this.idTelefono = idTelefono;
    }

    public Integer getIdTelefono() {
        return idTelefono;
    }

    public void setIdTelefono(Integer idTelefono) {
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

    public ERegional getIdRegional() {
        return idRegional;
    }

    public void setIdRegional(ERegional idRegional) {
        this.idRegional = idRegional;
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
        if (!(object instanceof ETelefono)) {
            return false;
        }
        ETelefono other = (ETelefono) object;
        if ((this.idTelefono == null && other.idTelefono != null) || (this.idTelefono != null && !this.idTelefono.equals(other.idTelefono))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.farmedical.entity.ETelefono[ idTelefono=" + idTelefono + " ]";
    }
    
}
