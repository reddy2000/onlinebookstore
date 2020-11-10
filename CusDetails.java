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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vishnu
 */
@Entity
@Table(name = "CUS_DETAILS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CusDetails.findAll", query = "SELECT c FROM CusDetails c")
    , @NamedQuery(name = "CusDetails.findById", query = "SELECT c FROM CusDetails c WHERE c.id = :id")
    , @NamedQuery(name = "CusDetails.findByCusname", query = "SELECT c FROM CusDetails c WHERE c.cusname = :cusname")
    , @NamedQuery(name = "CusDetails.findByEmail", query = "SELECT c FROM CusDetails c WHERE c.email = :email")
    , @NamedQuery(name = "CusDetails.findByPhone", query = "SELECT c FROM CusDetails c WHERE c.phone = :phone")
    , @NamedQuery(name = "CusDetails.findByAge", query = "SELECT c FROM CusDetails c WHERE c.age = :age")
    , @NamedQuery(name = "CusDetails.findByPassword", query = "SELECT c FROM CusDetails c WHERE c.password = :password")
    , @NamedQuery(name = "CusDetails.findByDNo", query = "SELECT c FROM CusDetails c WHERE c.dNo = :dNo")
    , @NamedQuery(name = "CusDetails.findByStreet", query = "SELECT c FROM CusDetails c WHERE c.street = :street")
    , @NamedQuery(name = "CusDetails.findByCity", query = "SELECT c FROM CusDetails c WHERE c.city = :city")
    , @NamedQuery(name = "CusDetails.findByState", query = "SELECT c FROM CusDetails c WHERE c.state = :state")
    , @NamedQuery(name = "CusDetails.findByZipCode", query = "SELECT c FROM CusDetails c WHERE c.zipCode = :zipCode")})
public class CusDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "CUSNAME")
    private String cusname;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "AGE")
    private Integer age;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "D_NO")
    private String dNo;
    @Column(name = "STREET")
    private String street;
    @Column(name = "CITY")
    private String city;
    @Column(name = "STATE")
    private String state;
    @Column(name = "ZIP_CODE")
    private Integer zipCode;

    public CusDetails() {
    }

    public CusDetails(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCusname() {
        return cusname;
    }

    public void setCusname(String cusname) {
        this.cusname = cusname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDNo() {
        return dNo;
    }

    public void setDNo(String dNo) {
        this.dNo = dNo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
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
        if (!(object instanceof CusDetails)) {
            return false;
        }
        CusDetails other = (CusDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "project5.CusDetails[ id=" + id + " ]";
    }
    
}
