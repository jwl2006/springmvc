package cmpe275.controller;
import java.util.ArrayList;
import java.util.Date;


import javax.persistence.GeneratedValue;

import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Entity;


/**
 * Created by wanghao on 3/23/16.
 */
@Entity
@Table(name = "worker")
public class Profile {
    @Id
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String address;
    private String organization;
    private String aboutmyself;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstName) {
        this.firstname = firstName;
    }

    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getAboutmyself() {
        return aboutmyself;
    }

    public void setAboutmyself(String aboutmyself) {
        this.aboutmyself = aboutmyself;
    }

}
