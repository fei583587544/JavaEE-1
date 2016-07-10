/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "business")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Business.findAll", query = "SELECT b FROM Business b"),
    @NamedQuery(name = "Business.findByBid", query = "SELECT b FROM Business b WHERE b.bid = :bid"),
    @NamedQuery(name = "Business.findByBname", query = "SELECT b FROM Business b WHERE b.bname = :bname"),
    @NamedQuery(name = "Business.findByBaddress", query = "SELECT b FROM Business b WHERE b.baddress = :baddress"),
    @NamedQuery(name = "Business.findByBtel", query = "SELECT b FROM Business b WHERE b.btel = :btel"),
    @NamedQuery(name = "Business.findByBpic", query = "SELECT b FROM Business b WHERE b.bpic = :bpic"),
    @NamedQuery(name = "Business.findByBinfo", query = "SELECT b FROM Business b WHERE b.binfo = :binfo")})
public class Business implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "bid")
    private Integer bid;
    @Size(max = 255)
    @Column(name = "Bname")
    private String bname;
    @Size(max = 255)
    @Column(name = "Baddress")
    private String baddress;
    @Size(max = 255)
    @Column(name = "Btel")
    private String btel;
    @Size(max = 255)
    @Column(name = "Bpic")
    private String bpic;
    @Size(max = 255)
    @Column(name = "Binfo")
    private String binfo;
    @OneToMany(mappedBy = "bid")
    private Collection<Bt> btCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idb")
    private Collection<Coll> collCollection;

    public Business() {
    }

    public Business(Integer bid) {
        this.bid = bid;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBaddress() {
        return baddress;
    }

    public void setBaddress(String baddress) {
        this.baddress = baddress;
    }

    public String getBtel() {
        return btel;
    }

    public void setBtel(String btel) {
        this.btel = btel;
    }

    public String getBpic() {
        return bpic;
    }

    public void setBpic(String bpic) {
        this.bpic = bpic;
    }

    public String getBinfo() {
        return binfo;
    }

    public void setBinfo(String binfo) {
        this.binfo = binfo;
    }

    @XmlTransient
    public Collection<Bt> getBtCollection() {
        return btCollection;
    }

    public void setBtCollection(Collection<Bt> btCollection) {
        this.btCollection = btCollection;
    }

    @XmlTransient
    public Collection<Coll> getCollCollection() {
        return collCollection;
    }

    public void setCollCollection(Collection<Coll> collCollection) {
        this.collCollection = collCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bid != null ? bid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Business)) {
            return false;
        }
        Business other = (Business) object;
        if ((this.bid == null && other.bid != null) || (this.bid != null && !this.bid.equals(other.bid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Business[ bid=" + bid + " ]";
    }
    
}
