package com.qlban.demospringboot.Service;


import com.qlban.demospringboot.Repositorys.Entitys.UserEntity;
import com.qlban.demospringboot.Repositorys.UserRepoImp;
import com.qlban.demospringboot.Service.Valid.CheckedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.regex.Pattern;

@Service
public class RegisterService {

    @Autowired
    UserRepoImp userRepoImp;

    @Autowired
    CheckedService checkedService;

    /* đăng ký pass y/c
    ktra trùng User và gmail trong DB
    số 0-9, chữ hoa chữ thường
    ký tự đặc biệt
    8-20 ký tự
    none whitespace
    */ //note
    public boolean Registration(UserEntity userEntity) {
        if (userRepoImp.findOneByUsername(userEntity.getUsername()) == null) {
            if (checkedService.validEmail(userEntity.getEmail()) &&
                checkedService.validPassWord(userEntity.getPassword()) &&
                checkedService.validNumberPhone(userEntity.getSdt())) {

                    userEntity.setCreatedtime(new Timestamp(
                        System.currentTimeMillis()));
                    userEntity.setQuyen("USER");
                    userRepoImp.save(userEntity);
                    return true;
            }
        }
        return false;
    }
}
