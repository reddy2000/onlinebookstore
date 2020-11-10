/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project5;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vishnu
 */
@Entity
@Table(name = "CART")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cart_1.findAll", query = "SELECT c FROM Cart_1 c")
    , @NamedQuery(name = "Cart_1.findByIsbn", query = "SELECT c FROM Cart_1 c WHERE c.isbn = :isbn")
    , @NamedQuery(name = "Cart_1.findByPrice", query = "SELECT c FROM Cart_1 c WHERE c.price = :price")
    , @NamedQuery(name = "Cart_1.findByQuantity", query = "SELECT c FROM Cart_1 c WHERE c.quantity = :quantity")
    , @NamedQuery(name = "Cart_1.findByTotalcost", query = "SELECT c FROM Cart_1 c WHERE c.totalcost = :totalcost")
    , @NamedQuery(name = "Cart_1.findByUserid", query = "SELECT c FROM Cart_1 c WHERE c.userid = :userid")})
public class Cart_1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ISBN")
    private Integer isbn;
    @Lob
    @Column(name = "NAME")
    private String name;
    @Column(name = "PRICE")
    private Integer price;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @Lob
    @Column(name = "IMAGE")
    private byte[] image;
    @Column(name = "TOTALCOST")
    private Integer totalcost;
    @Column(name = "USERID")
    private String userid;

    public Cart_1() {
    }

    public Cart_1(Integer isbn) {
        this.isbn = isbn;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Integer getTotalcost() {
        return totalcost;
    }

    public void setTotalcost(Integer totalcost) {
        this.totalcost = totalcost;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (isbn != null ? isbn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cart_1)) {
            return false;
        }
        Cart_1 other = (Cart_1) object;
        if ((this.isbn == null && other.isbn != null) || (this.isbn != null && !this.isbn.equals(other.isbn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "project5.Cart_1[ isbn=" + isbn + " ]";
    }
    
}
