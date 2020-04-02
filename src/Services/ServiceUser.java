/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.user;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import utils.ConnexionBD;

/**
 *
 * @author Memmicha
 */
public class ServiceUser {
    Connection c= ConnexionBD.getInstance().getCnx();
    
    public void ajouterUser(user u) throws SQLException {
  
        String requet="insert into user (id, username,email,password) values ('"+u.getId()+ "','"+u.getUsername()+"','"+u.getEmail()+"','"+u.getPassword()+"')" ; 
          
        try {
            Statement st=c.createStatement();
             
            st.executeUpdate(requet);
               System.out.println("Connected") ; 
            System.out.println("Added") ; 
    }
        catch(SQLException ex){
                       System.out.println(ex.getMessage()) ; 
        }
    }
    
    public void modifierUser (int id,String username,String email, String password)
{ try {
     String query ="UPDATE user SET username='"+username+"',email='"+email+"',password='"+password+"' WHERE id= '"+id+"'";
     Statement st=c.createStatement();
      st.executeUpdate(query) ;
      System.out.println("User has been modified");
} catch (SQLException ex){
            System.out.println(ex.getMessage()) ; 
            
        }
    
}
    
 public user chercherParId ( int id )
{                      user u = new user();
    try { 
            String query ="SELECT * FROM user WHERE id='"+id+"'" ; 
            Statement st=c.createStatement();
    ResultSet rst = st.executeQuery(query);
          rst.last();
         
          int nbr =rst.getRow() ;  
          if (nbr!=0)
          {     System.out.println("User was found");
                u.setId(rst.getInt(1));
                u.setUsername(rst.getString(2));
                u.setEmail(rst.getString(4));
                System.out.println("Username: "+u.getUsername()+" ,Email: "+u.getEmail());
          } else {
                  System.out.println("User wasn't found ") ; 
          }
                  
        }catch (SQLException ex){
            System.out.println(ex.getMessage()) ; 
            
        }
    return u;
}   
    
 public void chercherParNom ( String username )
{  try { 
            String query ="SELECT * FROM user WHERE username='"+username+"'" ; 
            Statement st=c.createStatement();
    ResultSet rst = st.executeQuery(query);
         rst.last();
          int nbr =rst.getRow() ;  
          if (nbr!=0)
          {
                  System.out.println("user was found ") ; 
                  
          } else {
                  System.out.println("user wasn't found ") ; 
          }     
        }catch (SQLException ex){
            System.out.println(ex.getMessage()) ; 
            
        }
}

  public void getUsers(user u){
         
 
String r="select * from user" ; 
try {
Statement stt=c.createStatement() ; 
ResultSet rs=stt.executeQuery(r); 
while(rs.next()) {
    user cl; 
    cl = new user();
    u.setId(rs.getInt(1));
    u.setUsername(rs.getString(2));
    u.setEmail(rs.getString(4));
       
}
          rs.last();
          int nbr =rs.getRow() ;  
          if (nbr!=0)
          {
                  System.out.println("Id: "+u.getId()+"Username: "+u.getUsername()+" ,Email: "+u.getEmail()) ; 
          } else {
                  System.out.println(" not found ") ; 
          }
}
catch (SQLException ex) {   
   
}
    
}   
    
 public void supprimerparID (int id) {
        
        try { 
            String query ="DElETE FROM user WHERE id="+id ; 
            Statement st=c.createStatement();
            st.executeUpdate(query) ; 
            System.out.println("The user with id = "+id+" has been deleted! ") ; 
           
            
        }catch (SQLException ex){
            System.out.println(ex.getMessage()) ; 
            
        }
    }
         
    
    
    
    
    
    
}
