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
public class Employee {
    @Id
    private String employee_id;
    private String employee_name;
    private String residence_district;

    public Employee() {
    }

    public Employee(String employee_id, String employee_name, String residence_district) {
        this.employee_id = employee_id;
        this.employee_name = employee_name;
        this.residence_district = residence_district;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getResidence_district() {
        return residence_district;
    }

    public void setResidence_district(String residence_district) {
        this.residence_district = residence_district;
    }
    
    
    
}
