package com.quinlanharsch.skillstorm.project1.qhskillstormprojectone.models;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "objtypes")
public class ObjType {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int typid;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private BigDecimal size;
    @Column
    private String userlogged;
    @Column
    private Timestamp calltime;
    
    @JsonBackReference
    @OneToMany(targetEntity = WhsObject.class, mappedBy = "type")
    private Set<WhsObject> whsobjects;

    public ObjType() {
    }

    public ObjType(String name, String description, BigDecimal size, String userlogged) {
        this.name = name;
        this.description = description;
        this.size = size;
        this.userlogged = userlogged;
        this.userlogged = "admin";
        this.calltime = new Timestamp(System.currentTimeMillis());
    }

    public ObjType(int typid, String name, String description, BigDecimal size, String userlogged, Timestamp calltime,
            Set<WhsObject> whsobjects) {
        this.typid = typid;
        this.name = name;
        this.description = description;
        this.size = size;
        this.userlogged = userlogged;
        this.calltime = calltime;
        this.whsobjects = whsobjects;
    }

    public int getTypid() {
        return typid;
    }
    public void setTypid(int typid) {
        this.typid = typid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public BigDecimal getSize() {
        return size;
    }
    public void setSize(BigDecimal size) {
        this.size = size;
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
    public Set<WhsObject> getWhsobjects() {
        return whsobjects;
    }
    public void setWhsobjects(Set<WhsObject> whsobjects) {
        this.whsobjects = whsobjects;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + typid;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((size == null) ? 0 : size.hashCode());
        result = prime * result + ((userlogged == null) ? 0 : userlogged.hashCode());
        result = prime * result + ((calltime == null) ? 0 : calltime.hashCode());
        result = prime * result + ((whsobjects == null) ? 0 : whsobjects.hashCode());
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
        ObjType other = (ObjType) obj;
        if (typid != other.typid)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (size == null) {
            if (other.size != null)
                return false;
        } else if (!size.equals(other.size))
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
        if (whsobjects == null) {
            if (other.whsobjects != null)
                return false;
        } else if (!whsobjects.equals(other.whsobjects))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ObjType [typid=" + typid + ", name=" + name + ", description=" + description + ", size=" + size
                + ", userlogged=" + userlogged + ", calltime=" + calltime + "]";
    }
}
