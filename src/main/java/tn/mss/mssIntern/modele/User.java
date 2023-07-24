package tn.mss.mssIntern.modele;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
@Entity
@Table(name = "users")
    public class User implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String firstName;
        private String lastName;


    private String gender;

    @Column(unique = true)
        private String username;

    @Column(unique = true)
    private String email;


        private String password;
    private String ERole;


    public User() {
    }

    public User(String name, String s) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getERole() { return ERole;
    }
    public void setERole(String ERole) {
        this.ERole = ERole;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                
                ", gender='" + gender + '\'' +
                ", username='" + username + '\'' +
                ", emailAddress='" + email + '\'' +
                ", password='" + password + '\'' +
                ", ERole='" + ERole + '\'' +
                '}';
    }
}


