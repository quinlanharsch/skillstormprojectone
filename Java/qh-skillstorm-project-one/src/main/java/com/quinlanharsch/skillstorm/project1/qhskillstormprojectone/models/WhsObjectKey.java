package com.quinlanharsch.skillstorm.project1.qhskillstormprojectone.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class WhsObjectKey implements Serializable {
    
    //NOTE Composite keys in the model require a seperate Serializable object to be used as the id in WhsObject 

    @Column(name = "whsid")
    private int warehouseId;

    @Column(name = "typid")
    private int typeId;

    public WhsObjectKey() {
    }

    public WhsObjectKey(int warehouse, int type) {
        this.warehouseId = warehouse;
        this.typeId = type;
    }

    public int getWarehouseId() {
        return warehouseId;
    }
    public void setWarehouseId(int warehouse) {
        this.warehouseId = warehouse;
    }
    public int getTypeId() {
        return typeId;
    }
    public void setTypeId(int type) {
        this.typeId = type;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + warehouseId;
        result = prime * result + typeId;
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
        if (warehouseId != other.warehouseId)
            return false;
        if (typeId != other.typeId)
            return false;
        return true;
    }
}
