package com.qlban.demospringboot.Repositorys;

import com.qlban.demospringboot.Repositorys.Entitys.LikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepoImp extends JpaRepository<LikeEntity,Integer> {

    LikeEntity findOneByIdsach(int id);

    List<LikeEntity> findOneByIduser(int id);
}
