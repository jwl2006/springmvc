package cmpe275.controller;
import java.util.ArrayList;
import java.util.Date;


import javax.persistence.*;


/**
 * Created by wanghao on 3/23/16.
 */
@Entity
@Table(name = "worker")
public class Profile {
    @Id
    private String id;
    private String firstname ;
    private String lastname ;
    private String email;
    private String address;
    private String organization;
    @Column(name = "aboutmyself")
    private String aboutMyself;

    public Profile() {
    }

    public Profile(String id, String firstname, String lastname, String email, String address, String organization, String aboutMyself) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.address = address;
        this.organization = organization;
        this.aboutMyself = aboutMyself;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getAboutMyself() {
        return aboutMyself;
    }

    public void setAboutMyself(String aboutMyself) {
        this.aboutMyself = aboutMyself;
    }


}
