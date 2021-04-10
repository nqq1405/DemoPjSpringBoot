package com.qlban.demospringboot.Models;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class User_SachModel {

    private int id;

    private int idSach;

    private int idUser;

    private Timestamp createdDate;

    private Timestamp modifiedDate;
}
