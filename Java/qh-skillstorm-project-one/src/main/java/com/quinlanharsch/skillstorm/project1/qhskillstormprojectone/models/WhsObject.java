package com.quinlanharsch.skillstorm.project1.qhskillstormprojectone.models;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "whsobjects")
public class WhsObject {
    
    @Id
    @ManyToOne
    @JoinColumn(name = "whsid")
    private int warehouse;
    @Id
    @ManyToOne
    @JoinColumn(name = "typid")
    private int type;
    @Column
    private int quantity;
    @Column
    private String note;
    @Column
    private String userlogged;
    @Column
    private Timestamp calltime;
    
    public WhsObject() {
    }

    public WhsObject(int warehouse, int type, int quantity, String note) {
        this.warehouse = warehouse;
        this.type = type;
        this.quantity = quantity;
        this.note = note;
        //this.calltime = now;
    }

    public WhsObject(int warehouse, int type, int quantity, String note, String userlogged, Timestamp calltime) {
        this.warehouse = warehouse;
        this.type = type;
        this.quantity = quantity;
        this.note = note;
        this.userlogged = userlogged;
        this.calltime = calltime;
    }

    public int getWarehouse() {
        return warehouse;
    }
    public void setWarehouse(int warehouse) {
        this.warehouse = warehouse;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
    public String getUserlogged() {
        return userlogged;
    }
    public void setUserlogged(String userlogged) {
        this.userlogged = userlogged;
    }
    public Timestamp getCalltime() {
        return calltime;
    }
    public void setCalltime(Timestamp calltime) {
        this.calltime = calltime;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + warehouse;
        result = prime * result + type;
        result = prime * result + quantity;
        result = prime * result + ((note == null) ? 0 : note.hashCode());
        result = prime * result + ((userlogged == null) ? 0 : userlogged.hashCode());
        result = prime * result + ((calltime == null) ? 0 : calltime.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        WhsObject other = (WhsObject) obj;
        if (warehouse != other.warehouse)
            return false;
        if (type != other.type)
            return false;
        if (quantity != other.quantity)
            return false;
        if (note == null) {
            if (other.note != null)
                return false;
        } else if (!note.equals(other.note))
            return false;
        if (userlogged == null) {
            if (other.userlogged != null)
                return false;
        } else if (!userlogged.equals(other.userlogged))
            return false;
        if (calltime == null) {
            if (other.calltime != null)
                return false;
        } else if (!calltime.equals(other.calltime))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "WhsObject [warehouse=" + warehouse + ", type=" + type + ", quantity=" + quantity + ", note=" + note
                + ", userlogged=" + userlogged + ", calltime=" + calltime + "]";
    }   
}
