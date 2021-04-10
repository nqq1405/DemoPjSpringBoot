package com.qlban.demospringboot.Repositorys.Entitys;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "User_SachEntity")
@Table(name = "user_sach")
@Getter @Setter
public class User_SachEntity {

    @Id
    @Column(name = "us_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "Sach_s_id")
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "Sach_s_id")
    @Column(name = "Sach_s_id")
    private int idsach;

    @Column(name = "User_u_id")
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "User_u_id")
    private int iduser;

    @Column(name = "us_create_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp createddate;

    @Column(name = "us_modifie_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")

    private Timestamp modifieddate;
}
