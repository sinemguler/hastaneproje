/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.tahliller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Util.DBConnection;

/**
 *
 * @author Sinem
 */
public class TahlillerDAO {

    private DBConnection db;
    private Connection c;
    private hastaDAO hastaDAO;
    private doktorDAO doktorDAO;

    public List<tahliller> gettahliller(int page, int pageSize) {
        List<tahliller> tlist = new ArrayList();

        int start = (page - 1) * pageSize;

        try {

            PreparedStatement pst = this.getC().prepareStatement("select * from tahliller");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                tahliller tmp = new tahliller();

                tmp.setId_tahlil(rs.getLong("id_tahlil"));
                tmp.setTipi(rs.getString("tipi"));
                rs.getLong("id_hasta");
                tmp.setH(this.getHastaDAO().find(rs.getLong("id_hasta")));
                rs.getLong("id_dok");
                tmp.setD(this.getDoktorDAO().find(rs.getLong("id_dok")));

                tlist.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return tlist;

    }

    public int count() {
        int count = 0;
        try {

            PreparedStatement pst = this.getC().prepareStatement("select count(id_tahlil)as tahliller_count from tahliller");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("tahliller_count");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;

    }

    public void insert(tahliller tahliller) {
        try {

            PreparedStatement pst = this.getC().prepareStatement("insert into tahliller(tipi ,id_hasta ,id_dok ) values (?,?,?)");
            pst.setString(1, tahliller.getTipi());
            pst.setLong(2, tahliller.getH().getId_hasta());
            pst.setLong(3, tahliller.getD().getId_dok());

            pst.executeUpdate();

        } catch (SQLException ex) {
        }

    }

    public void edit(tahliller tahliller) {
        try {

            PreparedStatement pst = this.getC().prepareStatement("update tahliller set tipi=?,id_hasta =?,id_dok =? where id_tahlil=?");
            pst.setString(1, tahliller.getTipi());
            pst.setLong(2, tahliller.getH().getId_hasta());
            pst.setLong(3, tahliller.getD().getId_dok());
            pst.setLong(4, tahliller.getId_tahlil());

            pst.executeUpdate();

        } catch (SQLException ex) {
        }
    }

    public void delete(tahliller tahliller) {
        try {
            PreparedStatement pst = this.getC().prepareStatement("delete from tahliller where id_tahlil=?");
            pst.setLong(1, tahliller.getId_tahlil());
            pst.executeUpdate();

        } catch (SQLException ex) {
        }
    }

    public hastaDAO getHastaDAO() {
        if (this.hastaDAO == null) {
            this.hastaDAO = new hastaDAO();
        }
        return hastaDAO;
    }

    public void setHastaDAO(hastaDAO hastaDAO) {
        this.hastaDAO = hastaDAO;
    }

    public doktorDAO getDoktorDAO() {
        if (this.doktorDAO == null) {
            this.doktorDAO = new doktorDAO();
        }
        return doktorDAO;
    }

    public void setDoktorDAO(doktorDAO doktorDAO) {
        this.doktorDAO = doktorDAO;
    }

    public DBConnection getDb() {
        if (this.db == null) {
            this.db = new DBConnection();
        }
        return db;
    }

    public Connection getC() {
        if (this.c == null) {
            this.c = this.getDb().connect();
        }
        return c;
    }

}
