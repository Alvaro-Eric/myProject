/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author The flash
 */
@Entity
public class Location {
    @Id
    private String Id;
    private String name;
    private String type;
    private String parent;

    public Location() {
    }

    public Location(String Id, String name, String type, String parent) {
        this.Id = Id;
        this.name = name;
        this.type = type;
        this.parent = parent;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }
    
    
}
