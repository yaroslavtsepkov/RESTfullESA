package com.ssau.restfulesa.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "users")
public class User implements BasicModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "username", length = 127)
    private String username;

    @Column(name = "password")
    private String password;

    @OneToMany
    @JoinColumn(name = "id_user")
    private List<Notes> notes;

    public List<Notes> getNotes() {
        return notes;
    }

    public void setNotes(List<Notes> notes) {
        this.notes = notes;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    @Override
    public String getTableName() {
        return "users";
    }

    public void setId(Integer id) {
        this.id = id;
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

}
