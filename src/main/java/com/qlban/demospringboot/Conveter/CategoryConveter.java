package com.qlban.demospringboot.Conveter;


import com.qlban.demospringboot.Models.CategoryModel;
import com.qlban.demospringboot.Repositorys.Entitys.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryConveter {

    public CategoryEntity toEntity(CategoryModel model) {
        CategoryEntity entity = new CategoryEntity();
        entity.setId(model.getId());
        entity.setName(model.getName());
        return entity;
    }

    public CategoryModel toModel(CategoryEntity entity) {
        CategoryModel model = new CategoryModel();
        model.setId(entity.getId());
        model.setName(entity.getName());
        return model;
    }

}
