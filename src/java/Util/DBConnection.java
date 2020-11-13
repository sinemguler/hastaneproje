/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Sinem
 */
public class DBConnection {
    public static Connection getConnection(){
        Connection c = null;
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hastane?user=root&password=1905");
            
       } catch (Exception e) {
            System.out.println(e.getMessage());
    }
        return c;
}
    
   public static void close(Connection con) {
		try {
			con.close();
		} catch (Exception ex) {
		}
	}
}
