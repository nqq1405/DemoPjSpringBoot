package com.qlban.demospringboot.Repositorys.Entitys;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity(name = "CategoryEntity")
@Table(name = "danhmuc")
@Getter @Setter
public class CategoryEntity {

    @Column(name = "dm_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "dm_ten")
    private String name;

}
