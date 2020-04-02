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
public class material {
     private int id;
    private String Name_address;
    private String Address;
    private String Description;
     

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_address() {
        return Name_address;
    }

    public void setName_address(String Name_address) {
        this.Name_address = Name_address;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    @Override
    public String toString() {
        return "material{" + "id=" + id + ", Name_address=" + Name_address + ", Address=" + Address + ", Description=" + Description + '}';
    }
    
    public material(){}
    
public material (int id, String Name_address, String Address, String Description){
this.id=id;
this.Name_address=Name_address;
this.Address=Address;
this.Description=Description;

}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id;
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
        final material other = (material) obj;
        if (!Objects.equals(this.Name_address, other.Name_address)) {
            return false;
        }
        if (!Objects.equals(this.Address, other.Address)) {
            return false;
        }
        if (!Objects.equals(this.Description, other.Description)) {
            return false;
        }
        return true;
    }

}
