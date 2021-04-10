package com.qlban.demospringboot.Repositorys;

import com.qlban.demospringboot.Repositorys.Entitys.User_SachEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface User_SachRepoImp extends JpaRepository<User_SachEntity,Integer> {

//    @Query(value = "SELECT * FROM user_sach us LEFT JOIN sach s `us`.`Sach_s_id` = `s`.`s_id`",nativeQuery = true)
//    public List<>

    List<User_SachEntity> findByIduser(int id);

}
