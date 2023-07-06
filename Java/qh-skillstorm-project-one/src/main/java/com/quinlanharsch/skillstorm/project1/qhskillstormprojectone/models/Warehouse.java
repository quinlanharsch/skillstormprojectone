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
@Table(name = "warehouses")
public class Warehouse {
    
    // COLUMN DEFFINITION
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int whsid;
    @Column
    private String name;
    @Column
    private BigDecimal capacity;
    @Column
    private boolean climatecontrolled;
    @Column
    private boolean manager;
    @Column
    private String street1;
    @Column
    private String street2;
    @Column
    private String city;
    @Column
    private String state;
    @Column
    private String zip;
    @Column
    private String country;
    @Column
    private String userlogged;
    @Column
    private Timestamp calltime;
    
    // REFS
    @JsonBackReference
    @OneToMany(targetEntity = WhsObject.class, mappedBy = "warehouse")   // mappedBy is the name of thhe JAVA VARIABLE in the other object
    private Set<WhsObject> whsobjects;

    // CONSTRUCTORS
    public Warehouse() {
    }

    public Warehouse(int whsid, String name, BigDecimal capacity, boolean climatecontrolled, boolean manager,
            String street1, String street2, String city, String state, String zip, String country, String userlogged,
            Timestamp calltime, Set<WhsObject> whsobjects) {
        this.whsid = whsid;
        this.name = name;
        this.capacity = capacity;
        this.climatecontrolled = climatecontrolled;
        this.manager = manager;
        this.street1 = street1;
        this.street2 = street2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
        this.userlogged = userlogged;
        this.calltime = calltime;
        this.whsobjects = whsobjects;
    }

    public Warehouse(String name, BigDecimal capacity, boolean climatecontrolled, boolean manager, String street1,
            String street2, String city, String state, String zip, String country) {
        this.name = name;
        this.capacity = capacity;
        this.climatecontrolled = climatecontrolled;
        this.manager = manager;
        this.street1 = street1;
        this.street2 = street2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
        this.userlogged = "admin";
        this.calltime = new Timestamp(System.currentTimeMillis());
    }

    //GETTERS SETTERS
    public int getWhsid() {
        return whsid;
    }
    public void setWhsid(int whsid) {
        this.whsid = whsid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public BigDecimal getCapacity() {
        return capacity;
    }
    public void setCapacity(BigDecimal capacity) {
        this.capacity = capacity;
    }
    public boolean isClimatecontrolled() {
        return climatecontrolled;
    }
    public void setClimatecontrolled(boolean climatecontrolled) {
        this.climatecontrolled = climatecontrolled;
    }
    public boolean isManager() {
        return manager;
    }
    public void setManager(boolean manager) {
        this.manager = manager;
    }
    public String getStreet1() {
        return street1;
    }
    public void setStreet1(String street1) {
        this.street1 = street1;
    }
    public String getStreet2() {
        return street2;
    }
    public void setStreet2(String street2) {
        this.street2 = street2;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getZip() {
        return zip;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
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

    // HASH AND EQ
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + whsid;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((capacity == null) ? 0 : capacity.hashCode());
        result = prime * result + (climatecontrolled ? 1231 : 1237);
        result = prime * result + (manager ? 1231 : 1237);
        result = prime * result + ((street1 == null) ? 0 : street1.hashCode());
        result = prime * result + ((street2 == null) ? 0 : street2.hashCode());
        result = prime * result + ((city == null) ? 0 : city.hashCode());
        result = prime * result + ((state == null) ? 0 : state.hashCode());
        result = prime * result + ((zip == null) ? 0 : zip.hashCode());
        result = prime * result + ((country == null) ? 0 : country.hashCode());
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
        Warehouse other = (Warehouse) obj;
        if (whsid != other.whsid)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (capacity == null) {
            if (other.capacity != null)
                return false;
        } else if (!capacity.equals(other.capacity))
            return false;
        if (climatecontrolled != other.climatecontrolled)
            return false;
        if (manager != other.manager)
            return false;
        if (street1 == null) {
            if (other.street1 != null)
                return false;
        } else if (!street1.equals(other.street1))
            return false;
        if (street2 == null) {
            if (other.street2 != null)
                return false;
        } else if (!street2.equals(other.street2))
            return false;
        if (city == null) {
            if (other.city != null)
                return false;
        } else if (!city.equals(other.city))
            return false;
        if (state == null) {
            if (other.state != null)
                return false;
        } else if (!state.equals(other.state))
            return false;
        if (zip == null) {
            if (other.zip != null)
                return false;
        } else if (!zip.equals(other.zip))
            return false;
        if (country == null) {
            if (other.country != null)
                return false;
        } else if (!country.equals(other.country))
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

    // TOSTRING
    @Override
    public String toString() {
        return "Warehouse [whsid=" + whsid + ", name=" + name + ", capacity=" + capacity + ", climatecontrolled="
                + climatecontrolled + ", manager=" + manager + ", street1=" + street1 + ", street2=" + street2
                + ", city=" + city + ", state=" + state + ", zip=" + zip + ", country=" + country + "]";
    }
}
