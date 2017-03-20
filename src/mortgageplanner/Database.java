/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mortgageplanner;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Stuart
 */
public class Database {

    private boolean firstRun;
    private final File file = new File("mplanner.db");

    public boolean connectDB() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:mplanner.db");
            buildDatabase();
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MainDisplay.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    private void buildDatabase() {
        Statement build = null;
        Connection connection = null;
            try {
                connection = DriverManager.getConnection("jdbc:sqlite:mplanner.db");
                build = connection.createStatement();
                String sql = "CREATE TABLE IF NOT EXISTS \"clients\" ( 	`clientid`	INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE, 	`forename`	TEXT, 	`surname`	TEXT, 	`mdate`	TEXT, 	`children`	INTEGER, 	`email`	TEXT, 	`telephone`	NUMERIC, 	`address`	TEXT, 	`contacted`	TEXT )";
                build.executeUpdate(sql);
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public boolean addClient(String forename_, String surname_, String mdate_, int children_, String email_, String telephone_, String address_) {
        Statement stment;
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:mplanner.db");
            stment = connection.createStatement();
            String sql = "INSERT INTO CLIENTS (FORENAME,SURNAME,MDATE,CHILDREN, EMAIL, TELEPHONE, ADDRESS, CONTACTED) VALUES ('"+forename_+"', '"+surname_+"', '"+mdate_+"', "+children_+", '"+email_+"','"+telephone_+"','"+address_+"','false');";
            stment.executeUpdate(sql);
            connection.close();
            System.out.println("Client Added!");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

}
