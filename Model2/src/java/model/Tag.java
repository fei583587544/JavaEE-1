/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 昊阳
 */
@Entity
@Table(name = "tag")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tag.findAll", query = "SELECT t FROM Tag t"),
    @NamedQuery(name = "Tag.findByTname", query = "SELECT t FROM Tag t WHERE t.tname = :tname")})
public class Tag implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "tname")
    private String tname;
    @OneToMany(mappedBy = "tname")
    private Collection<Bt> btCollection;

    public Tag() {
    }

    public Tag(String tname) {
        this.tname = tname;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    @XmlTransient
    public Collection<Bt> getBtCollection() {
        return btCollection;
    }

    public void setBtCollection(Collection<Bt> btCollection) {
        this.btCollection = btCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tname != null ? tname.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tag)) {
            return false;
        }
        Tag other = (Tag) object;
        if ((this.tname == null && other.tname != null) || (this.tname != null && !this.tname.equals(other.tname))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tag[ tname=" + tname + " ]";
    }
    
}
