/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;

/**
 *
 * @author Sinem
 */
public class user {

    private Long user_id;
    private String userName;
    private String password;
    private String user_turu;

    private List<groupler> groupler;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_turu() {
        return user_turu;
    }

    public void setUser_turu(String user_turu) {
        this.user_turu = user_turu;
    }

    public List<groupler> getGroupler() {
        return groupler;
    }

    public void setGroupler(List<groupler> groupler) {
        this.groupler = groupler;
    }

    @Override
    public String toString() {
        return "user{" + "user_id=" + user_id + ", userName=" + userName + ", password=" + password + ", user_turu=" + user_turu + '}';
    }

}
