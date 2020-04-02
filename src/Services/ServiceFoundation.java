/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;


import Entities.foundation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.ConnexionBD;


/**
 *
 * @author Memmicha
 */

public class ServiceFoundation {
      
     Connection c= ConnexionBD.getInstance().getCnx();
    
    public void ajouterFoundation(foundation f) {
        
          String requet="INSERT INTO foundation (nameFoundation, address,description,phone,email) VALUES (?,?,?,?,?)" ; 
        
        try {
            PreparedStatement pre = c.prepareCall(requet);
          
            pre.setString(1,f.getNameFoundation());
            pre.setString(2,f.getAddress());
            pre.setString(3,f.getDescription());
            pre.setInt(4,f.getPhone());
            pre.setString(5,f.getEmail());
            pre.executeUpdate();
           
        
        } catch (SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(ServiceMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
      public void ajouterFoundation1(foundation f){
        try {
            String req= "INSERT INTO foundation (nameFoundation, address,description,phone,email) VALUES ('"+f.getNameFoundation()+"', '"+f.getAddress()+"', '"+f.getDescription()+"', '"+f.getPhone()+"', '"+f.getEmail()+"')";
            Statement st = c.createStatement();
            st.executeUpdate(req);
            System.out.println ("Successful insertion");
        } catch (SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(ServiceMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
      
       public void UpdateFoundation(foundation f){
        try {
            String req= "UPDATE foundation SET id='"+f.getId()+"' WHERE Id ='"+f.getId()+"'";
            Statement st = c.createStatement();
            st.executeUpdate(req);
            System.out.println ("Update done !");
        } catch (SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(ServiceMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
   } 
    
      public void getFoundations(foundation f){
         
 
String r="select * from foundation" ; 
try {
Statement stt=c.createStatement() ; 
ResultSet rs=stt.executeQuery(r); 
while(rs.next()) {
    foundation cl; 
    cl = new foundation();
    cl.setId(rs.getInt(1));
    cl.setNameFoundation(rs.getString(2));
    cl.setAddress(rs.getString(3));
    cl.setDescription(rs.getString(4));
    cl.setPhone(rs.getInt(5));
    cl.setEmail(rs.getString(6));
       
}
          rs.last();
          int nbr =rs.getRow() ;  
          if (nbr!=0)
          {
                  System.out.println("Id: "+f.getId()+" ,Name foundation: "+f.getNameFoundation()+" ,Address: "+f.getAddress()+" ,Description: "+f.getDescription()+" ,Phone: "+f.getPhone()+" ,Email: "+f.getEmail()) ; 
          } else {
                  System.out.println(" Foundations wasn't found ") ; 
          }
}
catch (SQLException ex) {   
  
}

} 
     
     
     public void getFoundations(int id, foundation f){
 
String r="select * from foundation where id='"+id+"'" ; 
try {
Statement stt=c.createStatement() ; 
ResultSet rs=stt.executeQuery(r); 
while(rs.next()) {
     foundation cl; 
    cl = new foundation();
    cl.setId(rs.getInt(1));
    cl.setNameFoundation(rs.getString(2));
    cl.setAddress(rs.getString(3));
    cl.setDescription(rs.getString(4));
    cl.setPhone(rs.getInt(5));
    cl.setEmail(rs.getString(6));
}

  rs.last();
          int nbr =rs.getRow() ;  
          if (nbr!=0)
          {
                 System.out.println("Id: "+f.getId()+" Name foundation: "+f.getNameFoundation()+" Address: "+f.getAddress()+" Description: "+f.getDescription()+"Phone: "+f.getPhone()+"Email: "+f.getEmail()) ; 
          } else {
                  System.out.println("Foundations weren't found ") ; 
          }
        }
catch (SQLException ex) {
    System.out.println(ex.getMessage()) ;
}

} 
     
              
      public void chercherParType( String nameFoundation )
{  try { 
            String query ="SELECT * FROM foundation WHERE nameFoundation='"+nameFoundation+"'" ; 
            Statement st=c.createStatement();
    ResultSet rst = st.executeQuery(query);
         rst.last();
          int nbr =rst.getRow() ;  
          if (nbr!=0)
          {
                  System.out.println("foundation was found ") ; 
          } else {
                  System.out.println("foundation wasn't found ") ; 
          }
                  
        }catch (SQLException ex){
            System.out.println(ex.getMessage()) ; 
            
        }
}
        public void chercherParAddress( String address )
{  try { 
            String query ="SELECT * FROM foundation WHERE address ='"+address+"'" ; 
            Statement st=c.createStatement();
    ResultSet rst = st.executeQuery(query);
         rst.last();
          int nbr =rst.getRow() ;  
          if (nbr!=0)
          {
                  System.out.println("foundation was found ") ; 
          } else {
                  System.out.println("foundation wasn't found") ; 
          }
                 }catch (SQLException ex){
            System.out.println(ex.getMessage()) ; 
            
        }
    

}
        public void modifierFoundation(int id, String nameFoundation, String address, String description, int phone, String email)
{ try {
     String query ="UPDATE foundation SET nameFoundation='"+nameFoundation+"',address='"+address+"',description='"+description+"',phone='"+phone+"',email='"+email+"' WHERE id='"+id+"'";
     Statement st=c.createStatement();
      st.executeUpdate(query) ;
      System.out.println("Foundation has been modified");
} catch (SQLException ex){
            System.out.println(ex.getMessage()) ; 
            
        }
    
}
     public void supprimerparID (int id) {
        
        try { 
            String query ="DELETE FROM foundation WHERE id= '"+id+"'" ; 
            Statement st=c.createStatement();
            st.executeUpdate(query); 
            System.out.println("foundation with id = "+id+" was deleted") ; 
            }
        catch(SQLException ex){
            System.out.println(ex.getMessage()) ; 
            
        }
    }
     public void supprimerparName (String nameFoundation) {
        
        try { 
            String query ="DELETE FROM foundation WHERE nameFoundation= '"+nameFoundation+"'" ; 
            Statement st=c.createStatement();
            st.executeUpdate(query) ; 
            System.out.println("le foundation de nameFoundation= "+nameFoundation+" was deleted ") ;    
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage()) ; 
            
        }
    }  
}
