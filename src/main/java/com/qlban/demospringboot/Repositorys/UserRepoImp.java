package com.qlban.demospringboot.Repositorys;

import com.qlban.demospringboot.Repositorys.Entitys.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepoImp extends JpaRepository<UserEntity, Integer> {

    UserEntity findOneByUsername(String userName);

    UserEntity findOneById(int id);

    UserEntity findOneByEmail(String email);

    UserEntity findOneByToken(String token);

    @Query(value = "SELECT * FROM user u LIMIT ?1",nativeQuery = true)
    List<UserEntity> userListlimit(int limit);
}
