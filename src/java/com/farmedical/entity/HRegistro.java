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
@Table(name = "h_registro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HRegistro.findAll", query = "SELECT h FROM HRegistro h"),
    @NamedQuery(name = "HRegistro.findByIdregistro", query = "SELECT h FROM HRegistro h WHERE h.idregistro = :idregistro"),
    @NamedQuery(name = "HRegistro.findByFecha", query = "SELECT h FROM HRegistro h WHERE h.fecha = :fecha"),
    @NamedQuery(name = "HRegistro.findByHora", query = "SELECT h FROM HRegistro h WHERE h.hora = :hora"),
    @NamedQuery(name = "HRegistro.findByEntradaM", query = "SELECT h FROM HRegistro h WHERE h.entradaM = :entradaM"),
    @NamedQuery(name = "HRegistro.findBySalidaM", query = "SELECT h FROM HRegistro h WHERE h.salidaM = :salidaM"),
    @NamedQuery(name = "HRegistro.findByIngresoT", query = "SELECT h FROM HRegistro h WHERE h.ingresoT = :ingresoT"),
    @NamedQuery(name = "HRegistro.findBySalidaT", query = "SELECT h FROM HRegistro h WHERE h.salidaT = :salidaT"),
    @NamedQuery(name = "HRegistro.findByContinuoE", query = "SELECT h FROM HRegistro h WHERE h.continuoE = :continuoE"),
    @NamedQuery(name = "HRegistro.findByContinuoS", query = "SELECT h FROM HRegistro h WHERE h.continuoS = :continuoS"),
    @NamedQuery(name = "HRegistro.findByRetraso", query = "SELECT h FROM HRegistro h WHERE h.retraso = :retraso")})
public class HRegistro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idregistro")
    private Integer idregistro;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Column(name = "entrada_m")
    @Temporal(TemporalType.TIME)
    private Date entradaM;
    @Column(name = "salida_m")
    @Temporal(TemporalType.TIME)
    private Date salidaM;
    @Column(name = "ingreso_t")
    @Temporal(TemporalType.TIME)
    private Date ingresoT;
    @Column(name = "salida_t")
    @Temporal(TemporalType.TIME)
    private Date salidaT;
    @Column(name = "continuo_e")
    @Temporal(TemporalType.TIME)
    private Date continuoE;
    @Column(name = "continuo_s")
    @Temporal(TemporalType.TIME)
    private Date continuoS;
    @Column(name = "retraso")
    @Temporal(TemporalType.TIME)
    private Date retraso;
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    @ManyToOne
    private PEmpleado idEmpleado;
    @JoinColumn(name = "idhorario", referencedColumnName = "idhorario")
    @ManyToOne
    private Horario idhorario;

    public HRegistro() {
    }

    public HRegistro(Integer idregistro) {
        this.idregistro = idregistro;
    }

    public Integer getIdregistro() {
        return idregistro;
    }

    public void setIdregistro(Integer idregistro) {
        this.idregistro = idregistro;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Date getEntradaM() {
        return entradaM;
    }

    public void setEntradaM(Date entradaM) {
        this.entradaM = entradaM;
    }

    public Date getSalidaM() {
        return salidaM;
    }

    public void setSalidaM(Date salidaM) {
        this.salidaM = salidaM;
    }

    public Date getIngresoT() {
        return ingresoT;
    }

    public void setIngresoT(Date ingresoT) {
        this.ingresoT = ingresoT;
    }

    public Date getSalidaT() {
        return salidaT;
    }

    public void setSalidaT(Date salidaT) {
        this.salidaT = salidaT;
    }

    public Date getContinuoE() {
        return continuoE;
    }

    public void setContinuoE(Date continuoE) {
        this.continuoE = continuoE;
    }

    public Date getContinuoS() {
        return continuoS;
    }

    public void setContinuoS(Date continuoS) {
        this.continuoS = continuoS;
    }

    public Date getRetraso() {
        return retraso;
    }

    public void setRetraso(Date retraso) {
        this.retraso = retraso;
    }

    public PEmpleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(PEmpleado idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Horario getIdhorario() {
        return idhorario;
    }

    public void setIdhorario(Horario idhorario) {
        this.idhorario = idhorario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idregistro != null ? idregistro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HRegistro)) {
            return false;
        }
        HRegistro other = (HRegistro) object;
        if ((this.idregistro == null && other.idregistro != null) || (this.idregistro != null && !this.idregistro.equals(other.idregistro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.farmedical.entity.HRegistro[ idregistro=" + idregistro + " ]";
    }
    
}
