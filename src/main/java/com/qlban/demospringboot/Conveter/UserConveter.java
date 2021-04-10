package com.qlban.demospringboot.Conveter;


import com.qlban.demospringboot.Models.UserModel;
import com.qlban.demospringboot.Repositorys.Entitys.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConveter {

    public UserEntity toEntity(UserModel model){
        UserEntity entity = new UserEntity();
        entity.setId(model.getId());
        entity.setUsername(model.getUserName());
        entity.setPassword(model.getPassWord());
        entity.setName(model.getName());
        entity.setNgaysinh(model.getNgaySinh());
        entity.setEmail(model.getEmail());
        entity.setGioitinh(model.getGioiTinh());
        entity.setDiachi(model.getDiaChi());
        entity.setSdt(model.getSdt());
        entity.setQuyen(model.getQuyen());
        entity.setIsdelete(model.getIsDelete());
        entity.setCreatedtime(model.getCreatedTime());
        entity.setModifietime(model.getModifieTime());
        entity.setToken(model.getToken());
        return entity;
    }
    public UserModel toModel(UserEntity entity){
        UserModel model = new UserModel();
        model.setId(entity.getId());
        model.setUserName(entity.getUsername());
        model.setPassWord(entity.getPassword());
        model.setName(entity.getName());
        model.setNgaySinh(entity.getNgaysinh());
        model.setEmail(entity.getEmail());
        model.setGioiTinh(entity.getGioitinh());
        model.setDiaChi(entity.getDiachi());
        model.setSdt(entity.getSdt());
        model.setQuyen(entity.getQuyen());
        model.setIsDelete(entity.getIsdelete());
        model.setCreatedTime(entity.getCreatedtime());
        model.setModifieTime(entity.getModifietime());
        model.setToken(entity.getToken());
        return model;
    }
}
