package com.qlban.demospringboot.Repositorys;

import com.qlban.demospringboot.Repositorys.Entitys.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepoImp extends JpaRepository<CategoryEntity, Integer> {

    @Query(value = "SELECT dm.* FROM danhmuc dm WHERE dm.dm_ten LIKE ?1",nativeQuery = true)
    CategoryEntity findByCategoryName(String name);

    CategoryEntity findOneByName(String name);
}
