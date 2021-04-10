package com.qlban.demospringboot.Models;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class SachModel {

    private Integer id;

    private String name;

    private int idDanhMuc;

    private String moTa;

    private int giaNhap;

    private int giaBan;

    private String namXuatBan;

    private int soLuong;

    private String soTrang;

    private String createdBy;

    private Timestamp createdDate;

    private String modifieBy;

    private Timestamp modifieDate;
}
