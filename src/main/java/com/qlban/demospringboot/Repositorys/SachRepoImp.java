package com.qlban.demospringboot.Repositorys;

import com.qlban.demospringboot.Repositorys.Entitys.SachEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SachRepoImp extends JpaRepository<SachEntity, Integer> {
    SachEntity findOneByName(String name);

    SachEntity findOneById(int id);

    List<SachEntity> findByIddm(String idDanhMuc); // ignore

    @Query(value = "SELECT s FROM sach s WHERE s.s_gia_ban BETWEEN ?1 and ?2", nativeQuery = true)
    List<SachEntity> findByStartIntBetween(int giaban1, int giaban2);

    List<SachEntity> findAllByOrderByGiabanDesc();

    List<SachEntity> findAllByOrderByGiabanAsc();

    List<SachEntity> findAllByNameLike(String name);

    @Query(value = "SELECT s.* FROM sach s WHERE s.s_tac_gia LIKE ?1", nativeQuery = true)
    List<SachEntity> findByNameAuthor(String tacgia);

    @Query(value = "SELECT s.* FROM quyquang.sach s" +
            "JOIN  quyquang.yeuthich yt ON s.s_id = yt.Sach_s_id" +
            "WHERE yt.User_u_id = ?1",nativeQuery = true)
    List<SachEntity> findListFavoriteById(int id);

    @Query(value = "SELECT s.* FROM quyquang.sach s \n" +
            "JOIN quyquang.danhmuc dm ON s.s_dm_id = dm.dm_id\n" +
            "WHERE dm.dm_ten = '?1'",nativeQuery = true)
    List<SachEntity> findByCategoryName(String name);

    @Query(value = "SELECT s.* FROM quyquang.sach s \n" +
            "JOIN quyquang.user_sach us ON s.s_id = us.Sach_s_id\n" +
            "WHERE us.User_u_id = '?1'", nativeQuery = true)
    List<SachEntity> findBookListByIdUser(int id);
}
