/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.Connection;
import Util.DBConnection;
/**
 *
 * @author Sinem
 */
abstract class BaseDao implements Cloneable  {
    private DBConnection connector;
    private Connection connection;

    public DBConnection getConnector() {
        if (this.connector == null) {
            this.connector = new DBConnection();
        }

        return connector;
    }

    public Connection getConnection() {
        if (this.connection == null) {
            this.connection = this.getConnector().connect();
        }
        return connection;
    }
}


