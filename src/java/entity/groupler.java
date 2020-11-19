/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Sinem
 */
public class groupler {

    private Long group_id;
    private String group_name;

    public groupler(Long group_id, String group_name) { //CONSTRUCTOR
        this.group_id = group_id;
        this.group_name = group_name;
    }

    public groupler() {
    }

    public Long getGroup_id() { //GETTER SETTER
        return group_id;
    }

    public void setGroup_id(Long group_id) {
        this.group_id = group_id;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    @Override
    public String toString() {
        return "groupler{" + "group_id=" + group_id + ", group_name=" + group_name + '}';
    }

}
