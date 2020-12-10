/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Util.DBCon;
import entity.user;
import Util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Sinem
 */
public class RegisterDao extends BaseDao {
    public static  void insert(String userName, String password) {
     //   DBConnection.connect();
         
        DBCon.getConnection();
        try {
             Statement sts = DBCon.getConnection().createStatement();
            String sql = "INSERT INTO user(userName,password) VALUES('" + userName + "','" + password + "','" + 0+ "','" + 0 + "')";
            sts.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
   

    }
    
    
}


