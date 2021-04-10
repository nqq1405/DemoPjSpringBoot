package com.qlban.demospringboot.Repositorys.Entitys;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity(name = "SachEntity")
@Table(name = "sach")
@Getter
@Setter
public class SachEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "s_id")
    private int id;

    //Many to Many
   /* @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_sach",
            joinColumns = @JoinColumn(name = "Sach_s_id"),
            inverseJoinColumns = @JoinColumn(name = "User_u_id"))
    private Collection<UserEntity> user_sachEntityList;*/

    /*@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "yeuthich",
            joinColumns = @JoinColumn(name = "Sach_s_id"),
            inverseJoinColumns = @JoinColumn(name = "User_u_id"))
    Collection<UserEntity> likeEntityList;*/

    /*@OneToMany(fetch = FetchType.LAZY,mappedBy = "idsach")
    Collection<User_SachEntity> user_sachEntityCollection;*/

    @Column(name = "s_ten")
    private String name;

    @Column(name = "s_tac_gia")
    private String tacgia;

    @Column(name = "s_mo_ta")
    private String mota;

    @Column(name = "s_dm_id")
    /*@ManyToOne
    @JoinColumn(name = "s_dm_id")*/
    private int iddm;

    @Column(name = "s_gia_nhap")
    private int gianhap;

    @Column(name = "s_gia_ban")
    private int giaban;

    @Column(name = "s_nam_xuat_ban")
    private String namxuatban;

    @Column(name = "s_so_luong")
    private int soluong;

    @Column(name = "s_so_trang")
    private String sotrang;

    @Column(name = "s_created_by")
    private String createdby;

    @Column(name = "s_created_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp createddate;

    @Column(name = "s_modifie_by")
    private String modifieby;

    @Column(name = "s_modifie_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp modifiedate;
}
