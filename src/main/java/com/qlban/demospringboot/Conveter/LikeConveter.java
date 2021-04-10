package com.qlban.demospringboot.Conveter;


import com.qlban.demospringboot.Models.LikeModel;
import com.qlban.demospringboot.Repositorys.Entitys.LikeEntity;

public class LikeConveter {

    public LikeEntity toEntity(LikeModel model) {
        LikeEntity entity = new LikeEntity();
        entity.setId(model.getId());
        entity.setIdsach(model.getIdSach());
        entity.setIduser(model.getIdUser());
        return entity;
    }

    public LikeModel toModel(LikeEntity entity) {
        LikeModel model = new LikeModel();
        model.setId(entity.getId());
        model.setIdSach(entity.getIdsach());
        model.setIdUser(entity.getIduser());
        return model;
    }
}
