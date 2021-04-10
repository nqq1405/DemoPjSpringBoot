package com.qlban.demospringboot.Service;

import com.qlban.demospringboot.Repositorys.Entitys.UserEntity;
import com.qlban.demospringboot.Repositorys.UserRepoImp;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@Service
public class UserService {

    @Autowired
    UserRepoImp userRepoImp;

    public List<UserEntity> userEntityList(int limit){
        return userRepoImp.userListlimit(limit);
    }

    public UserEntity findOneByEmail(String email){
        UserEntity userEntity = userRepoImp.findOneByEmail(email);
        if (userEntity != null) {
            return userEntity;
        }
        return null;
    }

    public UserEntity findOneById(int id){
        UserEntity userEntity = userRepoImp.findOneById(id);
        if (userEntity != null) {
            return userEntity;
        }
        return null;
    }

    public void update(UserEntity userEntity){
        userRepoImp.save(userEntity);
    }

    public static void main(String[] args) {
        String patternPass = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}";
        String passtest = "xzca22A@@AB";
        String pattenrEmail = "\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b";
        String emailTest = " qwas20gmail@.com";
        String emailTest2 = "quang2@gmail.com";
        final Pattern VALID_EMAIL_ADDRESS_REGEX =
                Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        System.out.println(VALID_EMAIL_ADDRESS_REGEX.matcher(emailTest2).find());
        System.out.println(patternPass.matches(passtest));
        String gttest = "Nam|Nu";
        System.out.println(gttest.matches("Nam"));
    }
}
