package com.qlban.demospringboot.Service;

import com.qlban.demospringboot.Repositorys.CategoryRepoImp;
import com.qlban.demospringboot.Repositorys.Entitys.SachEntity;
import com.qlban.demospringboot.Repositorys.Entitys.User_SachEntity;
import com.qlban.demospringboot.Repositorys.LikeRepoImp;
import com.qlban.demospringboot.Repositorys.SachRepoImp;
import com.qlban.demospringboot.Repositorys.User_SachRepoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    SachRepoImp sachRepoImp;

    @Autowired
    User_SachRepoImp user_sachRepoImp;

    @Autowired
    LikeRepoImp likeRepoImp;

    @Autowired
    CategoryRepoImp categoryRepoImp;

    public List<SachEntity> findByCategory(String name){
        return sachRepoImp.findByCategoryName(name);
    }

    public void deleteOneById(int id){
            sachRepoImp.deleteById(id);
    }

    public void deleteOneByBookEntity(SachEntity sachEntity) {
            sachRepoImp.delete(sachEntity);
    }

    public List<SachEntity> listFavorite(int idUser) throws Exception {
        List<SachEntity> sachEntityList =
                sachRepoImp.findListFavoriteById(idUser);
        if (sachEntityList.isEmpty()) {
            throw new Exception("List null");
        }
        return sachEntityList;
    }

    public List<SachEntity> findByAuthor(String nameAuthor) throws Exception {
        List<SachEntity> listSachEntity = sachRepoImp.findByNameAuthor(nameAuthor);
        if (listSachEntity.isEmpty()) {
            throw new Exception("list null");
        }
        return listSachEntity;
    }

    public List<SachEntity> findAllOrderByGiaban(String choose){
        if (choose != null) {
            switch (choose){
                case "1":{
                    return sachRepoImp.findAllByOrderByGiabanAsc();
                }
                case "-1":{
                    return sachRepoImp.findAllByOrderByGiabanDesc();
                }
                default:{
                    sachRepoImp.findAll();
                }
            }
        }
        return sachRepoImp.findAllByOrderByGiabanAsc();
    }

    public void addBook(SachEntity sachEntity, int id){
        sachRepoImp.save(sachEntity);
        User_SachEntity user_sachEntity = new User_SachEntity();
        user_sachEntity.setIdsach(sachEntity.getId());
        user_sachEntity.setIduser(id);
        user_sachRepoImp.save(user_sachEntity);
    }

    public void update(SachEntity sachEntity){
        sachRepoImp.save(sachEntity);
    }

    public List<SachEntity> getBookListUs(int id) throws Exception {
        List<SachEntity> sachEntityList =
                sachRepoImp.findBookListByIdUser(id);
        if (sachEntityList == null) {
            throw new Exception("User has not posted the book yet");
        }
        return sachEntityList;
    }

    public static void main(String[] args) {

    }
}
