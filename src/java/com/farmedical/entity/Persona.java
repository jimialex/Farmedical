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
@Table(name = "persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findByIdPersona", query = "SELECT p FROM Persona p WHERE p.idPersona = :idPersona"),
    @NamedQuery(name = "Persona.findByCi", query = "SELECT p FROM Persona p WHERE p.ci = :ci"),
    @NamedQuery(name = "Persona.findByNombre", query = "SELECT p FROM Persona p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Persona.findByPaterno", query = "SELECT p FROM Persona p WHERE p.paterno = :paterno"),
    @NamedQuery(name = "Persona.findByMaterno", query = "SELECT p FROM Persona p WHERE p.materno = :materno"),
    @NamedQuery(name = "Persona.findByFechaNacimiento", query = "SELECT p FROM Persona p WHERE p.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Persona.findByFoto", query = "SELECT p FROM Persona p WHERE p.foto = :foto")})
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_persona")
    private Integer idPersona;
    @Size(max = 20)
    @Column(name = "ci")
    private String ci;
    @Size(max = 2147483647)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 2147483647)
    @Column(name = "paterno")
    private String paterno;
    @Size(max = 2147483647)
    @Column(name = "materno")
    private String materno;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Size(max = 200)
    @Column(name = "foto")
    private String foto;
    @OneToMany(mappedBy = "idPersona")
    private Collection<PEmpleado> pEmpleadoCollection;
    @OneToMany(mappedBy = "idPersona")
    private Collection<PTelefono> pTelefonoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona")
    private Collection<Vacacion> vacacionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona")
    private Collection<Permiso> permisoCollection;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne
    private Users idUser;
    @JoinColumn(name = "id_regional", referencedColumnName = "id_regional")
    @ManyToOne
    private ERegional idRegional;

    public Persona() {
    }

    public Persona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @XmlTransient
    public Collection<PEmpleado> getPEmpleadoCollection() {
        return pEmpleadoCollection;
    }

    public void setPEmpleadoCollection(Collection<PEmpleado> pEmpleadoCollection) {
        this.pEmpleadoCollection = pEmpleadoCollection;
    }
@XmlTransient
    public Collection<Vacacion> getVacacionCollection() {
        return vacacionCollection;
    }
public void setVacacionCollection(Collection<Vacacion> vacacionCollection) {
        this.vacacionCollection = vacacionCollection;
    }

@XmlTransient
    public Collection<Permiso> getPermisoCollection() {
        return permisoCollection;
    }

    public void setPermisoCollection(Collection<Permiso> permisoCollection) {
        this.permisoCollection = permisoCollection;
    }
    
    @XmlTransient
    public Collection<PTelefono> getPTelefonoCollection() {
        return pTelefonoCollection;
    }

    public void setPTelefonoCollection(Collection<PTelefono> pTelefonoCollection) {
        this.pTelefonoCollection = pTelefonoCollection;
    }

    public Users getIdUser() {
        return idUser;
    }

    public void setIdUser(Users idUser) {
        this.idUser = idUser;
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
        hash += (idPersona != null ? idPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.idPersona == null && other.idPersona != null) || (this.idPersona != null && !this.idPersona.equals(other.idPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[" + idPersona+"] " +"" + nombre+" " +paterno +" " +materno;
    }
    
    public String retNom(int x){
        if(x==idPersona)
            return "[" + idPersona+"] " +"" + nombre+" " +paterno +" " +materno;
        return null;
    }
}
