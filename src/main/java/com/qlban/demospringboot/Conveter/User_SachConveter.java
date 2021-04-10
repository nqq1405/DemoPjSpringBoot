package com.qlban.demospringboot.Conveter;


import com.qlban.demospringboot.Models.User_SachModel;
import com.qlban.demospringboot.Repositorys.Entitys.User_SachEntity;
import org.springframework.stereotype.Component;

@Component
public class User_SachConveter {

    public User_SachEntity toEntity(User_SachModel model) {
        User_SachEntity entity = new User_SachEntity();
        entity.setId(model.getId());
        entity.setIduser(model.getIdUser());
        entity.setIdsach(model.getIdSach());
        entity.setCreateddate(model.getCreatedDate());
        entity.setModifieddate(model.getModifiedDate());
        return entity;
    }

    public User_SachModel toModel(User_SachEntity entity) {
        User_SachModel model = new User_SachModel();
        model.setId(entity.getId());
        model.setIdUser(entity.getIduser());
        model.setIdSach(entity.getIdsach());
        model.setCreatedDate(entity.getCreateddate());
        model.setModifiedDate(entity.getModifieddate());
        return model;
    }
}
