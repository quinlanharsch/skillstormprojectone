package com.quinlanharsch.skillstorm.project1.qhskillstormprojectone.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;

@Embeddable
public class WhsObjectKey implements Serializable {
    @NotNull
    @Column(name = "whsid")
    private int warehouse;

    @NotNull
    @Column(name = "typid")
    private int type;

    public WhsObjectKey() {
    }

    public WhsObjectKey(int warehouse, int type) {
        this.warehouse = warehouse;
        this.type = type;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + warehouse;
        result = prime * result + type;
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
        if (warehouse != other.warehouse)
            return false;
        if (type != other.type)
            return false;
        return true;
    }    
}
