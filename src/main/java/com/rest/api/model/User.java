package com.rest.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "psj_users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String user;
    private String pwd;
    private String profile_img;

//    @PrePersist
//    public void onSave(){
//        // create at and update at
//        DateTime currentDateTime = new DateTime();
//
//        this.createdAt = currentDateTime;
//        this.updatedAt = currentDateTime;
//    }
//
//    @PostPersist
//    public void onUpdate(){
//        // update at
//        DateTime currentDateTime = new DateTime();
//
//        this.updatedAt = currentDateTime;
//    }


}