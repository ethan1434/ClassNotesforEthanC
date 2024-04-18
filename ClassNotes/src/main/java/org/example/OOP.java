package org.example;

import java.util.Date;

public class OOP {
    private String name;
    private String note;
    private Date dateCreate;

    public OOP(String name, String note){
        this.name = name;
        this.note = note;
        this.dateCreate = new Date();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public String toString() {
        return "Name of item: " + name + ". Note about it: " + note + ". Note was made on " + dateCreate;
    }
}
