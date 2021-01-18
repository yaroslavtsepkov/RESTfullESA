package com.ssau.restfulesa.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "notes")
public class NotesXML {
    @XmlElement
    List<Notes> notes = new ArrayList<>();

    public NotesXML() {
    }

    public NotesXML(List<Notes> notes) {
        this.notes = notes;
    }

    public List<Notes> getNotes() {
        return notes;
    }
}