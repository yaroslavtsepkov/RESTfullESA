package com.ssau.restfulesa.entity;

import java.util.List;

public class NotesList {
    private List<Notes> notes;

    public List<Notes> getNotes() {
        return notes;
    }

    public void setNotes(List<Notes> notes) {
        this.notes = notes;
    }

    public NotesList(List<Notes> notes) {
        this.notes = notes;
    }
}
