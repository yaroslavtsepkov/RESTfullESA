package com.ssau.restfulesa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity(name = "notes")
public class Notes implements BasicModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_note;

    @Column(name = "id_user")
    private Integer id_user;

    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId_note() {
        return id_note;
    }

    public void setId_note(Integer id_note) {
        this.id_note = id_note;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Notes(Integer id_note, Integer id_user, String content) {
        this.id_note = id_note;
        this.id_user = id_user;
        this.content = content;
    }
    public Notes() {
    }


    @Override
    public int getId() {
        return id_note;
    }

    @Override
    public String getTableName() {
        return "notes";
    }
}
