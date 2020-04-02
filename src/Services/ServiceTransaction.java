/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.transaction;
import java.sql.Connection;
import java.sql.Date;
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
public class ServiceTransaction {
    
                   Connection c= ConnexionBD.getInstance().getCnx();

     public  void AddTransaction (transaction t)  {

       String requet="INSERT INTO transaction (Name, Last_Name, RIB, Date_Expiration, Montant, address) VALUES (?,?,?,?,?,?)" ; 
        
        try {
            PreparedStatement ps = c.prepareCall(requet);
            ps.setString(1,t.getName());
            ps.setString(2,t.getLast_Name());
            ps.setDouble(3,t.getRIB());
            ps.setDate (4,t.getDate_Expiration());
            ps.setFloat(5,t.getMontant());
            ps.setString(6,t.getAddress());
            ps.executeUpdate();
           
        
        } catch (SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(ServiceMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
}
     
     public void modifierTransaction(int id, String Name,String Last_Name,double RIB,Date Date_Expiration, float Montant,String address)
{ try {
      String query ="UPDATE transaction SET Name= '"+Name+"',Last_Name= '"+Last_Name+"',RIB= '"+RIB+"',Date_Expiration= '"+Date_Expiration+"',Montant= '"+Montant+"',address= '"+address+"' WHERE id='"+id+"'";
     Statement st=c.createStatement();
      st.executeUpdate(query) ;
      System.out.println("transaction has been modified");
} catch (SQLException ex){
            System.out.println(ex.getMessage()) ; 
            
        }
    
}
     
     
      public void getTransactions(int id, transaction t){
 
String r="select * from transaction where id='"+id+"'" ; 
try {
Statement stt=c.createStatement() ; 
ResultSet rs=stt.executeQuery(r); 
while(rs.next()) {
    transaction c1; 
   c1 = new transaction();
   c1.setId(rs.getInt(1));
   c1.setName(rs.getString(2));
   c1.setLast_Name(rs.getString(3));
   c1.setRIB(rs.getDouble(4));
   c1.setDate_Expiration(rs.getDate(5));
   c1.setMontant(rs.getFloat(6));
   c1.setAddress(rs.getString(7));
   
}

  rs.last();
          int nbr =rs.getRow() ;  
          if (nbr!=0)
          {
                 System.out.println(", Name=" + t.getName() + ", Last_Name=" + t.getLast_Name()+ ", RIB=" +t.getRIB() + ", Date_Expiration=" + t.getDate_Expiration() + ", Montant=" + t.getMontant()+ ", address=" + t.getAddress()) ; 
          } else {
                  System.out.println(" transactions weren't found ") ; 
          }
        }
catch (SQLException ex) {
    System.out.println(ex.getMessage()) ;
}

} 
      
        public void getTransactions(transaction t){
         
 
String r="select * from transaction" ; 
try {
Statement stt=c.createStatement() ; 
ResultSet rs=stt.executeQuery(r); 
while(rs.next()) {
    transaction c1; 
   c1 = new transaction();
   c1.setId(rs.getInt(1));
   c1.setName(rs.getString(2));
   c1.setLast_Name(rs.getString(3));
   c1.setRIB(rs.getDouble(4));
   c1.setDate_Expiration(rs.getDate(5));
   c1.setMontant(rs.getFloat(6));
   c1.setAddress(rs.getString(7));
       
}
          rs.last();
          int nbr =rs.getRow() ;  
          if (nbr!=0)
          {
                  System.out.println("Id: "+t.getId()+", Name=" + t.getName() + ", Last_Name=" + t.getLast_Name()+ ", RIB=" +t.getRIB() + ", Date_Expiration=" + t.getDate_Expiration() + ", Montant=" + t.getMontant()+ ", address=" + t.getAddress()) ; 
          } else {
                  System.out.println(" transactions weren't found ") ; 
          }
}
catch (SQLException ex) {   
  
}

} 
  
            
      public void supprimerparID (int id) {
        
        try { 
            String query ="DELETE FROM transaction WHERE id='"+id+"'" ; 
            Statement st=c.createStatement();
            st.executeUpdate(query); 
            System.out.println("transaction with id = "+id+" was deleted") ; 
            }
        catch(SQLException ex){
            System.out.println(ex.getMessage()) ; 
            
        }
    }
       public void supprimerparName (String Name) {
        
        try { 
            String query ="DELETE FROM transaction WHERE Name='"+Name+"'" ; 
            Statement st=c.createStatement();
            st.executeUpdate(query) ; 
            System.out.println("le transaction de Name= "+Name+" was deleted ") ;    
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage()) ; 
            
        }
    }  
       
       public void chercherParType( String Name )
{  try { 
            String query ="SELECT * FROM transaction WHERE Name= '"+Name+"'" ; 
            Statement st=c.createStatement();
    ResultSet rst = st.executeQuery(query);
         rst.last();
          int nbr =rst.getRow() ;  
          if (nbr!=0)
          {
                  System.out.println(Name+" found ") ; 
          } else {
                  System.out.println(Name+" not found ") ; 
          }
                  
        }catch (SQLException ex){
            System.out.println(ex.getMessage()) ; 
            
        }
}
        public void chercherParAddress( String address )
{  try { 
            String query ="SELECT * FROM transaction WHERE address ='"+address+"'" ; 
            Statement st=c.createStatement();
    ResultSet rst = st.executeQuery(query);
         rst.last();
          int nbr =rst.getRow() ;  
          if (nbr!=0)
          {
                  System.out.println(address+" found ") ; 
          } else {
                  System.out.println(address+" not found") ; 
          }
                 }catch (SQLException ex){
            System.out.println(ex.getMessage()) ; 
            
        }
    

}
}
