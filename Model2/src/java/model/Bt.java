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
@Table(name = "bt")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bt.findAll", query = "SELECT b FROM Bt b"),
    @NamedQuery(name = "Bt.findByBtid", query = "SELECT b FROM Bt b WHERE b.btid = :btid")})
public class Bt implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "btid")
    private Integer btid;
    @JoinColumn(name = "bid", referencedColumnName = "bid")
    @ManyToOne
    private Business bid;
    @JoinColumn(name = "Tname", referencedColumnName = "tname")
    @ManyToOne
    private Tag tname;

    public Bt() {
    }

    public Bt(Integer btid) {
        this.btid = btid;
    }

    public Integer getBtid() {
        return btid;
    }

    public void setBtid(Integer btid) {
        this.btid = btid;
    }

    public Business getBid() {
        return bid;
    }

    public void setBid(Business bid) {
        this.bid = bid;
    }

    public Tag getTname() {
        return tname;
    }

    public void setTname(Tag tname) {
        this.tname = tname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (btid != null ? btid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bt)) {
            return false;
        }
        Bt other = (Bt) object;
        if ((this.btid == null && other.btid != null) || (this.btid != null && !this.btid.equals(other.btid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Bt[ btid=" + btid + " ]";
    }
    
}
