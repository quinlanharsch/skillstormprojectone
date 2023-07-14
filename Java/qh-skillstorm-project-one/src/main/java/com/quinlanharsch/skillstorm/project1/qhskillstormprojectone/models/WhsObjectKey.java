package com.quinlanharsch.skillstorm.project1.qhskillstormprojectone.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class WhsObjectKey implements Serializable {
    //NOTE Composite keys in the model require a seperate Serializable object to be used as the id in WhsObject 

    @Column(name = "whsid")
    private int whsid;

    @Column(name = "typid")
    private int typid;

    public WhsObjectKey() {
    }

    public WhsObjectKey(int warehouse, int type) {
        this.whsid = warehouse;
        this.typid = type;
    }

    public int getWhsid() {
        return whsid;
    }

    public void setWhsid(int whsid) {
        this.whsid = whsid;
    }

    public int getTypid() {
        return typid;
    }

    public void setTypid(int typid) {
        this.typid = typid;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + whsid;
        result = prime * result + typid;
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
        WhsObjectKey other = (WhsObjectKey) obj;
        if (whsid != other.whsid)
            return false;
        if (typid != other.typid)
            return false;
        return true;
    }
}
