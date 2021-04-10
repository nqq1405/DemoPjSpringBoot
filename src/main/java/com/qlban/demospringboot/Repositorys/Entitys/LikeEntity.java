package com.qlban.demospringboot.Repositorys.Entitys;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "LikeEntity")
@Table(name = "yeuthich")
@Getter @Setter
public class LikeEntity {
    @Id
    @Column(name = "y_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Sach_s_id")
    private int idsach;


    @Column(name = "User_u_id")
    private int iduser;
}
