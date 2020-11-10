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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vishnu
 */
@Entity
@Table(name = "BOOK_DETAIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BookDetail.findAll", query = "SELECT b FROM BookDetail b")
    , @NamedQuery(name = "BookDetail.findByIsbn", query = "SELECT b FROM BookDetail b WHERE b.isbn = :isbn")
    , @NamedQuery(name = "BookDetail.findByCategory", query = "SELECT b FROM BookDetail b WHERE b.category = :category")
    , @NamedQuery(name = "BookDetail.findByBookLanguage", query = "SELECT b FROM BookDetail b WHERE b.bookLanguage = :bookLanguage")
    , @NamedQuery(name = "BookDetail.findByAvailability", query = "SELECT b FROM BookDetail b WHERE b.availability = :availability")
    , @NamedQuery(name = "BookDetail.findByPrice", query = "SELECT b FROM BookDetail b WHERE b.price = :price")
    , @NamedQuery(name = "BookDetail.findByAccessibility", query = "SELECT b FROM BookDetail b WHERE b.accessibility = :accessibility")})
public class BookDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ISBN")
    private Integer isbn;
    @Lob
    @Column(name = "NAME")
    private String name;
    @Lob
    @Column(name = "AUTHOR")
    private String author;
    @Column(name = "CATEGORY")
    private String category;
    @Column(name = "BOOK_LANGUAGE")
    private String bookLanguage;
    @Column(name = "AVAILABILITY")
    private Integer availability;
    @Column(name = "PRICE")
    private Integer price;
    @Lob
    @Column(name = "IMAGE")
    private byte[] image;
    @Column(name = "ACCESSIBILITY")
    private Integer accessibility;

    public BookDetail() {
    }

    public BookDetail(Integer isbn) {
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBookLanguage() {
        return bookLanguage;
    }

    public void setBookLanguage(String bookLanguage) {
        this.bookLanguage = bookLanguage;
    }

    public Integer getAvailability() {
        return availability;
    }

    public void setAvailability(Integer availability) {
        this.availability = availability;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Icon getImage() {
        Icon my = new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(150, 200, java.awt.Image.SCALE_SMOOTH));
        return my;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Integer getAccessibility() {
        return accessibility;
    }

    public void setAccessibility(Integer accessibility) {
        this.accessibility = accessibility;
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
        if (!(object instanceof BookDetail)) {
            return false;
        }
        BookDetail other = (BookDetail) object;
        if ((this.isbn == null && other.isbn != null) || (this.isbn != null && !this.isbn.equals(other.isbn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "project5.BookDetail[ isbn=" + isbn + " ]";
    }
    
}
