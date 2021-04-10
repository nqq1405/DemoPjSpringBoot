package com.qlban.demospringboot.Models;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class UserModel {
    private int id;

    private String userName;

    private String passWord;

    private String name;

    private String ngaySinh; //dateOfBirth

    private String email;

    private String gioiTinh; // sex

    private String diaChi; // address

    private String sdt; // phoneNumber

    private String quyen; // role

    private String isDelete;

    private Timestamp createdTime;

    private Timestamp modifieTime;

    private String token;

    private Timestamp expiredTime;
}
