/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.material;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.ConnexionBD;

/**
 *
 * @author Memmicha
 */
public class ServiceMaterial {
    
     Connection c= ConnexionBD.getInstance().getCnx();
    
    public void ajouterMaterial(material m) {
                                                                                               
        String requet="INSERT INTO material (Name_address, Address, Description) VALUES (?,?,?)" ; 
        
        try {
            PreparedStatement pre = c.prepareCall(requet);
            pre.setString(1,m.getName_address());
            pre.setString(2,m.getAddress());
            pre.setString(3,m.getDescription());
            pre.executeUpdate();
           
        
        } catch (SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(ServiceMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ajouterMaterial1(material m){
        try {
            String req= "INSERT INTO material (Name_address, Address, Description) VALUES ('"+m.getName_address()+"', '"+m.getAddress()+"', '"+m.getDescription()+"')";
            Statement st = c.createStatement();
            st.executeUpdate(req);
            System.out.println ("Successful insertion!");
        } catch (SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(ServiceMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    
   public void UpdateMaterial(material m){
        try {
            String req= "UPDATE material SET id='"+m.getId()+"' WHERE Id ='"+m.getId()+"'";
            Statement st = c.createStatement();
            st.executeUpdate(req);
            System.out.println ("Update done !");
        } catch (SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(ServiceMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
   } 
    
     public void getMaterials(material m){
         
 
String r="select * from material" ; 
try {
Statement stt=c.createStatement() ; 
ResultSet rs=stt.executeQuery(r); 
while(rs.next()) {
    material cl; 
    cl = new material();
    cl.setId(rs.getInt(1));
    cl.setName_address(rs.getString(2));
    cl.setAddress(rs.getString(3));
    cl.setDescription(rs.getString(4));
       
}
          rs.last();
          int nbr =rs.getRow() ;  
          if (nbr!=0)
          {
                  System.out.println("Id: "+m.getId()+" Name Address: "+m.getName_address()+" Address: "+m.getAddress()+" Description: "+m.getDescription()) ; 
          } else {
                  System.out.println("Materials wasn't found ") ; 
          }
}
catch (SQLException ex) {   
  
}

} 
     
     
     public void getMaterials(int id, material m){
 
String r="select * from material where id='"+id+"'" ; 
try {
Statement stt=c.createStatement() ; 
ResultSet rs=stt.executeQuery(r); 
while(rs.next()) {
    material cl; 
    cl = new material();
    cl.setId(rs.getInt(1));
    cl.setName_address(rs.getString(2));
    cl.setAddress(rs.getString(3));
    cl.setDescription(rs.getString(4));
    
}

  rs.last();
          int nbr =rs.getRow() ;  
          if (nbr!=0)
          {
                 System.out.println(" Name Address: "+m.getName_address()+" Address: "+m.getAddress()+" Description: "+m.getDescription()) ; 
          } else {
                  System.out.println(" Materials wasn't found ") ; 
          }
        }
catch (SQLException ex) {
    System.out.println(ex.getMessage()) ;
}

} 
     
              
      public void chercherParType( String Name_address )
{  try { 
            String query ="SELECT * FROM material WHERE Name_address='"+Name_address+"'" ; 
            Statement st=c.createStatement();
    ResultSet rst = st.executeQuery(query);
         rst.last();
          int nbr =rst.getRow() ;  
          if (nbr!=0)
          {
                  System.out.println(Name_address+" found ") ; 
          } else {
                  System.out.println(Name_address+" not found ") ; 
          }
                  
        }catch (SQLException ex){
            System.out.println(ex.getMessage()) ; 
            
        }
}
        public void chercherParAddress( String Address )
{  try { 
            String query ="SELECT * FROM material WHERE address ='"+Address+"'" ; 
            Statement st=c.createStatement();
    ResultSet rst = st.executeQuery(query);
         rst.last();
          int nbr =rst.getRow() ;  
          if (nbr!=0)
          {
                  System.out.println(Address+" found ") ; 
          } else {
                  System.out.println(Address+" not found") ; 
          }
                 }catch (SQLException ex){
            System.out.println(ex.getMessage()) ; 
            
        }
    

}
        public void modifierMaterial(int id,String Name_address, String Address, String Description)
{ try {
     String query ="UPDATE material SET Name_address= '"+Name_address+"',Address= '"+Address+"',Description= '"+Description+"' WHERE id='"+id+"'";
     Statement st=c.createStatement();
      st.executeUpdate(query) ;
      System.out.println("material has been modified");
} catch (SQLException ex){
            System.out.println(ex.getMessage()) ; 
            
        }
    
}
     public void supprimerparID (int id) {
        
        try { 
            String query ="DELETE FROM material WHERE id='"+id+"'" ; 
            Statement st=c.createStatement();
            st.executeUpdate(query); 
            System.out.println("material with id = "+id+" was deleted") ; 
            }
        catch(SQLException ex){
            System.out.println(ex.getMessage()) ; 
            
        }
    }
     public void supprimerparName (String Name_address) {
        
        try { 
            String query ="DELETE FROM material WHERE Name_address='"+Name_address+"'" ; 
            Statement st=c.createStatement();
            st.executeUpdate(query) ; 
            System.out.println("le material de Name_address= "+Name_address+" was deleted ") ;    
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage()) ; 
            
        }
    }  
}
