/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Objects;


/**
 *
 * @author Memmicha
 */
public class foundation {
    private int id;
    private String nameFoundation;
    private String address;
    private String description;
    private int phone;
    private String email;
    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameFoundation() {
        return nameFoundation;
    }

    public void setNameFoundation(String nameFoundation) {
        this.nameFoundation = nameFoundation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public foundation() {}; 

    public foundation(int id, String nameFoundation, String address, String description, int phone, String email) {
        this.id = id;
        this.nameFoundation = nameFoundation;
        this.address = address;
        this.description = description;
        this.phone = phone;
        this.email = email;
       
    }

    @Override
    public String toString() {
        return "foundation{" + "id=" + id + ", nameFoundation=" + nameFoundation + ", address=" + address + ", description=" + description + ", phone=" + phone + ", email=" + email + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
        hash = 29 * hash + this.phone;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final foundation other = (foundation) obj;
        if (!Objects.equals(this.nameFoundation, other.nameFoundation)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }
   
}
