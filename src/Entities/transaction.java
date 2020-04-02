/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author Memmicha
 */
public class transaction {
    private int id;
    private String Name;
    private String Last_Name;
    private double RIB;
    public Date Date_Expiration; 
    private float Montant;
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public void setLast_Name(String Last_Name) {
        this.Last_Name = Last_Name;
    }

    public double getRIB() {
        return RIB;
    }

    public void setRIB(double RIB) {
        this.RIB = RIB;
    }

    public Date getDate_Expiration() {
        return Date_Expiration;
    }

    public void setDate_Expiration(Date Date_Expiration) {
        this.Date_Expiration = Date_Expiration;
    }

    public float getMontant() {
        return Montant;
    }

    public void setMontant(float Montant) {
        this.Montant = Montant;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    
   public transaction(int id, String Name,String Last_Name,double RIB,Date Date_Expiration, float Montant,String address) {
    this.id=id;
    this.Name=Name;
    this.Last_Name=Last_Name;
    this.RIB=RIB;
    this.Date_Expiration = Date_Expiration;
    this.Montant=Montant;
    this.address=address;
    
    } 
   public transaction() { }

    @Override
    public String toString() {
        return "transaction{" + "id=" + id + ", Name=" + Name + ", Last_Name=" + Last_Name + ", RIB=" + RIB + ", Date_Expiration=" + Date_Expiration + ", Montant=" + Montant + ", address=" + address + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.RIB) ^ (Double.doubleToLongBits(this.RIB) >>> 32));
        hash = 59 * hash + Float.floatToIntBits(this.Montant);
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
        final transaction other = (transaction) obj;
        if (!Objects.equals(this.Name, other.Name)) {
            return false;
        }
        if (!Objects.equals(this.Last_Name, other.Last_Name)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        return true;
    }

    
}
