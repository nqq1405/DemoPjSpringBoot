package com.qlban.demospringboot.Repositorys.Entitys;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity(name = "UserEntity")
@Table(name = "user")
@Getter @Setter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "u_id")
    private int id;

//    @ManyToMany(mappedBy = "user_sachEntityList")
//    private List<SachEntity> userEntityList;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idsach")
//    Collection<User_SachEntity> user_sachEntityCollection;

    @Column(name = "u_username")
    private String username;

    @Column(name = "u_pass")
    private String password;

    @Column(name = "u_ho_ten")
    private String name;

    @Column(name = "u_ngay_sinh")
    private String ngaysinh; //dateOfBirth

    @Column(name = "u_email")
    private String email;

    @Column(name = "u_gioi_tinh")
    private String gioitinh; // sex

    @Column(name = "u_dia_chi")
    private String diachi; // address

    @Column(name = "u_dien_thoai")
    private String sdt; // phoneNumber

    @Column(name = "u_quyen")
    private String quyen; // role

    @Column(name = "u_is_delete")
    private String isdelete;

    @Column(name = "u_created_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp createdtime;

    @Column(name = "u_modifie_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp modifietime;

    @Column(name = "u_token")
    private String token;

    @Column(name = "u_expired_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp expiredtime;
}
