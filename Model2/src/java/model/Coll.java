/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 昊阳
 */
@Entity
@Table(name = "Coll")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Coll.findAll", query = "SELECT c FROM Coll c"),
    @NamedQuery(name = "Coll.findById", query = "SELECT c FROM Coll c WHERE c.id = :id")})
public class Coll implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "idb", referencedColumnName = "bid")
    @ManyToOne(optional = false)
    private Business idb;
    @JoinColumn(name = "idu", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private User idu;

    public Coll() {
    }

    public Coll(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Business getIdb() {
        return idb;
    }

    public void setIdb(Business idb) {
        this.idb = idb;
    }

    public User getIdu() {
        return idu;
    }

    public void setIdu(User idu) {
        this.idu = idu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Coll)) {
            return false;
        }
        Coll other = (Coll) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Coll[ id=" + id + " ]";
    }
    
}
