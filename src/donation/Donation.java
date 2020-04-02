/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donation;

import Entities.foundation;
import Entities.material;
import Entities.transaction;
import Entities.user;
import Services.ServiceFoundation;
import Services.ServiceMaterial;
import Services.ServiceTransaction;
import Services.ServiceUser;
import java.sql.Date;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import utils.ConnexionBD;


/**
 *
 * @author Memmicha
 */
public class Donation extends Application {

   
  
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException{
        launch(args);
    //connexionBD--------------------------------------------------------------------    
        ConnexionBD cnx1=ConnexionBD.getInstance();
        ConnexionBD cnx2=ConnexionBD.getInstance();
        System.out.println(cnx1.hashCode()+"//"+cnx2.hashCode()); 
        
        //material--------------------------------------------------------------------
        ServiceMaterial ms= new ServiceMaterial();
        material m = new material(1,"carrefour","25 rue Paris","hello"); 
        //ms.ajouterMaterial(m);
       // ms.ajouterMaterial1(m); 
        // ms.modifierMaterial(1,"carrefour","25 rue Tunis","hello");
       // ms.chercherParAddress("25 rue Tunis");
       // ms.chercherParType("carrefour");
       //ms.getMaterials(m); 
      // ms.getMaterials(1,m); // by ID
     // ms.supprimerparName("carrefour");
   //  ms.supprimerparID(39);
 //ms.UpdateMaterial(m);
      
    //transaction----------------------------------------------------------------------    
      ServiceTransaction ts = new ServiceTransaction();
        String str="2020-03-20";  
        Date date=Date.valueOf(str);//converting string into sql date  
     transaction t = new transaction (1,"james","bond",123456789, (Date) date,1000,"bla bla bla");
     // ts.AddTransaction(t);
        transaction t1 = new transaction (1,"mimicha","zouari",145236789, date,2000,"bla bla bla");
       // ts.AddTransaction(t1);
     // ts.modifierTransaction(1,"mimicha","memi",20202020, date,1500,"sousse");
        // ts.getTransactions(2,t);
      //  ts.supprimerparID(38);
     // ts.supprimerparName("james");
    // ts.chercherParAddress("bla bla bla");
     // ts.chercherParType("james");
      
      
    //foundation-----------------------------------------------------------------------
     ServiceFoundation fs = new ServiceFoundation();
      foundation f = new foundation(1,"pookie","sousse","bla bla bla",20354789,"pookie@gmail.com");  
      //fs.ajouterFoundation1(f);
     //fs.modifierFoundation(1,"pookie", "sousse", "hello", 25361456, "pookie@gmail.com");
      //fs.chercherParAddress("sousse");
     // fs.chercherParType("bobo");
       // fs.UpdateFoundation(f);
      //  fs.getFoundations(f);
      //fs.getFoundations(1, f);
     // fs.supprimerparID(2);
     
 //fosUser-----------------------------------------------------------------------------------
     ServiceUser us = new ServiceUser();
     user u = new user(2,"bobo","bobo@gmail.com","bobo");
     //us.ajouterUser(u);
     //us.modifierUser(2, "babou", "bobo@gmail.com", "babou");
     //us.chercherParId(2);
     //us.chercherParNom("babou");
     //us.getUsers(u);
     //us.supprimerparID(2);
     

     
     
     
     

     
    }   
}
