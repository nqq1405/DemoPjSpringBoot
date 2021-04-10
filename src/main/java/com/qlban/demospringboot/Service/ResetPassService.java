package com.qlban.demospringboot.Service;


import com.qlban.demospringboot.Repositorys.Entitys.UserEntity;
import com.qlban.demospringboot.Repositorys.UserRepoImp;
import com.qlban.demospringboot.Service.SendEmail.RandomService;
import com.qlban.demospringboot.Service.SendEmail.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResetPassService {
    @Autowired
    RandomService randomService;
    @Autowired
    SendEmailService sendEmailService;
    @Autowired
    UserRepoImp userRepoImp;

    UserEntity userEntity;

    public String validAndSendToken(String email) throws Exception {
        userEntity = userRepoImp.findOneByEmail(email);
        if (userEntity == null) {
            throw new Exception("User with email " + email + " is not existed");
        }

        String tk = randomService.randomCharat(6);
        String content = "Token reset Pass for You: " + tk;
        String title = "Reset Pass Word";
        sendEmailService.sendEmail(title, email, content);
        return tk;
    }

    public void addNewPass(String newPass) {
        userEntity.setPassword(newPass);
        userRepoImp.save(userEntity);
    }
}
