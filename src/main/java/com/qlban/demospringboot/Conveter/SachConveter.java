package com.qlban.demospringboot.Conveter;


import com.qlban.demospringboot.Models.SachModel;
import com.qlban.demospringboot.Repositorys.Entitys.SachEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SachConveter {

    public SachEntity toEntity(SachModel model) {
        SachEntity entity = new SachEntity();
        entity.setId(model.getId());
        entity.setName(model.getName());
        entity.setGianhap(model.getGiaNhap());
        entity.setGiaban(model.getGiaBan());
        entity.setIddm(model.getIdDanhMuc());
        entity.setMota(model.getMoTa());
        entity.setNamxuatban(model.getNamXuatBan());
        entity.setSoluong(model.getSoLuong());
        entity.setSotrang(model.getSoTrang());
        entity.setCreatedby(model.getCreatedBy());
        entity.setCreateddate(model.getCreatedDate());
        entity.setModifieby(model.getModifieBy());
        entity.setCreateddate(model.getModifieDate());
        return entity;
    }

    public SachModel toModel(SachEntity entity) {
        SachModel model = new SachModel();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setGiaNhap(entity.getGianhap());
        model.setGiaBan(entity.getGiaban());
        model.setIdDanhMuc(entity.getIddm());
        model.setMoTa(entity.getMota());
        model.setNamXuatBan(entity.getNamxuatban());
        model.setSoLuong(entity.getSoluong());
        model.setSoTrang(entity.getSotrang());
        model.setCreatedBy(entity.getCreatedby());
        model.setCreatedDate(entity.getCreateddate());
        model.setModifieBy(entity.getModifieby());
        model.setModifieDate(entity.getCreateddate());
        return model;
    }

    public List<SachEntity> toBookEntityList(List<SachModel> sachModelList){
        List<SachEntity> sachEntityList = new ArrayList<>();
        for (SachModel s : sachModelList) {
            sachEntityList.add(toEntity(s));
        }
        return sachEntityList;
    }

    public List<SachModel> toBookModelList(List<SachEntity> sachEntityList){
        List<SachModel> sachModelList = new ArrayList<>();
        for (SachEntity s : sachEntityList) {
            sachModelList.add(toModel(s));
        }
        return sachModelList;
    }

}
