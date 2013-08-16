/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmedical.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author WIN7
 */
@Entity
@Table(name = "p_empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PEmpleado.findAll", query = "SELECT p FROM PEmpleado p"),
    @NamedQuery(name = "PEmpleado.findByIdEmpleado", query = "SELECT p FROM PEmpleado p WHERE p.idEmpleado = :idEmpleado"),
    @NamedQuery(name = "PEmpleado.findByAcademico", query = "SELECT p FROM PEmpleado p WHERE p.academico = :academico"),
    @NamedQuery(name = "PEmpleado.findByFechaAlta", query = "SELECT p FROM PEmpleado p WHERE p.fechaAlta = :fechaAlta"),
    @NamedQuery(name = "PEmpleado.findByFechaBaja", query = "SELECT p FROM PEmpleado p WHERE p.fechaBaja = :fechaBaja"),
    @NamedQuery(name = "PEmpleado.findByCorreo", query = "SELECT p FROM PEmpleado p WHERE p.correo = :correo"),
    @NamedQuery(name = "PEmpleado.findByCargo", query = "SELECT p FROM PEmpleado p WHERE p.cargo = :cargo"),
    @NamedQuery(name = "PEmpleado.findByDocumentoUrl", query = "SELECT p FROM PEmpleado p WHERE p.documentoUrl = :documentoUrl"),
    @NamedQuery(name = "PEmpleado.findByNivel", query = "SELECT p FROM PEmpleado p WHERE p.nivel = :nivel")})
public class PEmpleado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_empleado")
    private Integer idEmpleado;
    @Size(max = 45)
    @Column(name = "academico")
    private String academico;
    @Column(name = "fecha_alta")
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;
    @Column(name = "fecha_baja")
    @Temporal(TemporalType.DATE)
    private Date fechaBaja;
    @Size(max = 2147483647)
    @Column(name = "correo")
    private String correo;
    @Size(max = 35)
    @Column(name = "cargo")
    private String cargo;
    @Size(max = 100)
    @Column(name = "documento_url")
    private String documentoUrl;
    @Size(max = 10)
    @Column(name = "nivel")
    private String nivel;
    @OneToMany(mappedBy = "idEmpleado")
    private Collection<Agenda> agendaCollection;
    @OneToMany(mappedBy = "idEmpleado")
    private Collection<PFuncion> pFuncionCollection;
    @OneToMany(mappedBy = "idEmpleado")
    private Collection<Plantilla> plantillaCollection;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    @ManyToOne
    private Persona idPersona;
    @JoinColumn(name = "id_cargo", referencedColumnName = "id_cargo")
    @ManyToOne
    private Cargo idCargo;
    @OneToMany(mappedBy = "idEmpleado")
    private Collection<Activos> activosCollection;
    @OneToMany(mappedBy = "idEmpleado")
    private Collection<HRegistro> hRegistroCollection;
    

    public PEmpleado() {
    }

    public PEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getAcademico() {
        return academico;
    }

    public void setAcademico(String academico) {
        this.academico = academico;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDocumentoUrl() {
        return documentoUrl;
    }

    public void setDocumentoUrl(String documentoUrl) {
        this.documentoUrl = documentoUrl;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    @XmlTransient
    public Collection<Agenda> getAgendaCollection() {
        return agendaCollection;
    }

    public void setAgendaCollection(Collection<Agenda> agendaCollection) {
        this.agendaCollection = agendaCollection;
    }

    @XmlTransient
    public Collection<PFuncion> getPFuncionCollection() {
        return pFuncionCollection;
    }

    public void setPFuncionCollection(Collection<PFuncion> pFuncionCollection) {
        this.pFuncionCollection = pFuncionCollection;
    }

    @XmlTransient
    public Collection<Plantilla> getPlantillaCollection() {
        return plantillaCollection;
    }

    public void setPlantillaCollection(Collection<Plantilla> plantillaCollection) {
        this.plantillaCollection = plantillaCollection;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    public Cargo getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Cargo idCargo) {
        this.idCargo = idCargo;
    }

    @XmlTransient
    public Collection<Activos> getActivosCollection() {
        return activosCollection;
    }

    public void setActivosCollection(Collection<Activos> activosCollection) {
        this.activosCollection = activosCollection;
    }

   /* 
*/
    @XmlTransient
    public Collection<HRegistro> getHRegistroCollection() {
        return hRegistroCollection;
    }

    public void setHRegistroCollection(Collection<HRegistro> hRegistroCollection) {
        this.hRegistroCollection = hRegistroCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpleado != null ? idEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PEmpleado)) {
            return false;
        }
        PEmpleado other = (PEmpleado) object;
        if ((this.idEmpleado == null && other.idEmpleado != null) || (this.idEmpleado != null && !this.idEmpleado.equals(other.idEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idEmpleado+" "+ idPersona;
        //idPersona.toString();
    }
    
}
