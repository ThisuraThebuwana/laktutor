package com.arumosam.laktutor.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tutor {
    private Integer tutorid;
    private String fname;
    private String lname;
    private String username;
    private String password;
    private String contactno;
    private String email;
    private String address;

    public Tutor() {
    }

    public Tutor(Integer tutorid, String fname, String lname, String username, String password, String contactno, String email, String address) {
        this.tutorid = tutorid;
        this.fname = fname;
        this.lname = lname;
        this.username = username;
        this.password = password;
        this.contactno = contactno;
        this.email = email;
        this.address = address;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getTutorid() {
        return tutorid;
    }

    public void setTutorid(Integer tutorid) {
        this.tutorid = tutorid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
