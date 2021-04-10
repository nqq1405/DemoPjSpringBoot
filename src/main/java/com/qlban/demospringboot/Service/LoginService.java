package com.qlban.demospringboot.Service;


import com.qlban.demospringboot.Repositorys.Entitys.UserEntity;
import com.qlban.demospringboot.Repositorys.UserRepoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class LoginService {

    @Autowired
    private UserRepoImp userRepoImp;


    public boolean loginUser(UserEntity userEntity) { // đăng nhập
        UserEntity userEntity1 = userRepoImp.findOneByUsername(userEntity.getUsername());
        if (userEntity1 != null) {
            if (userEntity.getUsername().equals(userEntity1.getUsername())) {
                if (userEntity1.getPassword().equals(userEntity.getPassword()) &&
                        userEntity1.getQuyen().equals("USER")) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean loginAdmin(UserEntity userEntity) { // đăng nhập
        UserEntity userEntity1 = userRepoImp.findOneByUsername(userEntity.getUsername());
        if (userEntity1 != null) {
            if ((userEntity1.getUsername().equals(userEntity.getUsername()))) {
                if (userEntity1.getPassword().equals(userEntity.getPassword()) &&
                        userEntity1.getQuyen().equals("ADMIN")) {
                    return true;
                }
            }
        }
        return false;
    }

    //test
    public static void main(String[] args) {
        String patternPass = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}";
        String passtest = "xzca22A@@";
        String pattenrEmail = "\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b";
        String emailTest = " qwas20gmail@.com";
        String emailTest2 = "quang2@gmail.com";
        final Pattern VALID_EMAIL_ADDRESS_REGEX =
                Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        System.out.println(VALID_EMAIL_ADDRESS_REGEX.matcher(emailTest2).find());
        System.out.println(patternPass.matches(emailTest2));
        String gttest = "Nam|Nu";
        System.out.println(gttest.matches("Nam"));

    }
}
