package com.qlban.demospringboot.Controler;

import com.qlban.demospringboot.Controler.Request.ResetPass;
import com.qlban.demospringboot.Controler.Request.ResetPassRequest;
import com.qlban.demospringboot.Conveter.UserConveter;
import com.qlban.demospringboot.Models.UserModel;
import com.qlban.demospringboot.Repositorys.Entitys.UserEntity;
import com.qlban.demospringboot.Service.LoginService;
import com.qlban.demospringboot.Service.RegisterService;
import com.qlban.demospringboot.Service.ResetPassService;
import com.qlban.demospringboot.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserControler {

    @Autowired
    UserService userService;

    @Autowired
    RegisterService registerService;

    @Autowired
    ResetPassService resetPassService;

    @Autowired
    LoginService loginService;

    @Autowired
    UserConveter userConveter;

    ResetPassRequest resetPassRequest;

    @GetMapping(value = "/numberphone")
    public UserEntity findByNumberPhone(@RequestParam(name = "id") int id){
        return userService.findOneById(id);
    }

    @PutMapping(value = "/update")
    public String updateUserInfor(@RequestBody UserModel userModel){
        userService.update(userConveter.toEntity(userModel));
        return "ok";
    }

    @GetMapping(value = "/allueser")
    public List<UserModel> listUser(@RequestParam(name = "limit",defaultValue = "20") int limit){
        if (limit > 100){
            limit = 50;
        }
        List<UserEntity> userEntityList = userService.userEntityList(limit);
        List<UserModel> userModels = new ArrayList<>();
        for (UserEntity u: userEntityList) {
            userModels.add(userConveter.toModel(u));
        }
        return userModels;
    }

    @GetMapping(value = {"/login", "/"})
    public String login(@RequestBody UserEntity userEntity) {
        if (loginService.loginUser(userEntity)) {
            return "true";
        }
        return "false";
    }

    @PostMapping(value = "/register")
    public String insertUser(@RequestBody UserEntity userEntity) {
        if (registerService.Registration(userEntity)) {
            return "ok";
        }
        return "can't insert";
    }
    @GetMapping(value = "/reset-pass")
    public void fogot(@RequestBody String email) throws Exception {
        resetPassRequest = new ResetPassRequest(resetPassService.validAndSendToken(email), email);
    }

    @PostMapping(value = "/reset-pass") //
    public UserModel modifiePass(@RequestBody ResetPass resetPass) throws Exception {
        if (!(resetPass.getToken().equals(resetPassRequest.getToken()))) {
            throw new Exception("Token invalid");
        }
        resetPassService.addNewPass(resetPass.getNewPass());
        return userConveter.toModel(userService.findOneByEmail(resetPassRequest.getEmail()));
    }
}
