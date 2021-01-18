package com.ssau.restfulesa.entity;

import javax.persistence.*;

@Entity(name = "notes")
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_note;

    @Column(name = "id_user")
    private Integer id_user;

    @Column(name = "content")
    private String content;

    @Override
    public String toString() {
        return "Notes{" +
                "id_note=" + id_note +
                ", id_user=" + id_user +
                ", content='" + content + '\'' +
                '}';
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
}
