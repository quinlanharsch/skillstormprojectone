package com.quinlanharsch.skillstorm.project1.qhskillstormprojectone.models;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "whsobjects")
public class WhsObject {
    
    @EmbeddedId
    WhsObjectKey id;

    @ManyToOne
    @MapsId("warehouseId")
    @JoinColumn(name = "whsid", insertable = false, updatable = false)
    private Warehouse warehouse;
    // referencedColumnName = "whsid"

    @ManyToOne
    @MapsId("typeId")
    @JoinColumn(name = "typid", insertable = false, updatable = false)
    private ObjType objtype;
    
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
    
    public WhsObject(WhsObjectKey id, Warehouse warehouse, ObjType objtype, int quantity, String note) {
        this.id = id;
        this.warehouse = warehouse;
        this.objtype = objtype;
        this.quantity = quantity;
        this.note = note;
    }
    
    public Warehouse getWarehouse() {
        return warehouse;
    }
    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
    public ObjType getObjtype() {
        return objtype;
    }
    public void setObjtype(ObjType type) {
        this.objtype = type;
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
    public WhsObjectKey getId() {
        return id;
    }
    public void setId(WhsObjectKey id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((warehouse == null) ? 0 : warehouse.hashCode());
        result = prime * result + ((objtype == null) ? 0 : objtype.hashCode());
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
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (warehouse == null) {
            if (other.warehouse != null)
                return false;
        } else if (!warehouse.equals(other.warehouse))
            return false;
        if (objtype == null) {
            if (other.objtype != null)
                return false;
        } else if (!objtype.equals(other.objtype))
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
        return "WhsObject [id=" + id + ", whsid=" + warehouse + ", typid=" + objtype + ", quantity=" + quantity + ", note="
                + note + ", userlogged=" + userlogged + ", calltime=" + calltime + "]";
    }   
}
